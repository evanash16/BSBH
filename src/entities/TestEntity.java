package entities;

/*
THIS IS A TEST ENTITY. THIS WILL NOT MAKE IT INTO THE FINAL GAME.
PLEASE BURN THIS CLASS AT THE STAKE. I REPEAT. THIS IS A TEST ENTITY.
 */

import graphics.GUI;

import java.awt.*;

public class TestEntity extends Entity{

    public TestEntity(int x, int y){
        super(x, y);

        this.velX = Math.max(25, Math.random() * 50);
        this.velY = Math.max(25, Math.random() * 50);
        this.width = 100;
        this.height = this.width;
    }

    public void draw(Graphics g) {
        super.draw(g);

        g.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
        g.fillOval((int) (x - width / 2), (int) (y - height / 2), width, height);
    }

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
