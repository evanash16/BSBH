package graphics;

import entities.TestEntity;
import graphics.screens.Game;
import graphics.screens.Menu;
import graphics.screens.Pause;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame implements Runnable {

    private static Toolkit tk = Toolkit.getDefaultToolkit();
    public static Dimension SCREENSIZE = new Dimension(tk.getScreenResolution() * 8, tk.getScreenResolution() * 6);
    private static Game game;
    private static graphics.screens.Menu menu;
    private static Pause pause;

    public static void main(String[] args) {
        Runnable r = new GUI();
        Thread draw = new Thread(r, "draw");
        Thread update = new Thread(r, "update");
        draw.start();
        update.start();
    }

    public GUI() {
        super("BubbleSafezoneBridgeHardhat");
        init();
    }

    public void init(){

        setSize(SCREENSIZE);
        setLocation((tk.getScreenSize().width - getWidth()) / 2, (tk.getScreenSize().height - getHeight()) / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false); //it makes everything easier

        menu = new Menu();
        game = new Game();
        pause = new Pause();

        add(menu);
        addKeyListener(menu);
        menu.setVisible(true);

        add(game);
        addKeyListener(game);
        game.setVisible(false);

        add(pause);
        addMouseListener(pause);
        addMouseMotionListener(pause);
        pause.setVisible(false);

        setVisible(true);
    }

    public static void playGame(){
        menu.setVisible(false);
        pause.setVisible(false);
        game.setVisible(true);
    }

    public static void showMenu(){
        game.setVisible(false);
        pause.setVisible(false);
        menu.setVisible(true);
    }

    public static void pause(){
        game.setVisible(false);
        pause.setVisible(true);
    }

    @Override
    public void run() {
        while(true){
            Thread t = Thread.currentThread();
            try{
                if("draw".equals(t.getName())){
                    if(menu.isVisible()){
                        menu.repaint();
                    }
                    if(game.isVisible()){
                        game.draw();
                        game.repaint();
                    }
                    if(pause.isVisible()){
                        pause.repaint();
                    }
                } else if("update".equals(t.getName())){
                    game.update();
                }
                Thread.sleep(1000/60);
            } catch(InterruptedException e) {e.printStackTrace();}
        }
    }
}
