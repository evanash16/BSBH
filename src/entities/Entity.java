package entities;

import graphics.GUI;

import java.awt.*;

public class Entity {

    private int width, height;
    private double x, y, angle, velMag;

    public Entity(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Entity(double x, double y, double angle, double velMag){
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.velMag = velMag;
    }

    public void draw(Graphics g){}
    public void update() {

        double velX = Math.cos(angle) * velMag, velY = Math.sin(angle) * velMag;
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
        angle = Math.atan2(velY, velX);
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void setSize(int width, int height) {
        this.width = width; this.height = height;
    }
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
    public double getVelMag() { return velMag; }
    public void setVelMag(double velMag) { this.velMag = velMag; }
    public double getAngle() {
        return angle;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
}
