package shapes.elementar;

import shapes.AreaShape;

public class Rectangle implements AreaShape {
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
