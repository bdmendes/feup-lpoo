import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Wall {
    private final Position position;

    public Wall(int x, int y){
        this.position = new Position(x,y);
    }
    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#00FF00"));
        graphics.enableModifiers(SGR.ITALIC);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }
}
