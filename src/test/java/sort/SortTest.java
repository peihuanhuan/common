package sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class SortTest {

    @Test
    public void sort() {
        Random random = new Random();

        int size = 5000000 + 1;
        List<Integer> values = new ArrayList<>(size);
        Map<Integer, Integer> originValueCount = new HashMap<>();
        for (int i = 0; i < size; i++) {
            values.add(random.nextInt(size));
            originValueCount.compute(values.get(i), (k, v) -> (v == null) ? 1 : v + 1);
        }


        System.out.println("/***********************************************************/\n");

        runAndcheck(new BucketSort(8, new InsertionSort()), values, originValueCount);

        runAndcheck(new RadixSort(), values, originValueCount);

        runAndcheck(new CountingSort(), values, originValueCount);

        runAndcheck(new QuickSort<>(), values, originValueCount);

        runAndcheck(new MergeSort<>(), values, originValueCount);

        runAndcheck(new MergeSortOptimized<>(), values, originValueCount);

        runAndcheck(new HeapSort<>(), values, originValueCount);

        runAndcheck(new InsertionSort<>(), values, originValueCount);


        System.out.println("\n/***********************************************************/");
    }

    private void runAndcheck(Sort<Integer> sort, List<Integer> values, Map<Integer, Integer> originValueCount) {
        List<Integer> copiedValues = new ArrayList<>(values);

        long start = System.currentTimeMillis();
        sort.sort(copiedValues);
        long end = System.currentTimeMillis();

        Map<Integer, Integer> sortedValuesCount = new HashMap<>();
        for (int value : copiedValues) {
            sortedValuesCount.compute(value, (k, v) -> (v == null) ? 1 : v + 1);
        }

        originValueCount.forEach((k, v) -> {
            if (!v.equals(sortedValuesCount.get(k))) {
                throw new RuntimeException("元素不匹配");
            }
        });

        Assert.assertTrue(testCorrectness(copiedValues));

        System.out.println(sort.name() + ": " + String.format("%.3f 秒", (end - start) / 1000.0));

    }

    private void runAndcheck(SimpleSort sort, List<Integer> values, Map<Integer, Integer> originValueCount) {
        int[] copiedValues = new int[values.size()];
        for (int i = 0; i < copiedValues.length; i++) {
            copiedValues[i] = values.get(i);
        }

        long start = System.currentTimeMillis();
        sort.sort(copiedValues);
        long end = System.currentTimeMillis();

        Map<Integer, Integer> sortedValuesCount = new HashMap<>();
        for (int value : copiedValues) {
            sortedValuesCount.compute(value, (k, v) -> (v == null) ? 1 : v + 1);
        }

        originValueCount.forEach((k, v) -> {
            if (!v.equals(sortedValuesCount.get(k))) {
                throw new RuntimeException("元素不匹配");
            }
        });

        Assert.assertTrue(testCorrectness(copiedValues));

        System.out.println(sort.name() + ": " + String.format("%.3f 秒", (end - start) / 1000.0));

    }

    private boolean testCorrectness(List<Integer> values) {
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) > values.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean testCorrectness(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] > values[i + 1]) {
                return false;
            }
        }
        return true;
    }

}