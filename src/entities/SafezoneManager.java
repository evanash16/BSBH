package entities;

import graphics.Renderer;

import java.util.ArrayList;

public final class SafezoneManager {

    private static ArrayList<Safezone> safezones = new ArrayList<>();

    public static void addSafezone(Core c){
        safezones.add(new Safezone(c));
    }
    public static void removeSafezone(Core c) {
        for (Safezone s : safezones) {
            if (s.getChild() == c) {
                safezones.remove(s);
                return;
            }
        }
    }

    public static void update() {
        for(int i = 0; i < safezones.size(); i++){
            Safezone s1 = safezones.get(i);
            s1.update();
            Renderer.addToQueue(s1);
            for(int j = i + 1; j < safezones.size(); j++){
                Safezone s2 = safezones.get(j);
                if(Math.sqrt(Math.pow(s2.getX() - s1.getX(), 2) + Math.pow(s2.getY() - s1.getY(), 2)) < s1.getRadius() + s2.getRadius()){
                    // Put intersection code here
                }
            }
        }
    }
}
