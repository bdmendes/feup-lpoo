package shapes;
import area.HasArea;

public interface AreaShape extends Shape, HasArea {
    double getArea();
}
