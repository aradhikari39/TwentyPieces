package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import MAIN.Game_panel;

public class TileManager 
{
    Game_panel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    
    public void loadMap(String filepath)
    {
        try
        {
            InputStream is = new FileInputStream(filepath);

            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            int col=0;
            int row=0;
           
            
            while(col<gp.maxWorldCol && row<gp.maxWorldRow)
            {
                String line=br.readLine();
                while(col<gp.maxWorldCol)
                {
                    String numbers[]=line.split(" ");
                    int num=Integer.parseInt(numbers[col]);
                    mapTileNum[col][row]=num;
                    col++;
                }
                if(col==gp.maxWorldCol)
                {
                    col=0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){}   




    }

    public TileManager(Game_panel gp)
    {
        this.gp=gp;
        tile =new Tile[10];
        getTileImage();    
        mapTileNum =new int[gp.maxWorldCol][gp.maxWorldRow];
        loadMap("C:/Users/user/Desktop/TwentyPieces/TheTwentyPieces/src/res/maps/map2.txt");
    }
    public void getTileImage()
    {
        try
        {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(new File("C:/Users/user/Desktop/TwentyPieces/TheTwentyPieces/src/res/tiles/beachrocks.png"));
            tile[0].collision=true;

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new File("C:/Users/user/Desktop/TwentyPieces/TheTwentyPieces/src/res/tiles/cactus.png"));
            tile[1].collision=true;

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(new File("C:/Users/user/Desktop/TwentyPieces/TheTwentyPieces/src/res/tiles/coconut.png"));
          

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(new File("C:/Users/user/Desktop/TwentyPieces/TheTwentyPieces/src/res/tiles/darksand.png"));
            tile[3].collision=true;
            

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(new File("C:/Users/user/Desktop/TwentyPieces/TheTwentyPieces/src/res/tiles/d1.png"));
            tile[4].collision=true;
           

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(new File("C:/Users/user/Desktop/TwentyPieces/TheTwentyPieces/src/res/tiles/desertmountain.png"));
            tile[5].collision=true;

            
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(new File("C:/Users/user/Desktop/TwentyPieces/TheTwentyPieces/src/res/tiles/d2.png"));
            tile[6].collision=true;

            
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(new File("C:/Users/user/Desktop/TwentyPieces/TheTwentyPieces/src/res/tiles/normal.png"));

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(new File("C:/Users/user/Desktop/TwentyPieces/TheTwentyPieces/src/res/tiles/normalsand.png"));

            
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(new File("C:/Users/user/Desktop/TwentyPieces/TheTwentyPieces/src/res/tiles/sinkingsand.png"));
            tile[9].collision=true;



        }catch(IOException e)
        {
            e.printStackTrace();
        }
        
    }

    public void draw(Graphics2D g2)
    {
        int worldCol=0;
        int worldRow=0;
    

        while(worldCol< gp.maxWorldCol && worldRow< gp.maxWorldRow)
        {
           
              

            int tileNum= mapTileNum[worldCol][worldRow];

            int worldx=worldCol*gp.tileSize;
            int worldy=worldRow*gp.tileSize;
            int screenX=worldx-gp.player.worldx+gp.player.screenX;
            int screenY=worldy-gp.player.worldy+gp.player.screenY;

            if( worldx +gp.tileSize>gp.player.worldx-gp.player.screenX &&
                worldx -gp.tileSize<gp.player.worldx+gp.player.screenX &&
                worldy + gp.tileSize> gp.player.worldy-gp.player.screenY &&
                worldy -gp.tileSize< gp.player.worldy+gp.player.screenY)
                                 
            {
                g2.drawImage(tile[tileNum].image,screenX,screenY,gp.tileSize,gp.tileSize, null );
            }
            
            worldCol++;
            
            if(worldCol==gp.maxWorldCol)
            {
                worldCol=0;
                
                worldRow++;
                
            }
        
        }
    }





}
