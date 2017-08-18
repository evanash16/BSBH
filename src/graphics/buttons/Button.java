package graphics.buttons;

import javax.swing.*;
import java.awt.*;

public class Button {

    protected int x, y, width, height;
    protected boolean hovering;

    public Button(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g){}
    public void hovering(Point p){
        hovering = p.x > x && p.x < x + width && p.y > y && p.y < y + height;
    }
    public boolean isHovering() {return hovering;}
}
