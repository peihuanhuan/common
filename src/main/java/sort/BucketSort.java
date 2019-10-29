package sort;

import java.util.ArrayList;

public class BucketSort implements SimpleSort {

    private int bucketSize = 3;
    private Sort subSort;

    public BucketSort() {
    }

    public BucketSort(int bucketSize, Sort subSort) {
        this.bucketSize = bucketSize;
        this.subSort = subSort;
    }

    @Override
    public String name() {
        return "桶排序";
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sort(int[] values) {
        if (values.length == 0) {
            return;
        }

        int maxValue;
        int minValue;
        int s;
        if (values.length % 2 == 1) {
            maxValue = values[0];
            minValue = values[0];
            s = 1;
        } else {
            maxValue = Math.max(values[0], values[1]);
            minValue = Math.min(values[0], values[1]);
            s = 2;
        }
        for (; s < values.length; s += 2) {
            int a = values[s];
            int b = values[s + 1];
            if (a > b) {
                if (a > maxValue) {
                    maxValue = a;
                }
                if (b < minValue) {
                    minValue = b;
                }
            } else {
                if (b > maxValue) {
                    maxValue = b;
                }
                if (a < minValue) {
                    minValue = a;
                }
            }
        }


        int bucketNum = (int) Math.ceil(1.0 * (maxValue - minValue + 1) / bucketSize);
        // 区间是 前闭后开
        ArrayList<Integer>[] buckets = (ArrayList<Integer>[]) new ArrayList[bucketNum];

        for (int i = 0, len = buckets.length; i < len; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int v : values) {
            int index = (v - minValue) / bucketSize;
            buckets[index].add(v);
        }

        int i = 0;
        for (ArrayList<Integer> bucket : buckets) {
            subSort.sort(bucket);
            for (int v : bucket) {
                values[i++] = v;
            }
        }
    }
}
