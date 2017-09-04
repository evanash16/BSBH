package entities;

import graphics.Renderer;

import java.util.concurrent.CopyOnWriteArrayList;

public final class CoreManager {

    private static CopyOnWriteArrayList<Core> cores = new CopyOnWriteArrayList<>();

    public static void addCore(Core c){
        cores.add(c);
    }

    public static void removeCore(){
        Core c = cores.get(cores.size() - 1);
        SafezoneManager.removeSafezone(c);
        cores.remove(c);
    }

    public static boolean isEmpty(){
        return cores.isEmpty();
    }

    public static void draw(){
        for(Core c: cores){
            Renderer.addToQueue(c);
        }
    }

    public static void update(){
        for(int i = 0; i < cores.size(); i++){
            Core c1 = cores.get(i);
            c1.update();
            for(int j = i + 1; j < cores.size(); j++){
                Core c2 = cores.get(j);
                if(Interactions.checkCoreCollision(c1, c2)){
                    Interactions.resolveCollision(c1, c2);
                }
            }
        }
    }
}
