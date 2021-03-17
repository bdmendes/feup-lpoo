package area;

public class AreaStringOutputter {
    public String output(AreaAggregator area){
        return String.valueOf(area.sum());
    }
}
