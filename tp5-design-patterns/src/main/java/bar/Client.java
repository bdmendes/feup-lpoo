package bar;

import string.StringDrink;
import string.StringRecipe;

public interface Client extends BarObserver{
    void wants(StringDrink drink, StringRecipe recipe, StringBar bar);
}
