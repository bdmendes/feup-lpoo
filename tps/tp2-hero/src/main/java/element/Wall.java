package element;

import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {

    public Wall(int x, int y){
        super(x,y);
    }

    @Override
    public void draw(TextGraphics graphics){
        super.draw_element(graphics, "W", "#222222");
    }
}
