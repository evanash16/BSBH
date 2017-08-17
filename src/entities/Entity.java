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
    public void update(){}
}
