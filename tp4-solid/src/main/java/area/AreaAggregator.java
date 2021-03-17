package area;

import java.util.ArrayList;
import java.util.List;

public class AreaAggregator implements SumProvider{
    private final List<HasArea> objects = new ArrayList<>();

    public void addShape(HasArea object) {
        objects.add(object);
    }

    public double sum() {
        return objects.stream().mapToDouble(HasArea::getArea).sum();
    }
}
