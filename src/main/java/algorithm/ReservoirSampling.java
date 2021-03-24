package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 蓄水池抽样算法
 */
public class ReservoirSampling<T> {

    /**
     * 蓄水池，即采样结果
     */
    private final List<T> reservoir;
    /**
     * 蓄水池允许的最大大小
     */
    private final int reservoirSize;
    /**
     * 已处理的样本量
     */
    private int simpleSize = 0;

    public ReservoirSampling(int reservoirSize) {
        this.reservoirSize = reservoirSize;
        this.reservoir = new ArrayList<>(reservoirSize);
    }

    public ReservoirSampling(List<T> dataStream, int reservoirSize) {
        this.reservoirSize = reservoirSize;
        this.reservoir = new ArrayList<>(reservoirSize);
        dataStream.forEach(this::sampling);
    }

    /**
     * 允许在执行过程中添加样本到数据流中并采样
     *
     * @param sample 新增样本
     */
    public ReservoirSampling<T> addDataToSimple(T sample) {
        sampling(sample);
        return this;
    }


    /**
     * 对某个样本进行采样
     */
    private void sampling(T simple) {
        simpleSize++;
        if (reservoirNotFull()) {
            reservoir.add(simple);
            return;
        }

        int index = new Random().nextInt(simpleSize);
        if (index < reservoirSize) {
            reservoir.set(index, simple);
        }
    }

    private boolean reservoirNotFull() {
        return simpleSize <= reservoirSize;
    }

    public List<T> getReservoir() {
        return Collections.unmodifiableList(reservoir);
    }

    public int getReservoirSize() {
        return reservoirSize;
    }

    public int getSimpleSize() {
        return simpleSize;
    }
}
