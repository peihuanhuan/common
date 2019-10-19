package sort;

public class CountingSort implements Sort {

    @Override
    public String name() {
        return "计数排序";
    }

    @Override
    public void sort(int[] values) {
        int maxValue = 0;
        for (int v : values) {
            if (v < 0) {
                throw new IllegalArgumentException("不能排序负数");
            }
            if (v > maxValue) {
                maxValue = v;
            }
        }

        int[] tmp = new int[maxValue + 1];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = 0;
        }

        for (int value : values) {
            tmp[value]++;
        }

        for (int i = 1; i < tmp.length; i++) {
            tmp[i] += tmp[i - 1];
        }

        int[] outValues = new int[values.length];
        for (int i = values.length - 1; i >= 0; i--) {
            outValues[tmp[values[i]] - 1] = values[i];
            tmp[values[i]]--;
        }
        System.arraycopy(outValues, 0, values, 0, outValues.length);
    }
}