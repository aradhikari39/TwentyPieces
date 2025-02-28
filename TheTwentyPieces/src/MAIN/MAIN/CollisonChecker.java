package MAIN;

import entity.Entity;

public class CollisonChecker 
{
    Game_panel gp;
    public CollisonChecker(Game_panel gp)
    {
        this.gp=gp;
    }
    
    public void checkTile(Entity entity)
    {
        
        
        int entityLeftWorldx=entity.worldx+entity.solidArea.x;
        int entityRightWorldx=entity.worldx+entity.solidArea.x+entity.solidArea.width;

        int entityTopWorldy=entity.worldy+entity.solidArea.y;
        int entityBottomWorldy=entity.worldy+entity.solidArea.y+entity.solidArea.height;


        int entityLeftCol=entityLeftWorldx/gp.tileSize;
        int entityRightCol=entityRightWorldx/gp.tileSize;

        int entityTopRow=entityTopWorldy/gp.tileSize;
        int entityBottomRow=entityBottomWorldy/gp.tileSize;

        int tileNum1,tileNum2;

        switch(entity.direction)
        {
            case "up":
                entityTopRow=(entityTopWorldy-entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2=gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision==true)
                {
                    entity.collisionOn=true;
                }
                break;
            case "down":
                entityBottomRow=(entityBottomWorldy+entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2=gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision==true)
                {
                    entity.collisionOn=true;
                }
                break;
            case "right":
                entityRightCol=(entityRightWorldx+entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2=gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision==true)
                {
                    entity.collisionOn=true;
                }
                break;
            case "left":
                entityLeftCol=(entityLeftWorldx-entity.speed)/gp.tileSize;
                tileNum1=gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2=gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision==true || gp.tileM.tile[tileNum2].collision==true)
                {
                    entity.collisionOn=true;
                }
                break;

        }
    }
    public int checkObject(Entity entity,boolean player)
    {
        int index=999;
        for(int i=0;i<gp.obj.length;i++)
        {
            if( gp.obj[i]!=null)
            {
                //get entity's solid area position
                entity.solidArea.x=entity.worldx+entity.solidArea.x;
                entity.solidArea.y=entity.worldy+entity.solidArea.y;
                //get the objects's solid area position
                gp.obj[i].solidArea.x=gp.obj[i].worldx+gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y=gp.obj[i].worldy+gp.obj[i].solidArea.y;


                switch (entity.direction) 
                {
                    case "up":
                        entity.solidArea.y-=entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea))
                        {
                            if(gp.obj[i].collision==true)
                            {
                                entity.collisionOn=true;
                            }
                            if(player==true)
                            {
                                index=i;
                            }
                        }
                        break;
                
                    case "down":
                    entity.solidArea.y+=entity.speed;
                    if(entity.solidArea.intersects(gp.obj[i].solidArea))
                        {
                            if(gp.obj[i].collision==true)
                            {
                                entity.collisionOn=true;
                            }
                            if(player==true)
                            {
                                index=i;
                                System.out.println("Player is colliding with: " + gp.obj[i].name);
                            }
                        }
                        break;
                    case "left":
                    entity.solidArea.x-=entity.speed;
                    if(entity.solidArea.intersects(gp.obj[i].solidArea))
                        {
                            if(gp.obj[i].collision==true)
                            {
                                entity.collisionOn=true;
                            }
                            if(player==true)
                            {
                                index=i;
                            }
                        }
                        break;
                    case "right":
                    entity.solidArea.x+=entity.speed;
                    if(entity.solidArea.intersects(gp.obj[i].solidArea))
                        {
                            if(gp.obj[i].collision==true)
                            {
                                entity.collisionOn=true;
                            }
                            if(player==true)
                            {
                                index=i;
                            }
                        }
                        break;
        
                }
                entity.solidArea.x=entity.solidAreaDefaultX;
                entity.solidArea.y=entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x=gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y=gp.obj[i].solidAreaDefaultY;
            }
           
        }
        return index;
    }
}

