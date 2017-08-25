package entities;

import graphics.GUI;

import java.awt.*;

public class Entity {

    private int width, height;
    private double x, y, angle, velMag, mass;

    public Entity(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Entity(double x, double y, double angle, double velMag, double mass){
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.velMag = velMag;
        this.mass = mass;
    }

    public void draw(Graphics g){}
    public void update() {

        double velX = getXVelComponent(), velY = getYVelComponent();
        if (x + velX < 0) {
            x = 0;
            velX *= -1;
        } else if (x + velX + width > GUI.SCREENSIZE.width) {
            x = GUI.SCREENSIZE.width;
            velX *= -1;
        } else {
            x += velX;
        }

        if (y + velY < 0) {
            y = 0;
            velY *= -1;
        }
        else if (y + velY + height > GUI.SCREENSIZE.height) {
            y = GUI.SCREENSIZE.height;
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
    public void setMass(double mass) { this.mass = mass; }
    public double getMass() { return mass; }
    public double getAngle() {
        return angle;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
    public double getXVelComponent() {
        return velMag * Math.cos(angle);
    }
    public double getYVelComponent() {
        return velMag * Math.sin(angle);
    }
}
