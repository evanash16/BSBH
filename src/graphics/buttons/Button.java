package graphics.buttons;

import javax.swing.*;
import java.awt.*;

public class Button {

    protected int x, y, width, height;
    protected boolean hovering;
    protected Color color;

    public Button(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = Color.BLACK;
    }

    public void draw(Graphics g){
        g.setColor(color);
        if(hovering){
            g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
        }
        g.drawRoundRect(x - width / 8, y - height / 8, 5 * width / 4, 5 * height / 4, width / 8, height / 8);
    }
    public void hovering(Point p){
        hovering = p.x > x && p.x < x + width && p.y > y && p.y < y + height;
    }
    public boolean isHovering() {return hovering;}
}
