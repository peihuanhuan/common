package sort;

public class QuickSort implements Sort {
    @Override
    public String name() {
        return "快速排序";
    }

    @Override
    public void sort(int[] values) {
        quickSort(values, 0 , values.length - 1);
    }

    private void quickSort(int[] values, int start, int end) {
        if (start < end) {
            int core = partition(values, start, end);
            quickSort(values, start, core - 1);
            quickSort(values, core + 1, end);
        }
    }

    private int partition(int[] values, int start, int end) {
        int privot = values[end];
        int i = start;
        for (int j = start; j < end; j++) {

            if (values[j] < privot) {

                int tmp = values[i];
                values[i] = values[j];
                values[j] = tmp;

                i++;
            }
        }
        values[end] = values[i];
        values[i] = privot;
        return i;
    }
}
