package algorithm;

import util.CommonUtils;

import java.util.List;

/**
 * 洗牌算法 随机打乱一个数组
 */
public class KnuthShuffle {

    public static void randomizedArray(Object[] array) {
        int p = array.length;
        while (p > 0) {
            int index  = (int) Math.floor(Math.random() * p--);
            CommonUtils.exchangeValue(array, index, p);
        }
    }

    public static void randomizedArray(List<?> array) {
        int p = array.size();
        while (p > 0) {
            int index  = (int) Math.floor(Math.random() * p--);
            CommonUtils.exchangeValue(array, index, p);
        }
    }
}
