package entities;

import java.awt.*;
import java.util.ArrayList;

public class Safezone extends Entity {

    private Core child;
    private int radius;
    private Color color;
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

    public void intersect(Safezone s) {
        intersections.add(s);
    }
    public void removeIntersection(Safezone s){
        intersections.remove(s);
    }
    private Color mixColors() {
        return Color.WHITE;
    }

    public Core getChild() { return child; }
    public int getRadius() {
        return radius;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) { this.color = color; }
}
