package objects;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_silver extends SuperObject
{
    public OBJ_silver()
    {
        name="silver";
        try{
            image= ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/res/treasure/silver.png"));
        }catch(IOException e){e.printStackTrace();}
        collision=true;
    }
    
}
