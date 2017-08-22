package entities;

import graphics.Renderer;

import java.util.ArrayList;

public final class CoreManager {

    private static ArrayList<Core> cores = new ArrayList<>();

    public static void addCore(Core c){
        cores.add(c);
    }

    public static void removeCore(){
        cores.remove(cores.get(cores.size() - 1));
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
                if(Math.sqrt(Math.pow(c2.getX() - c1.getX(), 2) + Math.pow(c2.getX() - c1.getX(), 2)) < c1.getRadius() + c2.getRadius()){
                    System.out.println("Collision"); //We will put collision here
                }
            }
        }
    }
}
