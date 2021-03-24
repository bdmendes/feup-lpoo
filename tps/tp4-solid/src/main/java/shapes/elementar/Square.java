package shapes.elementar;

import shapes.AreaShape;

public class Square implements AreaShape {
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
