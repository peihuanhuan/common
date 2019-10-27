package sort;

import java.util.ArrayList;

public class BucketSort implements SimpleSort{

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
        int maxValue = values[0];
        int minValue = values[0];
        for (int v : values) {
            if (v < minValue) {
                minValue = v;
            } else if (v > maxValue) {
                maxValue = v;
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
