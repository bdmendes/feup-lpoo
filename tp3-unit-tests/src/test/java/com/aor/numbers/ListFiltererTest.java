package com.aor.numbers;

import com.aor.numbers.filterer.DivisibleByFilter;
import com.aor.numbers.filterer.IListFilter;
import com.aor.numbers.filterer.ListFilterer;
import com.aor.numbers.filterer.PositiveFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    private List<Integer> list;

    @BeforeEach
    void setup(){
        this.list = Arrays.asList(1,4,3,-6,9,11,12,-3);
    }

    @Test
    public void genericFilter(){
        ListFilterer filterer = new ListFilterer(list);
        IListFilter filterTrue = Mockito.mock(IListFilter.class);
        Mockito.when(filterTrue.accept(Mockito.any())).thenReturn(true);
        Assertions.assertEquals(filterer.filter(filterTrue), list);
    }

    @Test
    public void positiveFilter(){
        ListFilterer filterer = new ListFilterer(list);
        Assertions.assertEquals(filterer.filter(new PositiveFilter()), Arrays.asList(1,4,3,9,11,12));
    }

    @Test
    public void DivisibleFilter(){
        ListFilterer filterer = new ListFilterer(list);
        Assertions.assertEquals(filterer.filter(new DivisibleByFilter(3)), Arrays.asList(3,-6,9,12,-3));
    }
}
