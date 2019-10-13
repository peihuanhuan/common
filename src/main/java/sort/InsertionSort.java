package sort;

public class InsertionSort implements Sort {

    @Override
    public String name() {
        return "插入排序";
    }

    @Override
    public void sort(int[] values) {
        for (int i = 1; i < values.length; i++) {
            int j = i -1;
            int key = values[i];
            while (j >= 0 && values[j] > key) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = key;
        }
    }
}