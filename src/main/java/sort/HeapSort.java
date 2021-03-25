package sort;

import util.CommonUtils;

import static util.CommonUtils.swap;

public class HeapSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public String name() {
        return "堆排序";
    }

    @Override
    public void sort(Object[] values) {
        buildHeap(values);
        int length = values.length;

        while (length >= 2) {
            CommonUtils.swap(values, length - 1, 0);
            length--;

            keepHeapify(values, length, 0);
        }
    }


    private void buildHeap(Object[] values) {
        for (int i = (values.length - 2) >> 1; i >= 0; i--) {
            keepHeapify(values, values.length, i);
        }
    }

    @SuppressWarnings("unchecked")
    private void keepHeapify(Object[] values, int length, int index) {
        int leftIndex = (index << 1) + 1;
        int rightIndex = (index << 1) + 2;
        int maxValueIndex = index;

        if (leftIndex < length && ((Comparable)values[leftIndex]).compareTo(values[maxValueIndex]) > 0) {
            maxValueIndex = leftIndex;
        }

        if (rightIndex < length && ((Comparable)values[rightIndex]).compareTo(values[maxValueIndex]) > 0) {
            maxValueIndex = rightIndex;
        }

        if (maxValueIndex != index) {
            CommonUtils.swap(values, index, maxValueIndex);
            keepHeapify(values, length, maxValueIndex);
        }
    }
}
