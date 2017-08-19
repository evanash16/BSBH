package graphics.screens;

import graphics.GUI;
import graphics.buttons.BackButton;
import graphics.buttons.Button;
import graphics.buttons.PlayButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

public class Pause extends JPanel implements MouseListener, MouseMotionListener {

    private Button play, main;
    private static String PAUSE = "PAUSED";

    public Pause(){
        setSize(GUI.SCREENSIZE);

        final int BUTTON_WIDTH = getWidth() / 5;
        main = new BackButton((getWidth() - BUTTON_WIDTH) / 4, (getHeight() + BUTTON_WIDTH) / 3, BUTTON_WIDTH, BUTTON_WIDTH);
        play = new PlayButton( 3 * (getWidth() - BUTTON_WIDTH) / 4, (getHeight() + BUTTON_WIDTH) / 3, BUTTON_WIDTH, BUTTON_WIDTH);
    }

    public void paint(Graphics g){
        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g2 = buffer.getGraphics();

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(Color.BLACK);
        g2.setFont(new Font(null, Font.BOLD, getHeight() / 3));
        int stringWidth = g2.getFontMetrics().stringWidth(PAUSE);
        g2.drawString(PAUSE, (getWidth() - stringWidth) / 2, getHeight() / 3);

        play.draw(g2);
        main.draw(g2);

        g.drawImage(buffer, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(isVisible()){
            if(play.isHovering()){
                GUI.playGame();
            }
            if(main.isHovering()){
                GUI.showMenu();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        if(isVisible()){
            play.hovering(e.getPoint());
            main.hovering(e.getPoint());
        }
    }
}
