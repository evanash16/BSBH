package graphics.buttons;

import java.awt.*;

public class PlayButton extends Button{

    public PlayButton(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    public PlayButton(int x, int y, int width, int height, Color color){
        this(x, y, width, height);
        this.color = color;
    }

    public void draw(Graphics g){
        super.draw(g);
        g.fillPolygon(new int[]{x, x + width, x}, new int[]{y, y + height / 2, y + height}, 3);
    }
}
