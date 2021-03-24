package com.aor.numbers;

import com.aor.numbers.aggregator.ListAggregator;
import com.aor.numbers.deduplicator.IListDeduplicator;
import com.aor.numbers.sorter.IListSorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

        @Nested
        class StubListDeduplicator implements IListDeduplicator {
            @Override
            public List<Integer> deduplicate(IListSorter sorter) {
                return Arrays.asList(1,2,4,5);
            }
        }

        @Test
        public void distinct() {
            ListAggregator aggregator = new ListAggregator(list);
            int distinct = aggregator.distinct(new StubListDeduplicator());
            Assertions.assertEquals(4, distinct);
        }
    }

    @Nested
    class ListAggregatorTestCornerCase1 {

        @Test
        public void max_bug_7263(){
            List<Integer> list = Arrays.asList(-1,-4,-5);
            ListAggregator aggregator = new ListAggregator(list);
            int max = aggregator.max();
            Assertions.assertEquals(-1,max);
        }
    }

    @Nested
    class ListAggregatorTestCornerCase2 {

        @Test
        public void distinct_bug_8726(){
            List<Integer> list = Arrays.asList(1,2,4,2);
            ListAggregator aggregator = new ListAggregator(list);

            IListDeduplicator deduplicator = Mockito.mock(IListDeduplicator.class);
            Mockito.when(deduplicator.deduplicate(Mockito.any())).thenReturn(Arrays.asList(1,2,4));

            int distinct = aggregator.distinct(deduplicator);
            Assertions.assertEquals(3,distinct);
        }
    }
}
