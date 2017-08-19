package graphics.buttons;

import java.awt.*;

public class PauseButton extends Button{

    public PauseButton(int x, int y, int width, int height){
        super(x, y, width, height);
    }

    public PauseButton(int x, int y, int width, int height, Color color){
        this(x, y, width, height);
        this.color = color;
    }
    
    public void draw(Graphics g){
        super.draw(g);
        g.fillRect(x, y, width / 4, height);
        g.fillRect(x + (3 * width / 4), y, width / 4, height);
    }
}
