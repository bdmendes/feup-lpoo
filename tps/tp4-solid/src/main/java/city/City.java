package city;

import area.SumProvider;

import java.util.List;

public class City implements SumProvider {
    private final List<House> houses;

    public City(List<House> houses) {
        this.houses = houses;
    }

    @Override
    public double sum() {
        double res = 0;
        for (House house: houses){
            res += house.getArea();
        }
        return res;
    }
}
