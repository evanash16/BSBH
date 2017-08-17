package graphics;

import entities.TestEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GUI extends JFrame implements Runnable, KeyListener {

    private static Toolkit tk = Toolkit.getDefaultToolkit();
    public static Dimension SCREENSIZE = new Dimension(tk.getScreenResolution() * 8, tk.getScreenResolution() * 6);
    private Menu menu;
    private Game game;
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
        addKeyListener(this);

        menu = new Menu();
        game = new Game();

        this.add(menu);
        this.add(game);

        menu.setVisible(true);
        game.setVisible(false);

        testEntity = new TestEntity(getWidth() / 2, getHeight() / 2);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(menu.isVisible()){
            if(e.getKeyCode() == KeyEvent.VK_SPACE){
                menu.setVisible(false);
                game.setVisible(true);
            }
        }

        if(game.isVisible()){
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                game.setVisible(false);
                menu.setVisible(true);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void run() {
        while(true){
            try{
                if(menu.isVisible()){
                    menu.repaint();
                }
                if(game.isVisible()){
                    game.repaint();
                }
                Thread.sleep(1000/60);
            } catch(InterruptedException e) {e.printStackTrace();}
        }
    }
}
