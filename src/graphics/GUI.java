package graphics;

import entities.TestEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GUI extends JFrame implements Runnable {

    private static Toolkit tk = Toolkit.getDefaultToolkit();
    public static Dimension SCREENSIZE = new Dimension(tk.getScreenResolution() * 8, tk.getScreenResolution() * 6);
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

        testEntity = new TestEntity(getWidth() / 2, getHeight() / 2);
        setVisible(true);
    }

    public void paint(Graphics g) {
        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g2 = buffer.getGraphics();

        Renderer.draw(g2);

        g.drawImage(buffer, 0, 0, null);
    }

    public void update() {
        testEntity.update();
        Renderer.addToQueue(testEntity);
    }

    @Override
    public void run() {
        while(isActive()){
            try{
                update();
                repaint();
                Thread.sleep(17);
            } catch(InterruptedException e){e.printStackTrace();}
        }
    }
}
