package shapes.elementar;

import shapes.Shape;

public class Square implements Shape {
    double side;
    public Square(int side){
        this.side = side;
    }

    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public void draw() {
        System.out.println("Square");
    }
}
