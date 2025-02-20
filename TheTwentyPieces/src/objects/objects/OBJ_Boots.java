package objects;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Boots extends SuperObject  
{
    public OBJ_Boots()
    {
        name="Boots";
        try{
            image= ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/res/treasure/onepiece.png"));
        }catch(IOException e){e.printStackTrace();}

    }
}
