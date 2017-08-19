package entities;

import graphics.GUI;

import java.awt.*;

public class Entity {

    protected int width, height;
    protected double x, y, velX, velY;

    public Entity(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g){}
    public void update() {

        if (x + velX < 0 || x + velX + width > GUI.SCREENSIZE.width) {
            velX *= -1;
        } else {
            x += velX;
        }

        if (y + velY < 0 || y + velY + height > GUI.SCREENSIZE.height) {
            velY *= -1;
        } else {
            y += velY;
        }
    }
}
