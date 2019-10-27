package sort;

public interface SimpleSort<T extends Comparable<T>> {
    String name();

    void sort(int[] values);
}
