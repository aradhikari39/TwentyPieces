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
    int hasbronze=0;
    int hassilver=0;
    int hasgold=0;
    int hasonepiece=0;
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
            up1 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/res/player/boyup1.png"));
            up2 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/res/player/boyup2.png"));
            down1 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/res/player/boydown1.png"));
            down2 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/res/player/boydown2.png"));
            right1 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/res/player/boyright1.png"));
            right2 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/res/player/boyright2.png"));
            left1 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/res/player/boyleft1.png"));
            left2 = ImageIO.read(new File("c:/Users/User/Desktop/TwentyPieces/TheTwentyPieces/res/player/boyleft2.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      
    public void setDefaultValues()
    {
        worldx=gp.tileSize*38;
        worldy=gp.tileSize*89;
        speed=4;
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
                    if (hasbronze ==3 ) 
                    {
                        gp.obj[3]=new OBJ_silver();
                        gp.obj[3].worldx=10*gp.tileSize;
                        gp.obj[3].worldy=11*gp.tileSize;
                        System.out.println("The One Piece has appeared!");

                        gp.obj[4]=new OBJ_silver();
                        gp.obj[4].worldx=8*gp.tileSize;
                        gp.obj[4].worldy=28*gp.tileSize;

                        gp.obj[5]=new OBJ_silver();
                        gp.obj[5].worldx=12*gp.tileSize;
                        gp.obj[5].worldy=22*gp.tileSize;

                        
                       
                    }
                    break; 

                case "silver":
                    gp.obj[i]=null;
                    hassilver++;

                    if (hassilver == 3 )
                    { 
                        gp.obj[6]=new OBJ_gold();
                        gp.obj[6].worldx=10*gp.tileSize;
                        gp.obj[6].worldy=7*gp.tileSize;
                    }
                    System.out.println("Silver Treasure: "+ hassilver);
                    break;


                case "onepiece":
                
                    gp.obj[i]=null;
                    hasonepiece++;
                    System.out.println("The One Piece: Attained");
                
                    break;
                case "gold":
                    hasgold++;
                    gp.obj[i]=null;
                    if (hasgold == 1 )
                    { 

                        gp.obj[7] = new OBJ_onepiece();
                        gp.obj[7].worldx = 37 * gp.tileSize;
                        gp.obj[7].worldy = 42 * gp.tileSize;

                    }
                    System.out.println("Gold Treasure: "+ hasgold);

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
 