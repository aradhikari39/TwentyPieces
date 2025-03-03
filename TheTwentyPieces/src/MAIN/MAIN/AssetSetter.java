package MAIN;


import objects.OBJ_bronze;
// import objects.OBJ_gold;
// import objects.OBJ_onepiece;
// import objects.OBJ_silver;

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
        gp.obj[0].worldx=98*gp.tileSize;
        gp.obj[0].worldy=57*gp.tileSize;

        gp.obj[1]=new OBJ_bronze();
        gp.obj[1].worldx=42*gp.tileSize;
        gp.obj[1].worldy=26*gp.tileSize;

        gp.obj[2]=new OBJ_bronze();
        gp.obj[2].worldx=74*gp.tileSize;
        gp.obj[2].worldy=31*gp.tileSize;

        gp.obj[3]=new OBJ_bronze();
        gp.obj[3].worldx=79*gp.tileSize;
        gp.obj[3].worldy=98*gp.tileSize;

        gp.obj[4]=new OBJ_bronze();
        gp.obj[4].worldx=74*gp.tileSize;
        gp.obj[4].worldy=71*gp.tileSize;

        gp.obj[5]=new OBJ_bronze();
        gp.obj[5].worldx=74*gp.tileSize;
        gp.obj[5].worldy=51*gp.tileSize;

        gp.obj[6]=new OBJ_bronze();
        gp.obj[6].worldx=24*gp.tileSize;
        gp.obj[6].worldy=35*gp.tileSize;

        gp.obj[7]=new OBJ_bronze();
        gp.obj[7].worldx=96*gp.tileSize;
        gp.obj[7].worldy=9*gp.tileSize;

        gp.obj[8]=new OBJ_bronze();
        gp.obj[8].worldx=34*gp.tileSize;
        gp.obj[8].worldy=98*gp.tileSize;

        gp.obj[9]=new OBJ_bronze();
        gp.obj[9].worldx=25*gp.tileSize;
        gp.obj[9].worldy=77*gp.tileSize;


        

        

        
        
        

     
    }
}
