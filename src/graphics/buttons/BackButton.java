package graphics.buttons;

import java.awt.*;

public class BackButton extends Button{

    public BackButton(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    public BackButton(int x, int y, int width, int height, Color color){
        this(x, y, width, height);
        this.color = color;
    }

    public void draw(Graphics g){
        super.draw(g);
        g.fillPolygon(new int[]{x, x + width / 4, x + width / 4}, new int[]{y + height / 2, y + height / 4, y + 3 * height / 4}, 3);
        g.fillRect(x + width / 4, y + (height / 3), 3 * width / 4, height / 3);
    }
}
