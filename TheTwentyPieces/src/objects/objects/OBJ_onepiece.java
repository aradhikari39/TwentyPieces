package objects;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_onepiece extends SuperObject  
{
    public OBJ_onepiece()
    {
        name="onepiece";
        try{
            image= ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/src/res/treasure/onepiece.png"));
        }catch(IOException e){e.printStackTrace();}

    }
}
