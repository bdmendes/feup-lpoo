package bar.client;

import string.StringDrink;
import string.StringRecipe;

class Order {
    public StringDrink drink;
    public StringRecipe recipe;

    public Order(StringDrink drink, StringRecipe recipe) {
        this.drink = drink;
        this.recipe = recipe;
    }
}
