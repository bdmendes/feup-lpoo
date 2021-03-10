package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;

    @Nested
    class ListAggregatorTestPublic{

        @BeforeEach
        public void setup(){
            list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(4);
            list.add(2);
            list.add(5);
        }

        @Test
        public void sum() {
            ListAggregator aggregator = new ListAggregator(list);
            int sum = aggregator.sum();
            Assertions.assertEquals(14, sum);
        }

        @Test
        public void max() {
            ListAggregator aggregator = new ListAggregator(list);
            int max = aggregator.max();
            Assertions.assertEquals(5, max);
        }

        @Test
        public void min() {
            ListAggregator aggregator = new ListAggregator(list);
            int min = aggregator.min();
            Assertions.assertEquals(1, min);
        }

        @Test
        public void distinct() {
            ListAggregator aggregator = new ListAggregator(list);
            int distinct = aggregator.distinct();
            Assertions.assertEquals(4, distinct);
        }
    }

    @Nested
    class ListAggregatorTestCornerCases {
        @Test
        public void max_bug_7263(){
            List<Integer> list = Arrays.asList(-1,-4,-5);
            ListAggregator aggregator = new ListAggregator(list);
            int max = aggregator.max();
            Assertions.assertEquals(-1,max);
        }
    }

}
