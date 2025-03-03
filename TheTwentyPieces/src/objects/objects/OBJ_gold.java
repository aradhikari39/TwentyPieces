package objects;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_gold extends SuperObject
{
    public OBJ_gold()
    {
        name="gold";
        try{
            image= ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/src/res/treasure/gold.png"));
        }catch(IOException e){e.printStackTrace();}

    }
}


