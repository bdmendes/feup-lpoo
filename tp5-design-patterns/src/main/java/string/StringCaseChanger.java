package string;

public class StringCaseChanger implements StringTransformer{
    @Override
    public void execute(StringDrink drink) {
        StringBuilder txt = new StringBuilder(drink.getText());
        for (int i = 0; i < txt.length(); i++){
            char curr = txt.charAt(i);
            if (Character.isLowerCase(curr)){
                txt.setCharAt(i, Character.toUpperCase(curr));
            } else if (Character.isUpperCase(curr)) {
                txt.setCharAt(i, Character.toLowerCase(curr));
            }
        }
        drink.setText(txt.toString());
    }

    @Override
    public void undo(StringDrink drink) {
        execute(drink);
    }
}
