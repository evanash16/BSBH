package graphics;

import entities.TestEntity;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame implements Runnable {

    private static Toolkit tk = Toolkit.getDefaultToolkit();
    public static Dimension SCREENSIZE = new Dimension(tk.getScreenResolution() * 8, tk.getScreenResolution() * 6);
    private static Game game;
    private static Menu menu;
    private static Pause pause;
    private TestEntity testEntity;

    public static void main(String[] args) {
        Runnable r = new GUI();
        Thread t = new Thread(r);
        t.start();
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
        addKeyListener(pause);
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
            try{
                if(menu.isVisible()){
                    menu.repaint();
                }
                if(game.isVisible()){
                    game.update();
                    game.repaint();
                }
                if(pause.isVisible()){
                    pause.repaint();
                }
                Thread.sleep(1000/60);
            } catch(InterruptedException e) {e.printStackTrace();}
        }
    }
}
