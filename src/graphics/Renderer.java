package graphics;

import entities.Entity;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

final class Renderer {

    private static Queue<Entity> renderingQueue = new LinkedList<Entity>();

    public static void addToQueue(Entity e){
        renderingQueue.add(e);
    }

    public static void draw(Graphics g){
        while(!renderingQueue.isEmpty()){
            renderingQueue.remove().draw(g);
        }
    }
}
