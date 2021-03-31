import java.util.HashSet;

public class MediumPizza implements Pizza {
    private final HashSet<Ingredient> ingredients;
    private double price;

    public MediumPizza(){
        this.ingredients = new HashSet<>();
        this.price = 0;
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        return ingredients.add(ingredient);
    }

    @Override
    public int getIngredientCount() {
        return ingredients.size();
    }

    @Override
    public boolean hasIngredient(Ingredient ingredient) {
        return ingredients.contains(ingredient);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }
}
