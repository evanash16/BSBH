package graphics;

import entities.TestEntity;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame implements Runnable {

    private static Toolkit tk = Toolkit.getDefaultToolkit();
    public static Dimension SCREENSIZE = new Dimension(tk.getScreenResolution() * 8, tk.getScreenResolution() * 6);
    private static Menu menu;
    private static Game game;
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

        add(menu);
        addKeyListener(menu);
        menu.setVisible(true);

        add(game);
        addKeyListener(game);
        game.setVisible(false);

        setVisible(true);
    }

    public static void showGame(){
        menu.setVisible(false);
        game.setVisible(true);
    }

    public static void showMenu(){
        game.setVisible(false);
        menu.setVisible(true);
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
                Thread.sleep(1000/60);
            } catch(InterruptedException e) {e.printStackTrace();}
        }
    }
}
