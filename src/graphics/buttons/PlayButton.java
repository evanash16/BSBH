package graphics.buttons;

import java.awt.*;

public class PlayButton extends Button{

    private Color color;

    public PlayButton(int x, int y, int width, int height){
        super(x, y, width, height);
        color = Color.WHITE.darker();
    }

    public PlayButton(int x, int y, int width, int height, Color color){
        this(x, y, width, height);
        this.color = color;
    }

    public void draw(Graphics g){
        g.setColor(color);
        if(hovering){
            g.setColor(color.darker());
        }
        g.fillPolygon(new int[]{x, x + width, x}, new int[]{y, y + height / 2, y + height}, 3);
        g.drawRoundRect(x - width / 8, y - height / 8, 5 * width / 4, 5 * height / 4, width / 8, height / 8);
    }
}
