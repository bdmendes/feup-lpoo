import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

public class Arena {
    int width;
    int height;
    private final Hero hero;

    Arena(int width, int height){
        this.height = height;
        this.width = width;
        this.hero = new Hero(10,10);
    }

    public Hero getHero() {
        return hero;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        this.hero.draw(graphics);
    }

    public void processKey(KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType()){
            case ArrowUp:
                this.moveHero(this.getHero().moveUp());
                break;
            case ArrowDown:
                this.moveHero(this.getHero().moveDown());
                break;
            case ArrowLeft:
                this.moveHero(this.getHero().moveLeft());
                break;
            case ArrowRight:
                this.moveHero(this.getHero().moveRight());
                break;
            default:
                break;
        }
    }

    private void moveHero(Position position){
        if (this.canHeroMove(position)){
            hero.setPosition(position);
        }
    }

    private boolean canHeroMove(Position position){
        return position.getX() >= 0 && position.getX() < width
                && position.getY() >= 0 && position.getY() < height;
    }
}
