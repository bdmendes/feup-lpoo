package bar;

import string.StringDrink;
import string.StringRecipe;

public class StringBar extends Bar{
    public StringBar(){
        super();
    }

    public void order(StringDrink drink, StringRecipe recipe){
        recipe.mix(drink);
    }
}
