package sort;

import java.util.List;
import java.util.ListIterator;

public interface Sort<T extends Comparable<T>> {
    String name();

    void sort(Object[] values);


    @SuppressWarnings({"unchecked"})
    default void sort(List<T> values) {
        Object[] objects = values.toArray();
        sort(objects);
        ListIterator<T> i = values.listIterator();
        for (Object e : objects) {
            i.next();
            i.set((T)e);
        }
    }
}
