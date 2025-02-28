package MAIN;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import entity.Player;
import objects.SuperObject;
import tile.TileManager;


 

public class Game_panel extends JPanel implements Runnable
{
    //Screen settings
    final int originalTilesize=16;
    final int scale=3;
    public final int tileSize= originalTilesize*scale;
    public final int maxScreencol=16;
    public final int maxScreenrow=12;
    public final int screenWidth=tileSize*maxScreencol; //768 pixel
    public final int screenHeight=tileSize*maxScreenrow; //576 pixels
     

    //World settings
    public final int maxWorldCol=100;
    public final int maxWorldRow=100;
    public final int maxWorldWidth=tileSize*maxWorldCol;
    public final int maxWorldHeight=tileSize*maxWorldRow;
    // FPS
    int FPS=60;

    TileManager tileM=new TileManager(this);
    KeyHandler KeyH=new KeyHandler();
    
    public Player player=new Player(this,KeyH);
    Thread gameThread;
    public CollisonChecker cChecker=new CollisonChecker(this);
    public AssetSetter aSetter=new AssetSetter(this);
    public SuperObject obj[]=new SuperObject[20];
    

    public void setUpGame()
    {
        aSetter.setObject();
    }
    public void StartGameThread()
    {
        gameThread= new Thread(this);
        gameThread.start();
    }
    // @Override
    // public void run()
    // {

    //     double drawInterval=1000000000/FPS; //gives 0.166---drawinterval means we draw our screen every o.166seconds
    //     double nextDrawTime=System.nanoTime()+drawInterval;
    //     while(gameThread!=null)
    //     {
    //         // System.out.println("The game is running");
    //         long currentTime=System.nanoTime();
    //         // long currentTime2=System.currentTimeMillis();
    //         System.out.println(currentTime);
    //         // Update: update information such as character positions
    //         update();
    //         // Draw: draw the scene with the updated information
    //         repaint();
    //         try
    //         {
    //             double remainingTime=nextDrawTime-System.nanoTime();
    //             remainingTime=remainingTime/1000000;
    //             if(remainingTime<0)
    //             {
    //                 remainingTime=0;
    //             }
    //             Thread.sleep((long)remainingTime);
    //             nextDrawTime +=drawInterval;
    //         }
    //         catch(InterruptedException e)
    //         {
    //             e.printStackTrace();
    //         }

    //     }
    // }
    @Override
    public void run()
    {
        double drawInterval=1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        // long timer=0;
        // int drawcount=0;
        while(gameThread!=null)
        {
            currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;
            // timer+=(currentTime-lastTime);
            lastTime=currentTime;
            if (delta>=1) 
            {
                update();
                repaint();
                delta--;    
                // drawcount++;
            }
            // if (timer>=1000000000)
            // {
            //     System.out.println("FPS: "+drawcount);
            //     drawcount=0;
            //     timer=0;
            // }
        }

    }
    public void update()
    {
        player.update();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        //Tile 
        tileM.draw(g2);
        // object
        for(int i=0; i<obj.length;i++)
        {
            if(obj[i]!=null)
            {
                obj[i].draw(g2,this);
            }
        }
        //player
        player.draw(g2);
        
        
        
        g2.dispose();

 
    }

    public Game_panel()
    {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);
        
    }





}
 

