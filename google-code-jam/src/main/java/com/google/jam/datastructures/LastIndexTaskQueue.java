package com.google.jam.datastructures;

import java.util.Queue;

public interface LastIndexTaskQueue<E>
        extends Queue<E> {

    int getLastRetrievedTaskIndex();
}
