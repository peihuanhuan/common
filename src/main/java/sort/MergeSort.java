package sort;

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public String name() {
        return "归并排序";
    }

    @Override
    public void sort(Object[] values) {
        mergeSort(values, 0, values.length - 1);
    }

    private void mergeSort(Object[] values, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) >> 1;
        mergeSort(values, start, middle);
        mergeSort(values, middle + 1, end);
        merge(values, start, middle, end);
    }

    @SuppressWarnings("unchecked")
    void merge(Object[] values, int start, int middle, int end) {
        Object[] left = Arrays.copyOfRange(values, start, middle + 1);
        Object[] right = Arrays.copyOfRange(values, middle + 1, end + 1);

        int l = 0;
        int r = 0;
        int s = start;
        while (l < left.length && r < right.length) {
            if (((Comparable) left[l]).compareTo(right[r]) >= 0) {
                values[s++] = right[r++];
            } else {
                values[s++] = left[l++];
            }
        }
        if (l < left.length) {
            System.arraycopy(left, l, values, s, left.length - l);
        } else if (r < right.length) {
            System.arraycopy(right, r, values, s, right.length - r);
        }
    }
}
