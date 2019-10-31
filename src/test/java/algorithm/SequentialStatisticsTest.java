package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static algorithm.SequentialStatistics.sequentialStatistics;

public class SequentialStatisticsTest {

    @Test
    public void sequentialStatisticsTest() {
        int size = new Random().nextInt(10000);
        List<Integer> values = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            values.add(i);
        }

        RandomizedArray.randomizedArray(values);

        for (int i = 1; i <= size; i++) {
            Assert.assertEquals(sequentialStatistics(values, i), new Integer(i));
        }
    }
}