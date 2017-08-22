package entities;

import java.awt.*;

public class Core extends Entity {

    private int radius;
    private Color color;
    private Safezone zone;

    public Core(int x, int y, int radius) {
        super(x, y, Math.max(25, Math.random() * 50), Math.max(25, Math.random() * 50));
        this.color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        this.radius = radius;
        zone = new Safezone(this);
    }

    public void draw(Graphics g) {

        if(zone != null){
            zone.draw(g);
        }

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
