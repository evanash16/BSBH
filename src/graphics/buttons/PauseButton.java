package graphics.buttons;

import java.awt.*;

public class PauseButton extends Button{

    private Color color;

    public PauseButton(int x, int y, int width, int height){
        super(x, y, width, height);
        color = Color.WHITE.darker();
    }

    public PauseButton(int x, int y, int width, int height, Color color){
        this(x, y, width, height);
        this.color = color;
    }
    
    public void draw(Graphics g){
        g.setColor(color);
        if(hovering){
            g.setColor(color.darker());
        }
        g.fillRect(x, y, width / 4, height);
        g.fillRect(x + (3 * width / 4), y, width / 4, height);
        g.drawRoundRect(x - width / 8, y - height / 8, 5 * width / 4, 5 * height / 4, width / 8, height / 8);
    }
}
