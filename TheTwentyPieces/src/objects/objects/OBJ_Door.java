package objects;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject
{
    public OBJ_Door()
    {
        name="Door";
        try{
            image= ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/res/treasure/silver.png"));
        }catch(IOException e){e.printStackTrace();}
        collision=true;
    }
    
}
