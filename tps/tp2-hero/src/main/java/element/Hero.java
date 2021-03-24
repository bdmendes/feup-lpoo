package element;

import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element {
    public Hero(int x, int y){
        super(x,y);
    }

    public void draw(TextGraphics graphics){
        super.draw_element(graphics, "H", "#FFFF33");
    }

    public Position moveLeft() {
        return new Position(this.getPosition().getX() - 1, this.getPosition().getY());
    }

    public Position moveUp() {
        return new Position(this.getPosition().getX(), this.getPosition().getY() - 1);
    }

    public Position moveDown() {
        return new Position(this.getPosition().getX(), this.getPosition().getY() + 1);
    }

    public Position moveRight() {
        return new Position(this.getPosition().getX() + 1, this.getPosition().getY());
    }
}
