package element;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    private Position position;

    public Element(int x, int y){
        this.position = new Position(x,y);
    }

    public Position getPosition(){
        return this.position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public abstract void draw(TextGraphics graphics);

    protected void draw_element(TextGraphics graphics, String name, String rgb){
        graphics.setForegroundColor(TextColor.Factory.fromString(rgb));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), name);
    }
}
