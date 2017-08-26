package entities;

import java.awt.*;
import java.util.ArrayList;

public class Safezone extends Entity {

    private Core child;
    private int radius;
    private ArrayList<Safezone> intersections;

    public Safezone(Core child) {
        super(child.getX(), child.getY(), child.getAngle(), child.getVelMag(), child.getMass());
        this.radius = 2 * child.getRadius();
        this.child = child;
        this.intersections = new ArrayList<Safezone>();
    }

    public void draw(Graphics g) {
        g.setColor(child.getColor().brighter());
        if(!intersections.isEmpty()){
            g.setColor(mixColors());
        }
        g.fillOval((int) (getX() - getRadius()), (int) (getY() - getRadius()), 2 * getRadius(), 2 * getRadius());
    }

    public void update() {
        setX(child.getX());
        setY(child.getY());
        setAngle(child.getAngle());
        setVelMag(child.getVelMag());
    }

    public void addIntersection(Safezone s) {
        if(!intersections.contains(s)){
            intersections.add(s);
        }
    }
    public void removeIntersection(Safezone s){ intersections.remove(s); }
    private Color mixColors() {
        Color c = getColor();
        int red = c.getRed(), green = c.getGreen(), blue = c.getBlue();
        for(Safezone s: intersections){
            c = s.getColor();
            red += c.getRed();
            green += c.getGreen();
            blue += c.getBlue();
        }
        red /= intersections.size() + 1;
        green /= intersections.size() + 1;
        blue /= intersections.size() + 1;
        return new Color(red, green, blue);
    }

    public Core getChild() { return child; }
    public int getRadius() {
        return radius;
    }
    public Color getColor() {
        return child.getColor();
    }
}
