package shapes.elementar;

import shapes.Shape;

public class Ellipse implements Shape {
    private double xRadius, yRadius;
    public Ellipse(int xRadius, int yRadius){
        this.xRadius = xRadius;
        this.yRadius = yRadius;
    }

    public double getxRadius() {
        return xRadius;
    }

    public double getyRadius() {
        return yRadius;
    }

    public void setxRadius(double xRadius) {
        this.xRadius = xRadius;
    }

    public void setyRadius(double yRadius) {
        this.yRadius = yRadius;
    }

    @Override
    public double getArea() {
        return Math.PI * xRadius * yRadius;
    }

    @Override
    public void draw() {
        System.out.println("Ellipse");
    }
}
