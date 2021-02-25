import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import element.Coin;
import element.Hero;
import element.Position;
import element.Wall;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    int width;
    int height;
    private final Hero hero;
    private final List<Wall> walls;
    private final List<Coin> coins;

    Arena(int width, int height){
        this.height = height;
        this.width = width;
        this.hero = new Hero(10,10);
        this.walls = this.createWalls();
        this.coins = this.createCoins();
    }

    public Hero getHero() {
        return hero;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#666666"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        this.hero.draw(graphics);
        for (final Wall wall : walls){
            wall.draw(graphics);
        }
        for (final Coin coin : coins){
            coin.draw(graphics);
        }
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
            for (int i = 0; i < this.coins.size(); i++){
                if (this.coins.get(i).getPosition().equals(position)){
                    this.coins.remove(i);
                    i--;
                }
            }
        }
    }

    private boolean canHeroMove(Position position){
        boolean hitWall = false;
        for (Wall wall : walls){
            if (position.equals(wall.getPosition())){
                hitWall = true;
                break;
            }
        }
        return !hitWall && position.getX() >= 0 && position.getX() < width
                && position.getY() >= 0 && position.getY() < height;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            int x = 0, y = 0;
            while (x == 0 || y == 0 || this.hero.getPosition().equals(new Position(x,y))){
                x = random.nextInt(width - 2) + 1;
                y = random.nextInt(height - 2) + 1;
            }
            coins.add(new Coin(x,y));
        }
        return coins;
    }
}