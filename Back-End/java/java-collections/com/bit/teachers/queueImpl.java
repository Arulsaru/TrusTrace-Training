package com.bit.teachers;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueImpl implements methods {
    Queue<String> teachersQueue = new PriorityQueue<>();
    boolean isQueueEmpty() {
        return teachersQueue.isEmpty();
    }
    void printTeachersFromQueue() {
        if(isQueueEmpty()) {
            printEmptyMessage("queue");
        }
        for(String str: teachersQueue) {
            System.out.println(str);
        }
    }

    @Override
    public void printEmptyMessage(String location) {
        System.out.println(location + " is empty");
    }
}
