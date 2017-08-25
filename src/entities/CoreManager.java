package entities;

import graphics.Renderer;

import java.util.ArrayList;

public final class CoreManager {

    private static ArrayList<Core> cores = new ArrayList<>();

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

    public static void update(){
        for(int i = 0; i < cores.size(); i++){
            Core c1 = cores.get(i);
            c1.update();
            Renderer.addToQueue(c1);
            for(int j = i + 1; j < cores.size(); j++){
                Core c2 = cores.get(j);
                if(Interactions.checkCoreCollision(c1, c2)){
                    Interactions.resolveCollision(c1, c2);
                }
            }
        }
    }
}
