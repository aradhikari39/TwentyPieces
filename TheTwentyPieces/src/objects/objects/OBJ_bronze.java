package objects;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_bronze extends SuperObject
{
    public OBJ_bronze()
    {
        name="bronze";
        try{
            image= ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/src/res/treasure/bronze.png"));
        }catch(IOException e){e.printStackTrace();}

    }
}
