package objects;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_gold extends SuperObject
{
    public OBJ_gold()
    {
        name="Chest";
        try{
            image= ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/res/treasure/gold.png"));
        }catch(IOException e){e.printStackTrace();}

    }
}


