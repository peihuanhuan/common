package sort;

import java.util.Arrays;

public class MergeSort implements Sort{

    @Override
    public String name() {
        return "归并排序";
    }

    @Override
    public void sort(int[] values) {
        mergeSort(values, 0, values.length - 1);
    }

    private void mergeSort(int[] values, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(values, start, middle);
        mergeSort(values, middle + 1, end);
        merge(values, start, middle, end);
    }

    private void merge(int[] values, int start, int middle, int end) {
        int[] left = Arrays.copyOfRange(values, start, middle + 1);
        int[] right = Arrays.copyOfRange(values, middle + 1, end + 1);

        int l = 0;
        int r = 0;
        int s =start;
        while (l < left.length && r < right.length) {
            if (left[l] >= right[r]) {
                values[s++] = right[r++];
            } else {
                values[s++] = left[l++];
            }
        }
        if (l < left.length) {
            System.arraycopy(left, l, values, s, left.length - l);
        } else if (r < right.length){
            System.arraycopy(right, r, values, s, right.length - r);
        }
    }
}
