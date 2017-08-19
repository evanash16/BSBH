package entities;

import java.awt.*;

public class Core extends Entity {

    protected int radius;

    public Core(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
        this.velX = Math.max(25, Math.random() * 50);
        this.velY = Math.max(25, Math.random() * 50);
    }

    public void draw(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillOval((int) (x - radius), (int) (y - radius), 2 * radius, 2 * radius);
    }
}
