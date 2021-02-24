import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

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

    public void draw(Screen screen){
        this.hero.draw(screen);
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
