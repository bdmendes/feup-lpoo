import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import element.Monster;

import java.io.IOException;

public class Game {
    private final Screen screen;
    private final Arena arena;
    private final int columns = 40;
    private final int rows = 20;

    Game() throws IOException {
        /* Initialize view */
        TerminalSize terminalSize = new TerminalSize(this.columns, this.rows);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        this.screen = new TerminalScreen(terminal);
        this.screen.setCursorPosition(null);   // we don't need a cursor
        this.screen.startScreen();             // screens must be started
        this.screen.doResizeIfNecessary();     // resize screen if necessary

        /* Initialize arena */
        this.arena = new Arena(this.columns, this.rows);
    }

    public void run() throws IOException {
        for(;;){
            if (this.isGameOver()){
                screen.close();
                break;
            }

            this.draw();

            KeyStroke key = this.screen.readInput();
            this.arena.processKey(key);
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
                screen.close();
                break;
            }

            if (this.isGameOver()){
                screen.close();
                break;
            }
        }
    }

    private void draw() throws IOException {
        this.screen.clear();
        this.arena.draw(screen.newTextGraphics());
        this.screen.refresh();
    }

    private boolean isGameOver() {
        // Check if monster is above hero
        for (Monster m : this.arena.getMonsters()) {
            if (m.getPosition().equals(this.arena.getHero().getPosition())) return true;
        }
        return false;
    }
}
