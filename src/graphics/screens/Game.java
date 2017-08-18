package graphics.screens;

import entities.Entity;
import entities.TestEntity;
import graphics.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Game extends JPanel implements KeyListener {

    private static String PAUSE = "Press ESCAPE To Pause", INSTRUCTION = "Press +/- To Add/Remove Entities";
    private ArrayList<Entity> entities = new ArrayList<>();

    public Game(){
        setSize(GUI.SCREENSIZE);
    }

    public void paint(Graphics g){
        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g2 = buffer.getGraphics();

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(g2.getColor().darker());
        g2.setFont(new Font(null, Font.BOLD, getHeight() / 20));
        int stringWidth = g2.getFontMetrics().stringWidth(PAUSE);
        g2.drawString(PAUSE, (getWidth() - stringWidth) / 2, getHeight() / 2);

        g2.setFont(new Font(null, Font.BOLD, getHeight() / 50));
        stringWidth = g2.getFontMetrics().stringWidth(INSTRUCTION);
        g2.drawString(INSTRUCTION, (getWidth() - stringWidth) / 2, 7 * getHeight() / 8);

        graphics.Renderer.draw(g2);

        g.drawImage(buffer, 0, 0, null);
    }

    public void update(){
        for(Entity e: entities){
            e.update();
            graphics.Renderer.addToQueue(e);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        if(isVisible()){
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                GUI.pause();
            }
            if(e.getKeyCode() == KeyEvent.VK_EQUALS) {
                entities.add(new TestEntity(getWidth() / 2, getHeight() / 2));
            }
            if(e.getKeyCode() == KeyEvent.VK_MINUS) {
                if(entities.size() > 0){
                    entities.remove(entities.size() - 1); //This removal process causes ConcurrentModificationExceptions.
                    // I think we have to be smarter about removal.
                }
            }
        }
    }
}
