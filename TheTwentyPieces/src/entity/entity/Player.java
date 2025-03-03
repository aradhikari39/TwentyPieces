package entity;

// import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
// import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

// import MAIN.AssetSetter;
import MAIN.Game_panel;

import MAIN.KeyHandler;
import objects.OBJ_gold;
import objects.OBJ_onepiece;
import objects.OBJ_silver;

public class Player extends Entity
{
    Game_panel gp;
    KeyHandler KeyH;
    public final int screenX;
    public final int screenY;
    public int hasbronze=0;
    public int hassilver=0;
    public int hasgold=0;
    public int hasonepiece=0;
    public Player(Game_panel gb, KeyHandler KeyH)
    {
        this.gp=gb;
        this.KeyH=KeyH;
        screenX=gp.screenWidth/2-(gp.tileSize/2);
        screenY=gp.screenHeight/2-(gp.tileSize/2);
        
        solidArea= new Rectangle();
        solidArea.x=8;
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultY=solidArea.y;
        solidArea.y=16;
        solidArea.width=32;
        solidArea.height=32;


        setDefaultValues();
        getPlayerImage();
    }
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/src/res/player/boyup1.png"));
            up2 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/src/res/player/boyup2.png"));
            down1 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/src/res/player/boydown1.png"));
            down2 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/src/res/player/boydown2.png"));
            right1 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/src/res/player/boyright1.png"));
            right2 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/src/res/player/boyright2.png"));
            left1 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/src/res/player/boyleft1.png"));
            left2 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/src/res/player/boyleft2.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      
    public void setDefaultValues()
    {
        worldx=gp.tileSize*38;
        worldy=gp.tileSize*89;
        speed=6;
        direction="down";
    }
    public void update()
    {
        //if (KeyH.upPressed==true || KeyH.downPressed==true || KeyH.leftPressed==true || KeyH.rightPressed==true)//this satement makes tagdamtagdam only when a key is pressed
        //{
        if(KeyH.upPressed==true)
        {
            direction= "up";
           
            
        }
        else if(KeyH.downPressed==true)
        {
            direction= "down";
            
            
        }
        else if(KeyH.rightPressed==true)
        {
            direction= "right";
            
            
        }
        else if(KeyH.leftPressed==true)
        {
            direction= "left";
            
           
        }
        
        //Check the collison
        collisionOn=false;
        gp.cChecker.checkTile(this);

        //check object collison
        int objIndex=gp.cChecker.checkObject(this, true);
        pickUpObject(objIndex);
        // if the collsion is false, the player can move
        if (KeyH.upPressed==true || KeyH.downPressed==true || KeyH.leftPressed==true || KeyH.rightPressed==true)
        {
            if(collisionOn==false)
            {
                switch(direction)
                {
                    case "up":   
                        worldy-=speed;
                        break;
                    case "down":
                    worldy+=speed;
                        break;
                    case "right":
                    worldx+=speed;
                        break;
                    case "left":
                    worldx-=speed;
                        break;
                }
            }
        }
        spriteCounter++;
        if(spriteCounter>10)
        {
            if(spriteNum==1)
            {
                spriteNum=2;
            }
            else if(spriteNum==2)
            {
                spriteNum=1;
            }
            spriteCounter=0;
        }
        // }
        
    }
    public void pickUpObject(int i)
    {
        if(i !=999  )
        {
            String objectName=gp.obj[i].name;
            switch(objectName)
            {
                case "bronze":
                    hasbronze++;
                    gp.obj[i]=null;
                    System.out.println("Bronze Treasure: "+ hasbronze);
                    gp.ui.showmessage("You found a Bronze!!!");
                    if (hasbronze ==10 ) 
                    {
                        


                        System.out.println("5 silver Coins have been scattered, grab it!!!!");
                        gp.ui.showmessage("5 silver Coins have been scattered, grab it!!!!");
                        gp.obj[10]=new OBJ_silver();
                        gp.obj[10].worldx=6*gp.tileSize;
                        gp.obj[10].worldy=1*gp.tileSize;
                        

                        gp.obj[11]=new OBJ_silver();
                        gp.obj[11].worldx=44*gp.tileSize;
                        gp.obj[11].worldy=24*gp.tileSize;

                        gp.obj[12]=new OBJ_silver();
                        gp.obj[12].worldx=98*gp.tileSize;
                        gp.obj[12].worldy=40*gp.tileSize;

                        gp.obj[13]=new OBJ_silver();
                        gp.obj[13].worldx=7*gp.tileSize;
                        gp.obj[13].worldy=94*gp.tileSize;

                        gp.obj[14]=new OBJ_silver();
                        gp.obj[14].worldx=81*gp.tileSize;
                        gp.obj[14].worldy=57*gp.tileSize;



                        
                       
                    }
                    break; 

                case "silver":
                    gp.obj[i]=null;
                    hassilver++;

                    if (hassilver == 5 )
                    { 
                        
                        gp.obj[15]=new OBJ_gold();
                        gp.obj[15].worldx=98*gp.tileSize;
                        gp.obj[15].worldy=17*gp.tileSize;

                        gp.obj[16]=new OBJ_gold();
                        gp.obj[16].worldx=30*gp.tileSize;
                        gp.obj[16].worldy=70*gp.tileSize;

                        gp.obj[17]=new OBJ_gold();
                        gp.obj[17].worldx=47*gp.tileSize;
                        gp.obj[17].worldy=2*gp.tileSize;
                    }
                    System.out.println("Silver Treasure: "+ hassilver);
                    gp.ui.showmessage("You found a Silver!!!");
                     
                    if (hassilver >= 5 )
                    {
                        System.out.println("3 Gold treasures have been scattered, Grab it!!!!");
                        gp.ui.showmessage("3 Gold treasures have been scattered, Grab it!!!!");
                    }
                    System.out.println("You found ultimate treasure");
                    gp.ui.gameFinished=true;
                
                    break;
                case "gold":
                    hasgold++;
                    gp.obj[i]=null;
                    if (hasgold == 3 )
                    { 
                        gp.obj[18] = new OBJ_onepiece();
                        gp.obj[18].worldx = 68 * gp.tileSize;
                        gp.obj[18].worldy = 12 * gp.tileSize;

                    }
                    System.out.println("Gold Treasure: "+ hasgold);
                    gp.ui.showmessage("You found Gold!!!");
                    if (hasgold >= 3 )
                    {
                        System.out.println("The ULTIMATE TREASURE, has appeared!!!");
                        gp.ui.showmessage("The ULTIMATE TREASURE, has appeared!!!");

                    }

            }
        }
    }




    public void draw(Graphics2D g2)
    {
        // g2.setColor(Color.WHITE);
 
        // g2.fillRect(x,y, gp.tileSize, gp.tileSize);(commented it out cause we are not going to use a rectangle anymore)
        BufferedImage image=null;
        switch (direction) {
            case "up":
                if(spriteNum==1)
                {
                    image=up1;
                }
                if(spriteNum==2)
                {
                    image=up2;
                }
                break;
        
            case "down":
                if(spriteNum==1)
                {
                    image=down1;
                }
                if(spriteNum==2)
                {
                    image=down2;
                }
                break;
            case "left":
                if(spriteNum==1)
                {
                    image=left1;
                }
                if(spriteNum==2)
                {
                    image=left2;
                }
                break;
            case "right":
                if(spriteNum==1)
                {
                    image=right1;
                }
                if(spriteNum==2)
                {
                    image=right2;
                }
                break;

        }
        g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize,null);



    }
}
 