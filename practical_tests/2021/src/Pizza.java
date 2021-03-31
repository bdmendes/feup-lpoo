import java.util.HashSet;

public interface Pizza {
    boolean addIngredient(Ingredient ingredient);
    int getIngredientCount();
    boolean hasIngredient(Ingredient ingredient);
    double getPrice();
    void setPrice(double price);
}
