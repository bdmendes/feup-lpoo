package area;

public class AreaStringOutputter {
    private final SumProvider provider;

    public AreaStringOutputter(SumProvider provider) {
        this.provider = provider;
    }

    public String output(){
        return "Sum of areas: " + String.valueOf(provider.sum());
    }
}
