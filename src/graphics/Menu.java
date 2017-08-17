package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Menu extends JPanel {

    private static String TITLE = "BSBH", SUBTITLE = "By Evan Ashley and Justin Foxhoven", START = "Press SPACE To Start";

    public Menu(){
        setSize(GUI.SCREENSIZE);
    }

    public void paint(Graphics g){
        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics g2 = buffer.getGraphics();

        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(Color.BLACK);
        g2.setFont(new Font(null, Font.BOLD, getHeight() / 3));
        int stringWidth = g2.getFontMetrics().stringWidth(TITLE);
        g2.drawString(TITLE, (getWidth() - stringWidth) / 2, getHeight() / 2);

        g2.setFont(new Font(null, Font.BOLD, getHeight() / 20));
        stringWidth = g2.getFontMetrics().stringWidth(SUBTITLE);
        g2.drawString(SUBTITLE, (getWidth() - stringWidth) / 2, (getHeight() / 2) + (2 * g2.getFont().getSize()));

        g2.setFont(new Font(null, Font.BOLD, getHeight() / 25));
        stringWidth = g2.getFontMetrics().stringWidth(START);
        g2.drawString(START, (getWidth() - stringWidth) / 2, 7 * getHeight() / 8);

        g.drawImage(buffer, 0, 0, null);
    }
}
