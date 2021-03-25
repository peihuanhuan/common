package algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static algorithm.KnuthShuffle.randomizedArray;

public class KnuthShuffleTest {

    @Test
    public void randomizedArrayTest() {
        Random random = new Random();
        int size  = random.nextInt(10000);
        List<Integer> values = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            values.add(random.nextInt());
        }

        List<Integer> copied = new ArrayList<>(values);
        randomizedArray(copied);

        Assert.assertEquals(values.size(), copied.size());
        values.removeAll(copied);
        Assert.assertEquals(values.size(),0);

    }
}