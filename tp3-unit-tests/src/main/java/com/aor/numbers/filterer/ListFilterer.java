package com.aor.numbers.filterer;

import java.util.List;
import java.util.stream.Collectors;

public class ListFilterer {
    private final List<Integer> list;

    public ListFilterer(List<Integer> list){
        this.list = list;
    }

    public List<Integer> filter(IListFilter flt){
        return list.stream().filter(flt::accept).collect(Collectors.toList());
    }
}
