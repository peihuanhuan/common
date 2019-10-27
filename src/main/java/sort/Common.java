package sort;

public class Common {

    static void exchangeValue(Object[] values, int i, int j) {
        Object tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
}
