package bar;

import string.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SmartStrategy implements OrderingStrategy{
    private final HashMap<Bar, Boolean> orderImmediatly;
    private final HashMap<Bar, ArrayList<Order>> waitingDrinks;

    public SmartStrategy(){
        this.orderImmediatly = new HashMap<>();
        this.waitingDrinks = new HashMap<>();
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if (this.orderImmediatly.containsKey(bar)){
            if (this.orderImmediatly.get(bar)){
                bar.order(drink, recipe);
            } else {
                ArrayList<Order> orders = this.waitingDrinks.get(bar);
                orders.add(new Order(drink, recipe));
                this.waitingDrinks.put(bar, orders);
            }
        } else {
            this.orderImmediatly.put(bar, false);
            ArrayList<Order> orders = new ArrayList<>();
            orders.add(new Order(drink, recipe));
            this.waitingDrinks.put(bar, orders);
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        this.orderImmediatly.put(bar, true);
        if (!this.waitingDrinks.containsKey(bar)) return;
        for (Order orders: this.waitingDrinks.get(bar)){
            bar.order(orders.drink, orders.recipe);
        }
    }

    @Override
    public void happyHourEnded(StringBar bar) {
        this.orderImmediatly.put(bar, false);
    }
}
