package graphics;

import entities.Entity;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

final class Renderer {

    private static Queue<Entity> renderingQueue = new LinkedList<>();

    public static void addToQueue(Entity e){
        renderingQueue.add(e);
    }

    public static void draw(Graphics g){
        while(!renderingQueue.isEmpty()){
            renderingQueue.remove().draw(g); //draws the entity and then removes it from the rendering queue
        }
    }
}
