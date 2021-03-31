package com.aor.refactoring.example5;

public class Turtle {
    private int row;
    private int column;
    private Direction direction;

    public Turtle(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        setDirection(direction);
    }

    private void setDirection(char dir){
        switch(dir){
            case 'E': this.direction = new EastDirection(); break;
            case 'N': this.direction = new NorthDirection(); break;
            case 'W': this.direction = new WestDirection(); break;
            case 'S': this.direction = new SouthDirection(); break;
            default: break;
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction.getChar();
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void incrementRow() {
        this.row++;
    }

    public void decrementRow() {
        this.row--;
    }

    public void incrementColumn() {
        this.column++;
    }

    public void decrementColumn() {
        this.column--;
    }

    public void execute(char command) {
        if (command == 'L') {
            this.direction.rotateLeft(this);
        } else if (command == 'R') {
            this.direction.rotateRight(this);
        } else if (command == 'F') {
            this.direction.moveForward(this);
        }
    }
}
