package sort;

public class HeapSort implements Sort {

    @Override
    public String name() {
        return "堆排序";
    }

    @Override
    public void sort(int[] values) {

        buildHeap(values);
        int length = values.length;

        while (length >= 2) {

            int tmp = values[length - 1];
            values[length - 1] = values[0];
            values[0] = tmp;

            length--;

            keepHeapify(values, length, 0);
        }
    }


    private void buildHeap(int[] values) {
        for (int i = (values.length - 2) / 2; i >= 0; i--) {
            keepHeapify(values, values.length, i);
        }
    }

    private void keepHeapify(int[] values, int length, int index) {
        int leftIndex = (index << 1) + 1;
        int rightIndex = (index << 1) + 2;
        int maxValueIndex = index;

        if (leftIndex < length && values[leftIndex] > values[maxValueIndex]) {
            maxValueIndex = leftIndex;
        }

        if (rightIndex < length && values[rightIndex] > values[maxValueIndex]) {
            maxValueIndex = rightIndex;
        }

        if (maxValueIndex != index) {

            int tmp = values[index];
            values[index] = values[maxValueIndex];
            values[maxValueIndex] = tmp;

            keepHeapify(values, length, maxValueIndex);
        }
    }
}
