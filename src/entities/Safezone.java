package entities;

import java.awt.*;

public class Safezone {

    private Core child;

    public Safezone(Core child){
        this.child = child;
    }

    public void draw(Graphics g){
        g.setColor(child.getColor().brighter());
        g.fillOval((int) (child.getX() - 2 * child.getRadius()), (int) (child.getY() - 2 * child.getRadius()), 4 * child.getRadius(), 4 * child.getRadius());
    }
}
