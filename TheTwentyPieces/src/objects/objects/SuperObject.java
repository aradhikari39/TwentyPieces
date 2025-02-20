package objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import MAIN.Game_panel;

public class SuperObject 
{
    public BufferedImage image;
    public String name;
    public boolean collision=false;
    public int worldx,worldy;
    public Rectangle solidArea=new Rectangle(0,0,48,48);
    public int solidAreaDefaultX=0;
    public int solidAreaDefaultY=0;

    public void draw(Graphics2D g2,Game_panel gp)
    {
        int screenX=worldx-gp.player.worldx+gp.player.screenX;
            int screenY=worldy-gp.player.worldy+gp.player.screenY;

            if( worldx +gp.tileSize>gp.player.worldx-gp.player.screenX &&
                worldx -gp.tileSize<gp.player.worldx+gp.player.screenX &&
                worldy + gp.tileSize> gp.player.worldy-gp.player.screenY &&
                worldy -gp.tileSize< gp.player.worldy+gp.player.screenY)
                                 
            {
                g2.drawImage(image,screenX,screenY,gp.tileSize,gp.tileSize, null );
            }
            
    }
}
