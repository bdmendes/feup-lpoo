import area.AreaAggregator;
import area.AreaStringOutputter;
import city.House;
import shapes.elementar.Circle;
import shapes.elementar.Ellipse;
import shapes.elementar.Square;

public class Application {
    public static void main(String[] args) {
        Square square = new Square(3);
        Circle circle = new Circle(5);
        House house = new House();
        Ellipse ellipse = new Ellipse(2,3);
        AreaAggregator areaAggregator = new AreaAggregator();
        areaAggregator.addObject(square);
        areaAggregator.addObject(circle);
        areaAggregator.addObject(ellipse);
        areaAggregator.addObject(house);
        System.out.println(new AreaStringOutputter().output(areaAggregator));
    }
}
