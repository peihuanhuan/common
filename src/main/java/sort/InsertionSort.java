package sort;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public String name() {
        return "插入排序";
    }

    @Override
    public void sort(Object[] values) {
        insertSort(values, 0, values.length - 1);
    }


    @SuppressWarnings("unchecked")
    void insertSort(Object[] values, int start, int end) {
        for (int i = start; i <= end; i++) {
            int j = i -1;
            Object key = values[i];
            while (j >= start && ((Comparable)values[j]).compareTo(key) > 0) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = key;
        }
    }
}