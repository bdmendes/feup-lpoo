package shapes.elementar;

import shapes.Shape;

public class Rectangle implements Shape {
    double width, height;
    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}
