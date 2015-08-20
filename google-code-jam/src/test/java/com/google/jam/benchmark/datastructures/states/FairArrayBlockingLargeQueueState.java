package com.google.jam.benchmark.datastructures.states;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class FairArrayBlockingLargeQueueState
        extends AbstractLargeQueueState {

    @Override
    public Queue<Integer> buildQueue(int queueCapacity) {
        return new ArrayBlockingQueue<>(queueCapacity, true);
    }
}
