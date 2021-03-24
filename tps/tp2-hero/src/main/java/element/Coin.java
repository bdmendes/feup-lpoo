package element;

import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element{
    public Coin(int x, int y){
        super(x,y);
    }
    public void draw(TextGraphics graphics){
        super.draw_element(graphics, "C", "#0000ff");
    }
}
