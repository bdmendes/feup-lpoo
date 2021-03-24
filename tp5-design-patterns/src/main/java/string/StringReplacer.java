package string;

public class StringReplacer implements StringTransformer {

    private char oldChar;
    private char newChar;

    public StringReplacer(char oldChar, char newChar){
        this.newChar = newChar;
        this.oldChar = oldChar;
    }

    @Override
    public void execute(StringDrink drink) {
        String txt = drink.getText();
        txt = txt.replace(oldChar, newChar);
        drink.setText(txt);
    }

    @Override
    public void undo(StringDrink drink) {
        swap();
        execute(drink);
        swap();
    }

    private void swap(){
        char tmp = this.newChar;
        this.newChar = oldChar;
        this.oldChar = tmp;
    }
}
