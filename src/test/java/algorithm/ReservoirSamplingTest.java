package algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ReservoirSamplingTest {

    @Test
    public void reservoirSamplingTest() {
        Map<Integer, Integer> countMap = new HashMap<>();
        // 模拟次数
        int frequency = 10000000;
        int poolSize = 5;
        List<Integer> dataStream = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        for (int i = 0; i< frequency; i++) {
            ReservoirSampling<Integer> reservoirSampling = new ReservoirSampling<>(dataStream, poolSize);
            reservoirSampling.getReservoir()
                    .forEach(result -> countMap.compute(result, (k,v) -> v == null ? 1: v + 1));
        }

        System.out.println("\n=============== 观察下列各个数的分布比例是否接近 ===============");
        countMap.forEach((k,v) -> System.out.println(k + ": " + v * 1.0 / poolSize /frequency * 100 + "%"));
        System.out.println("=============== 完成 ===============\n");
    }

}