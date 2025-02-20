package MAIN;

import javax.swing.JFrame;

public class main 
{
    public static void main(String[] args) 
    {
        JFrame window=new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        window.setResizable(false);
        Game_panel gamepanel=new Game_panel();
        window.add(gamepanel);
        window.pack();
        window.setTitle("2D Adventure");
        window.setLocationRelativeTo(null);
        window.setVisible(true);


        
        gamepanel.setUpGame();
        gamepanel.StartGameThread();
    }
}