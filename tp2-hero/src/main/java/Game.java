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
    private int x = 10;
    private int y = 10;
    private int columns = 40;
    private int rows = 20;

    Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(this.columns, this.rows);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        this.screen = new TerminalScreen(terminal);
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
        this.screen.setCursorPosition(null);   // we don't need a cursor
        this.screen.startScreen();             // screens must be started
        this.screen.doResizeIfNecessary();     // resize screen if necessary

        this.screen.clear();
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
        this.screen.refresh();
    }

    private void processKey(KeyStroke key) throws IOException {
        System.out.println(key);
        switch (key.getKeyType()){
            case ArrowUp:
                if (y > 0) y--;
                break;
            case ArrowDown:
                if (y < rows - 1) y++;
                break;
            case ArrowLeft:
                if (x > 0) x--;
                break;
            case ArrowRight:
                if (x < columns - 1) x++;
                break;
            case Character:
                char c = key.getCharacter();
                if (c == 'q') this.screen.close(); // sends eof signal
                break;
            default:
                break;
        }
    }

}
