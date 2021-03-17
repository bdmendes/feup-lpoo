package shapes.elementar;

import shapes.Shape;

public class Triangle implements Shape {
    private double width, height;

    @Override
    public double getArea() {
        return (height*width)/2;
    }

    @Override
    public void draw() {
        System.out.println("Triangle");
    }
}
