package com.aor.refactoring.example1;

public class OrderLine {
    private final Product product;
    private final int quantity;
    private final double total;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.total = product.getPrice() * quantity;
    }

    public double getTotal() {
        return total;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return product.getName() + "(x" + quantity + "): " + getTotal() + "\n";
    }
}
