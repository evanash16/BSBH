package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Game extends JPanel {

    private static String ESCAPE = "Press ESCAPE To Return To Main";

    public Game(){
        setSize(GUI.SCREENSIZE);
    }

    public void paint(Graphics g){
        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g2 = buffer.getGraphics();

        g2.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(g2.getColor().darker());
        g2.setFont(new Font(null, Font.BOLD, getHeight() / 20));
        int stringWidth = g2.getFontMetrics().stringWidth(ESCAPE);
        g2.drawString(ESCAPE, (getWidth() - stringWidth) / 2, getHeight() / 2);

        g.drawImage(buffer, 0, 0, null);
    }
}
