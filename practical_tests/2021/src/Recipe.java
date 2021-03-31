import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class Recipe {
    protected List<Ingredient> ingredients;

    protected Recipe(){
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    public MediumPizza makeMediumPizza(){
        MediumPizza pizza = new MediumPizza();
        for (Ingredient i : ingredients){
            pizza.addIngredient(i);
        }
        return pizza;
    }
}
