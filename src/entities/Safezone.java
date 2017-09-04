package entities;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class Safezone extends Entity {

    private Core child;
    private int radius;
    private CopyOnWriteArrayList<Safezone> intersections;

    public Safezone(Core child) {
        super(child.getX(), child.getY(), child.getAngle(), child.getVelMag(), child.getMass());
        this.radius = 3 * child.getRadius();
        this.child = child;
        this.intersections = new CopyOnWriteArrayList<>();
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
        HashMap<String, Integer> colorSum = sumColors(new ArrayList<>());
        int red = colorSum.get("red");
        int green = colorSum.get("green");
        int blue = colorSum.get("blue");
        int total = colorSum.get("visited");
        return new Color(red / total, green / total, blue / total);
    }
    private HashMap<String, Integer> sumColors(ArrayList<Safezone> visited) {
        HashMap<String, Integer> colorSum = new HashMap<String, Integer>() {{
            put("red", 0);
            put("green", 0);
            put("blue", 0);
            put("visited", 0);
        }};
        colorSum.put("red", colorSum.get("red") + getColor().getRed());
        colorSum.put("green", colorSum.get("green") + getColor().getGreen());
        colorSum.put("blue", colorSum.get("blue") + getColor().getBlue());
        visited.add(this);
        for(Safezone s: intersections){
            if(!visited.contains(s)){
                Map<String, Integer> additionalSum = s.sumColors(visited);
                colorSum.put("red", colorSum.get("red") + additionalSum.get("red"));
                colorSum.put("green", colorSum.get("green") + additionalSum.get("green"));
                colorSum.put("blue", colorSum.get("blue") + additionalSum.get("blue"));
            }
        }
        colorSum.put("visited", visited.size());
        return colorSum;
    }
    public Core getChild() { return child; }
    public int getRadius() {
        return radius;
    }
    public Color getColor() {
        return child.getColor();
    }
}
