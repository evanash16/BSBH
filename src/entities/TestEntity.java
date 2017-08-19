package entities;

/*
THIS IS A TEST ENTITY. THIS WILL NOT MAKE IT INTO THE FINAL GAME.
PLEASE BURN THIS CLASS AT THE STAKE. I REPEAT. THIS IS A TEST ENTITY.
 */

import graphics.GUI;

import java.awt.*;

public class TestEntity extends Entity{

    private Color color;

    public TestEntity(int x, int y){
        super(x, y);

        this.velX = Math.max(25, Math.random() * 50);
        this.velY = Math.max(25, Math.random() * 50);
        this.width = 100;
        this.height = this.width;

        this.color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    }

    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(color);
        g.fillOval((int) (x - width / 2), (int) (y - height / 2), width, height);
    }
}
