package algorithm;


import java.util.ArrayList;
import java.util.List;

import static util.CommonUtils.swap;

/**
 * 顺序统计量 查找第 i 小的元素
 */
public class SequentialStatistics {

    public static <T extends Comparable<T>> T sequentialStatistics(List<T> values, int i) {
        values = new ArrayList<>(values);
        return core(values, 0, values.size() - 1, i);
    }

    private static <T extends Comparable<T>> T core(List<T> values, int start, int end, int i) {
        if (start == end) {
            return values.get(start);
        }
        int middle = partition(values, start, end);
        // middle 下标的元素是 [start, end] 范围内的第 k 个元素
        int k = middle - start + 1;
        if (k == i) {
            return values.get(middle);
        }
        if (i > k) {
            return core(values, middle + 1, end, i - k);
        } else {
            return core(values, start, middle - 1, i);
        }
    }

    private static <T extends Comparable<T>> int partition(List<T> values, int start, int end) {
        T pivot = values.get(end);
        int i = start;
        for (int j = start; j < end; j++) {
            if (values.get(j).compareTo(pivot) < 0) {
                swap(values, i, j);
                i++;
            }
        }
        values.set(end, values.get(i));
        values.set(i, pivot);
        return i;
    }
}
