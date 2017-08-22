package entities;

/*
THIS IS A TEST ENTITY. THIS WILL NOT MAKE IT INTO THE FINAL GAME.
PLEASE BURN THIS CLASS AT THE STAKE. I REPEAT. THIS IS A TEST ENTITY.
 */

import java.awt.*;

public class TestEntity extends Entity{

    private Color color;

    public TestEntity(int x, int y){
        super(x, y, Math.max(25, Math.random() * 50), Math.max(25, Math.random() * 50));
        setSize(100, 100);

        this.color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    }

    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(color);
        g.fillOval((int) (getX() - getWidth() / 2), (int) (getY() - getHeight() / 2), getWidth(), getHeight());
    }
}
