package com.aor.numbers.filterer;

public class PositiveFilter implements IListFilter {
    public boolean accept(Integer number){
        return number >= 0;
    }
}
