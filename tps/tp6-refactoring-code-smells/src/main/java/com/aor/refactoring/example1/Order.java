package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;
    private double total;

    public Order() {
        lines = new ArrayList<>();
        total = 0;
    }

    public void add(Product product, int quantity) {
        OrderLine line = new OrderLine(product, quantity);
        lines.add(line);
        total += line.getTotal();
    }

    public boolean isEligibleForFreeDelivery() {
        return total > 100;
    }

    public String printOrder() {
        StringBuilder printBuffer = new StringBuilder();
        for (OrderLine line : lines)
            printBuffer.append(line.toString());
        printBuffer.append("Total: ").append(total);
        return printBuffer.toString();
    }
}