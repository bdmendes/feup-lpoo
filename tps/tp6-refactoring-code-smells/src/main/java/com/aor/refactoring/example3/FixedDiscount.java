package com.aor.refactoring.example3;

public class FixedDiscount implements Discount{
    private final double fixed;

    public FixedDiscount(double fixed) {
        this.fixed = fixed;
    }

    @Override
    public double applyDiscount(double price) {
        return fixed > price ? 0 : price - fixed;
    }
}
