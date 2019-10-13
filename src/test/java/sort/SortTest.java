package sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class SortTest {

    @Test
    public void sort() {
        Random random = new Random();

        int size = random.nextInt(1000000);
        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = random.nextInt();
        }


        System.out.println("/***********************************************************/\n");

        runAndTiming(new HeapSort(), values);
        runAndTiming(new MergeSort(), values);
        runAndTiming(new InsertionSort(), values);

        System.out.println("\n/***********************************************************/");


    }

    private void runAndTiming(Sort sort, int[] values) {
        int[] copiedValues = Arrays.copyOfRange(values, 0, values.length - 1);
        long start = System.currentTimeMillis();
        sort.sort(copiedValues);
        long end = System.currentTimeMillis();

        Assert.assertTrue(testCorrectness(copiedValues));

        System.out.println(sort.name() + ": " + String.format("%.3f 秒", (end - start) / 1000.0));

    }

    private boolean testCorrectness(int[] values) {
        for (int i = 0;i < values.length - 1; i++){
            if (values[i] > values[i+1]) {
                return false;
            }
        }
        return true;
    }

}