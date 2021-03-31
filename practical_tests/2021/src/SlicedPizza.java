public class SlicedPizza implements Pizza{
    private final Pizza pizza;
    private final int slices;

    public SlicedPizza(Pizza pizza, int slices) {
        this.pizza = pizza;
        this.slices = slices;
    }

    public int getSlices() {
        return slices;
    }

    public Pizza getPizza() {
        return pizza;
    }

    @Override
    public boolean addIngredient(Ingredient ingredient) {
        return this.pizza.addIngredient(ingredient);
    }

    @Override
    public int getIngredientCount() {
        return this.pizza.getIngredientCount();
    }

    @Override
    public boolean hasIngredient(Ingredient ingredient) {
        return this.pizza.hasIngredient(ingredient);
    }

    @Override
    public double getPrice() {
        return this.pizza.getPrice() + 2.0;
    }

    @Override
    public void setPrice(double price) {
        this.pizza.setPrice(price);
    }
}
