package sort;

public class MergeSortOptimized<T extends Comparable<T>> extends MergeSort<T> implements Sort<T> {

    private InsertionSort<T> insertionSort = new InsertionSort<>();

    @Override
    public String name() {
        return "归并排序（使用插入排序进行优化）";
    }

    @Override
    public void sort(Object[] values) {
        mergeSort(values, 0, values.length - 1);
    }

    private void mergeSort(Object[] values, int start, int end) {
        if (end - start <= 8) {
            insertionSort.insertSort(values, start, end);
        } else {
            int middle = (start + end) >> 1;
            mergeSort(values, start, middle);
            mergeSort(values, middle + 1, end);
            merge(values, start, middle, end);
        }
    }
}
