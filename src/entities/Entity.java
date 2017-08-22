package entities;

import graphics.GUI;

import java.awt.*;

public class Entity {

    private int width, height;
    private double x, y, velX, velY;

    public Entity(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Entity(int x, int y, double velX, double velY){
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;
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

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void setSize(int width, int height) {this.width = width; this.height = height;}
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getVelX() {
        return velX;
    }
    public void setVelX(double velX) {
        this.velX = velX;
    }
    public double getVelY() {
        return velY;
    }
    public void setVelY(double velY) {
        this.velY = velY;
    }
}
