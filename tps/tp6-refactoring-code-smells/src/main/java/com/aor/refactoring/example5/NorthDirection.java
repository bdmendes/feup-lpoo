package com.aor.refactoring.example5;

public class NorthDirection implements Direction {
    @Override
    public void rotateLeft(Turtle turtle) {
        turtle.setDirection(new WestDirection());
    }

    @Override
    public void rotateRight(Turtle turtle) {
        turtle.setDirection(new EastDirection());
    }

    @Override
    public void moveForward(Turtle turtle) {
        turtle.decrementRow();
    }

    @Override
    public char getChar() {
        return 'N';
    }
}
