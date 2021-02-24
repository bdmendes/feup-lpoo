import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;

public class Game {
    private final Screen screen;
    private final Hero hero;
    private final int columns = 40;
    private final int rows = 20;

    Game() throws IOException {
        this.hero = new Hero(10,10);
        /* Initialize view */
        TerminalSize terminalSize = new TerminalSize(this.columns, this.rows);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        this.screen = new TerminalScreen(terminal);
        this.screen.setCursorPosition(null);   // we don't need a cursor
        this.screen.startScreen();             // screens must be started
        this.screen.doResizeIfNecessary();     // resize screen if necessary
    }

    public void run() throws IOException {
        for(;;){
            this.draw();
            KeyStroke key = this.screen.readInput();
            if (key.getKeyType() == KeyType.EOF) break;
            this.processKey(key);
        }
    }

    private void draw() throws IOException {
        this.screen.clear();
        this.hero.draw(this.screen);
        this.screen.refresh();
    }

    private void processKey(KeyStroke key) throws IOException {
        System.out.println(key);
        switch (key.getKeyType()){
            case ArrowUp:
                this.moveHero(this.hero.moveUp());
                break;
            case ArrowDown:
                this.moveHero(this.hero.moveDown());
                break;
            case ArrowLeft:
                this.moveHero(this.hero.moveLeft());
                break;
            case ArrowRight:
                this.moveHero(this.hero.moveRight());
                break;
            case Character:
                char c = key.getCharacter();
                if (c == 'q') this.screen.close(); // sends eof signal
                break;
            default:
                break;
        }
    }

    private void moveHero(Position position){
        if (position.getX() >= 0 && position.getX() < columns
        && position.getY() >= 0 && position.getY() < rows){
            this.hero.setPosition(position);
        }
    }
}
