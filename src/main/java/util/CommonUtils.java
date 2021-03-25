package util;

import java.util.List;

public class CommonUtils {

    public static void swap(Object[] values, int i, int j) {
        Object tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

    public static <T> void swap(List<T> values, int i, int j) {
        T tmp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, tmp);
    }
}
