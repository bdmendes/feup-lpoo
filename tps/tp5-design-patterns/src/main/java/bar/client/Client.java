package bar.client;

import bar.bar.BarObserver;
import bar.bar.StringBar;
import string.StringDrink;
import string.StringRecipe;

public interface Client extends BarObserver {
    void wants(StringDrink drink, StringRecipe recipe, StringBar bar);
}
