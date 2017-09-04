package graphics;

import entities.Entity;

import java.awt.*;
import java.util.LinkedList;

public final class Renderer {

    private static LinkedList<Entity> renderingQueue = new LinkedList<>();

    public static void addToQueue(Entity e){
        renderingQueue.add(e);
    }

    public static void draw(Graphics g){
        while(!renderingQueue.isEmpty()){
            renderingQueue.remove().draw(g); //draws the entity and then removes it from the rendering queue
        }
    }
}
