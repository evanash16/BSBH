package entities;

import graphics.Renderer;

import java.util.concurrent.CopyOnWriteArrayList;

public final class SafezoneManager {

    private static CopyOnWriteArrayList<Safezone> safezones = new CopyOnWriteArrayList<>();

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

    public static void draw(){
        for(Safezone s: safezones){
            Renderer.addToQueue(s);
        }
    }

    public static void update() {
        for(int i = 0; i < safezones.size(); i++){
            Safezone s1 = safezones.get(i);
            s1.update();
            for(int j = i + 1; j < safezones.size(); j++){
                Safezone s2 = safezones.get(j);
                if(Interactions.checkSafezoneCollision(s1, s2)){
                    s1.addIntersection(s2);
                    s2.addIntersection(s1);
                } else {
                    s1.removeIntersection(s2);
                    s2.removeIntersection(s1);
                }
            }
        }
    }
}
