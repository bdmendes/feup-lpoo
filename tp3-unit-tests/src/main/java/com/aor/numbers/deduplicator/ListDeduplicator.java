package com.aor.numbers.deduplicator;

import com.aor.numbers.sorter.IListSorter;
import com.aor.numbers.sorter.ListSorter;

import java.util.ArrayList;
import java.util.List;

/**
 * An utility class that removes duplicate numbers
 * from a list.
 */
public class ListDeduplicator implements IListDeduplicator {
    private final List<Integer> list;

    public ListDeduplicator(List<Integer> list) {
        this.list = list;
    }

    /**
     * Removes duplicate numbers from a list.
     * @return A list having the same numbers as the original
     * but withou duplicates. The order of the numbers might
     * change.
     */
    public List<Integer> deduplicate(IListSorter sorter) {
        ListSorter listSorter = new ListSorter(list);
        List<Integer> sorted = sorter.sort();
        List<Integer> unique = new ArrayList<>();

        Integer last = null;

        for (Integer number : sorted)
            if (!number.equals(last)) {
                last = number;
                unique.add(number);
            }

        return unique;
    }
}
