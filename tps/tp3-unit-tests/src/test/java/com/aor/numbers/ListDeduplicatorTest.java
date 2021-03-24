package com.aor.numbers;

import com.aor.numbers.deduplicator.ListDeduplicator;
import com.aor.numbers.sorter.IListSorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    private List<Integer> list, expected;

    @Nested
    class DeduplicatorOriginal {

        @Test
        public void deduplicate() {
            list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(4);
            list.add(2);
            list.add(5);

            expected = new ArrayList<>();
            expected.add(1);
            expected.add(2);
            expected.add(4);
            expected.add(5);

            IListSorter sorter = Mockito.mock(IListSorter.class);
            Mockito.when(sorter.sort()).thenReturn(Arrays.asList(1,2,2,4,5));

            ListDeduplicator deduplicator = new ListDeduplicator(list);
            List<Integer> distinct = deduplicator.deduplicate(sorter);

            Assertions.assertEquals(expected, distinct);
        }
    }

    @Nested
    class DeduplicatorEdgeCase {
        @Test
        public void deduplicate() {
            list = Arrays.asList(1,2,4,2);
            expected = Arrays.asList(1,2,4);

            IListSorter sorter = Mockito.mock(IListSorter.class);
            Mockito.when(sorter.sort()).thenReturn(Arrays.asList(1,2,2,4));

            ListDeduplicator deduplicator = new ListDeduplicator(list);
            List<Integer> distinct = deduplicator.deduplicate(sorter);

            Assertions.assertEquals(expected, distinct);
        }
    }
}
