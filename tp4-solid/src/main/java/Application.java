import area.AreaAggregator;
import area.AreaStringOutputter;
import shapes.Circle;
import shapes.Ellipse;
import shapes.Square;

public class Application {
    public static void main(String[] args) {
        Square square = new Square(3);
        Circle circle = new Circle(5);
        Ellipse ellipse = new Ellipse(2,3);
        AreaAggregator areaAggregator = new AreaAggregator();
        areaAggregator.addShape(square);
        areaAggregator.addShape(circle);
        areaAggregator.addShape(ellipse);
        System.out.println(new AreaStringOutputter().output(areaAggregator));
    }
}
