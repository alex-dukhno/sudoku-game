package com.google.jam.benchmark.datastructures.states;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class UnfairArrayBlockingBigQueueState
        extends AbstractBigQueueState {

    @Override
    public Queue<Integer> buildQueue(int queueCapacity) {
        return new ArrayBlockingQueue<>(queueCapacity, false);
    }
}
