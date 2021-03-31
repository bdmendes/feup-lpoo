package com.aor.refactoring.example5;

public class WestDirection implements Direction {
    @Override
    public void rotateLeft(Turtle turtle) {
        turtle.setDirection(new SouthDirection());
    }

    @Override
    public void rotateRight(Turtle turtle) {
        turtle.setDirection(new NorthDirection());
    }

    @Override
    public void moveForward(Turtle turtle) {
        turtle.decrementColumn();
    }

    @Override
    public char getChar() {
        return 'W';
    }
}
