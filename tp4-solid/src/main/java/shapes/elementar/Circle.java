package shapes.elementar;

import shapes.Shape;

public class Circle implements Shape {
    private double radius;
    public Circle(int radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
