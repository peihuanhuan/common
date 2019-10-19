package sort;

public class RadixSort implements Sort {
    @Override
    public String name() {
        return "基数排序";
    }

    @Override
    public void sort(int[] values) {
        int maxValue = 0;
        for (int v : values) {
            if (v < 0) {
                throw new IllegalArgumentException("基数排序不能排序负数");
            }
            if (v > maxValue) {
                maxValue = v;
            }
        }
        int[] saved = values;
        int count = digitCount(maxValue);
        for (int i = 1; i <= count; i++) {
            values = radixSort(values, i);
        }
        System.arraycopy(values, 0, saved, 0, values.length);
    }

    private int digitCount(int value) {
        int count = 0;
        while (value > 0) {
            value /= 10;
            count++;
        }
        return count;
    }

    private int[] radixSort(int[] values, int radix) {
        int[] tmp = new int[10];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = 0;
        }

        for (int value : values) {
            tmp[getDigit(value, radix)]++;
        }

        for (int i = 1; i < tmp.length; i++) {
            tmp[i] += tmp[i - 1];
        }

        int[] outValues = new int[values.length];
        for (int i = values.length - 1; i >= 0; i--) {
            outValues[tmp[getDigit(values[i], radix)] - 1] = values[i];
            tmp[getDigit(values[i], radix)]--;
        }
        return outValues;
    }

    private int getDigit(int value, int radix) {
        if (radix < 1) {
            throw new IllegalArgumentException("位数不能小于 1");
        }
        int result = 0;
        for (int i = 0; i < radix; i++) {
            result = value % 10;
            value = value / 10;
        }
        return result;
    }
}
