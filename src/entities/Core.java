package entities;

import java.awt.*;

public class Core extends Entity {

    private int radius;
    private Color color;
    private static final int VELOCITY = 10;

    public Core(double x, double y, int radius) {
        super(x, y, Math.random() * 2 * Math.PI, VELOCITY);
        this.color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        this.radius = radius;
        SafezoneManager.addSafezone(this);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval((int) (getX() - radius), (int) (getY() - radius), 2 * radius, 2 * radius);
    }

    public int getRadius() {
        return radius;
    }
    public Color getColor() {
        return color;
    }
}
