package area;
import shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class AreaAggregator {
    private final List<HasArea> objects = new ArrayList<>();

    public void addObject(HasArea object) {
        objects.add(object);
    }

    public double sum() {
        return objects.stream().mapToDouble(HasArea::getArea).sum();
    }
}