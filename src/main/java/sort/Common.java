package sort;

import java.util.List;

public class Common {

    public static void exchangeValue(Object[] values, int i, int j) {
        Object tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

    public static <T>void exchangeValue(List<T> values, int i, int j) {
        T tmp = values.get(i);
        values.set(i, values.get(j));
        values.set(j, tmp);
    }
}
