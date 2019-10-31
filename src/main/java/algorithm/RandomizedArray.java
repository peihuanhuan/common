package algorithm;

import sort.QuickSort;
import sort.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * 随机化打乱一个数组
 */
public class RandomizedArray {

    @SuppressWarnings({"unchecked"})
    public static void randomizedArray(List array) {
        List<WeightedObject> weights = new ArrayList<>(array.size());
        Random random = new Random();
        for (Object o : array) {
            weights.add(new WeightedObject(random.nextInt(array.size()), o));
        }
        Sort<WeightedObject> sort = new QuickSort<>();
        sort.sort(weights);

        ListIterator i = array.listIterator();
        for (WeightedObject e : weights) {
            i.next();
            i.set(e.o);
        }
    }


    private static class WeightedObject implements Comparable<WeightedObject> {
        int key;
        Object o;

        WeightedObject(int key, Object o) {
            this.key = key;
            this.o = o;
        }

        @Override
        public int compareTo(WeightedObject o) {
            return key - o.key;
        }
    }
}
