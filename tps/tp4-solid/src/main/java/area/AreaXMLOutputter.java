package area;

public class AreaXMLOutputter {
    private final SumProvider provider;
    public AreaXMLOutputter(SumProvider provider){
        this.provider = provider;
    }
    public String output(){
        return "<area>" + provider.sum() + "</area>";
    }
}
