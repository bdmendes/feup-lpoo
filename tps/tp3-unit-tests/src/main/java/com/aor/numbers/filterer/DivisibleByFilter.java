package com.aor.numbers.filterer;

public class DivisibleByFilter implements IListFilter{
    private Integer divisor;

    public DivisibleByFilter(Integer divisor){
        this.divisor = divisor;
    }

    @Override
    public boolean accept(Integer number) {
        return number % divisor == 0;
    }
}
