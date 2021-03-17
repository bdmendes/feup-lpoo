package shapes.elementar;

import shapes.AreaShape;

public class Triangle implements AreaShape {
    private double width, height;

    public Triangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (height*width)/2;
    }

    @Override
    public void draw() {
        System.out.println("Triangle");
    }
}
