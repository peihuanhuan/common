package sort;

import util.CommonUtils;

import static util.CommonUtils.swap;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public String name() {
        return "快速排序";
    }

    @Override
    public void sort(Object[] values) {
        quickSort(values, 0 , values.length - 1);
    }

    private void quickSort(Object[] values, int start, int end) {
        if (start < end) {
            int core = partition(values, start, end);
            quickSort(values, start, core - 1);
            quickSort(values, core + 1, end);
        }
    }

    @SuppressWarnings("unchecked")
    private int partition(Object[] values, int start, int end) {
        // 主元、基准
        Comparable privot = (Comparable) values[end];
        int i = start;
        for (int j = start; j < end; j++) {

            if (((Comparable)values[j]).compareTo(privot) < 0) {
                CommonUtils.swap(values, i, j);
                i++;
            }
        }
        values[end] = values[i];
        values[i] = privot;
        return i;
    }
}
