package MAIN;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import objects.OBJ_bronze;
import objects.OBJ_gold;
import objects.OBJ_silver;
public class UI 
{
    Game_panel gp;
    public Font arial_40,arial_80B,arial_40T;
    BufferedImage BronzeImage;
    BufferedImage SilverImage;
    BufferedImage GoldImage;
    public boolean messageOn=false;
    public  String message="";
    int messageCounter=0;
    public boolean gameFinished=false;
    double playTime;
    DecimalFormat dFormat =new DecimalFormat("#0.00");

    public UI(Game_panel gp)
    {
        this.gp=gp; 
        arial_40=new Font("Arial",Font.PLAIN,20);
        arial_80B=new Font("Arial",Font.BOLD,20);
        arial_40T=new Font("Arial",Font.PLAIN,40);
        OBJ_bronze bronze=new OBJ_bronze();
        OBJ_silver silver=new OBJ_silver();
        OBJ_gold gold=new OBJ_gold();
        BronzeImage=bronze.image;
        SilverImage=silver.image;
        GoldImage=gold.image;
    }

    public void showmessage(String text)
    {
        message=text;
        messageOn=true;
    }
    public void draw(Graphics2D g2)
    {

        if(gameFinished==true)
        {
            g2.setFont(arial_40);
            g2.setColor(Color.WHITE); 
            String text;
            int textLength;
            int x,y;

            text="You did it!!! You Found the ultimate Treasue!!!";
            textLength=(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x=gp.screenWidth/2-textLength/2;
            y= gp.screenHeight/2-(gp.tileSize*3);
            g2.drawString(text,x,y);    


            g2.setFont(arial_80B);
            g2.setColor(Color.yellow);
            text="Congratulations!!!";
            textLength=(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x=gp.screenWidth/2-textLength/2;
            y= gp.screenHeight/2+(gp.tileSize*2);
            g2.drawString(text,x,y);     


            int minutes = (int) (playTime / 60);
            int seconds = (int) (playTime % 60);
            text = String.format("Your Time is: %02d:%02d!", minutes, seconds);
            textLength=(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x=gp.screenWidth/2-textLength/2;
            y= gp.screenHeight/2-(gp.tileSize*4);
            g2.drawString(text,x,y);  

            gp.gameThread=null;

        }
        else
        {
            g2.setFont(arial_40T);
            g2.setColor(Color.WHITE);
            g2.drawImage(BronzeImage,gp.tileSize/4, gp.tileSize/4,gp.tileSize, gp.tileSize,null);
            g2.drawString(" "+gp.player.hasbronze, 54, 47);

            if(gp.player.hasbronze==10)
            {
                g2.setFont(arial_40T);
                g2.setColor(Color.WHITE);

                int silverX = gp.tileSize / 4; 
                int silverY = (gp.tileSize / 4) + gp.tileSize + 10; 
                g2.drawImage(SilverImage, silverX, silverY, gp.tileSize, gp.tileSize, null);
                g2.drawString(" " + gp.player.hassilver, silverX + 42, 99);

            }

            if(gp.player.hassilver==5)
            {
                g2.setFont(arial_40T);
                g2.setColor(Color.WHITE);

                int goldX = gp.tileSize / 4; 
                int goldY = (gp.tileSize / 4) + gp.tileSize + 8+ gp.tileSize + 8; 
                g2.drawImage(GoldImage, goldX, goldY, gp.tileSize, gp.tileSize, null);
                g2.drawString(" " + gp.player.hasgold, goldX + 42, 165);

            }

             
            //time
            playTime +=(double)1/60;
            int minutes = (int) (playTime / 60);
            int seconds = (int) (playTime % 60);
            String timeDisplay = String.format("Time: %02d:%02d", minutes, seconds);
            g2.drawString(timeDisplay, gp.tileSize*11, 47);;
    
            //
            if(messageOn==true)
            {
                g2.setFont(g2.getFont().deriveFont(20F));
                g2.drawString(message, gp.tileSize/2, gp.tileSize*5);
    
                messageCounter++;
    
                if(messageCounter>120)
                {
                    messageCounter=0;
                    messageOn=false;
                }
            }
       
        }
    }
}
