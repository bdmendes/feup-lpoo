import java.util.ArrayList;

public class MargueritaCertifier extends PizzaCertifier {

    public MargueritaCertifier() {
        super();
        addMustHaveIngredient(new Ingredient("Tomato"));
        addMustHaveIngredient(new Ingredient("Basil"));
        addMustHaveIngredient(new Ingredient("Mozzarella"));
    }
}
