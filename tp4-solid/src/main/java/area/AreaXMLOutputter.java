package area;

public class AreaXMLOutputter {
    public String output(AreaAggregator area){
        return "<area>" + area.sum() + "</area>";
    }
}
