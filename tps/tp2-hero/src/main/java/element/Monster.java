package element;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Hero {
    public Monster(int x, int y){
        super(x,y);
    }
    public Position move(){
        Random rand = new Random();
        int i = rand.nextInt(4);
        return switch (i) {
            case 0 -> super.moveDown();
            case 1 -> super.moveUp();
            case 2 -> super.moveLeft();
            case 3 -> super.moveRight();
            default -> this.getPosition();
        };
    }

    @Override
    public void draw(TextGraphics graphics) {
        super.draw_element(graphics, "M", "#ff0000");
    }
}
