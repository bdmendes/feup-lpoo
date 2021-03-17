package shapes;
import area.HasArea;

public interface Shape extends BasicShape, HasArea {
    double getArea();
    void draw();
}
