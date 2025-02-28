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
        gp.obj[0].worldx=23*gp.tileSize;
        gp.obj[0].worldy=7*gp.tileSize;

        gp.obj[1]=new OBJ_bronze();
        gp.obj[1].worldx=23*gp.tileSize;
        gp.obj[1].worldy=40*gp.tileSize;

        gp.obj[2]=new OBJ_bronze();
        gp.obj[2].worldx=37*gp.tileSize;
        gp.obj[2].worldy=7*gp.tileSize;

        

        

        

        
        
        

     
    }
}
