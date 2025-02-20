package MAIN;


import objects.OBJ_bronze;
import objects.OBJ_gold;
import objects.OBJ_onepiece;
import objects.OBJ_silver;

public class AssetSetter 
{
    Game_panel gp;
    public AssetSetter(Game_panel gp)
    {
        this.gp=gp;
    }
    public void setObject()
    {
        gp.obj[0]=new OBJ_bronze();
        gp.obj[0].worldx=23*gp.tileSize;
        gp.obj[0].worldy=7*gp.tileSize;

        gp.obj[1]=new OBJ_bronze();
        gp.obj[1].worldx=23*gp.tileSize;
        gp.obj[1].worldy=40*gp.tileSize;

        gp.obj[2]=new OBJ_bronze();
        gp.obj[2].worldx=37*gp.tileSize;
        gp.obj[2].worldy=7*gp.tileSize;

        gp.obj[3]=new OBJ_silver();
        gp.obj[3].worldx=10*gp.tileSize;
        gp.obj[3].worldy=11*gp.tileSize;

        gp.obj[4]=new OBJ_silver();
        gp.obj[4].worldx=8*gp.tileSize;
        gp.obj[4].worldy=28*gp.tileSize;

        gp.obj[5]=new OBJ_silver();
        gp.obj[5].worldx=12*gp.tileSize;
        gp.obj[5].worldy=22*gp.tileSize;
        
        gp.obj[6]=new OBJ_gold();
        gp.obj[6].worldx=10*gp.tileSize;
        gp.obj[6].worldy=7*gp.tileSize;

        gp.obj[7]=new OBJ_onepiece();
        gp.obj[7].worldx=37*gp.tileSize;
        gp.obj[7].worldy=42*gp.tileSize;
    }
}
