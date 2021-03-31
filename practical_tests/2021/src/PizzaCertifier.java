import java.util.ArrayList;
import java.util.HashSet;

public abstract class PizzaCertifier {
    private final HashSet<Ingredient> mustHaveIngredients;

    protected PizzaCertifier(){
        this.mustHaveIngredients = new HashSet<>();
    }

    public void addMustHaveIngredient(Ingredient ingredient){
        mustHaveIngredients.add(ingredient);
    }

    public boolean isCertified(Pizza pizza){
        if (pizza.getIngredientCount() != mustHaveIngredients.size()) return false;
        for (Ingredient i : mustHaveIngredients){
            if (!pizza.hasIngredient(i)) return false;
        }
        return true;
    }
}
