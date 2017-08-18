package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class Pause extends JPanel implements KeyListener {

    private static String RESUME = "Press SPACE to Resume", EXIT = "Press ESCAPE To Return To Main";

    public Pause(){
        setSize(GUI.SCREENSIZE);
    }

    public void paint(Graphics g){
        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g2 = buffer.getGraphics();

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(g2.getColor().darker());
        g2.fillRect(getWidth() / 3, getHeight() / 4, getWidth() / 8, getHeight() / 2);
        g2.fillRect(2 * getWidth() / 3 - getWidth() / 8, getHeight() / 4, getWidth() / 8, getHeight() / 2);

        g2.setColor(Color.BLACK);
        g2.setFont(new Font(null, Font.BOLD, getHeight() / 20));
        int stringWidth = g2.getFontMetrics().stringWidth(RESUME);
        g2.drawString(RESUME, (getWidth() - stringWidth) / 2, getHeight() / 2 + g2.getFont().getSize());

        stringWidth = g2.getFontMetrics().stringWidth(EXIT);
        g2.drawString(EXIT, (getWidth() - stringWidth) / 2, getHeight() / 2 + 2 * g2.getFont().getSize());

        g.drawImage(buffer, 0, 0, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        if(isVisible()){
            if(e.getKeyCode() == KeyEvent.VK_SPACE){
                GUI.playGame();
            }
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
                GUI.showMenu();
            }
        }
    }
}
