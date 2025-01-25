package com.github.vcvitaly._1188;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class BoundedBlockingQueue {

    private final Queue<Integer> queue = new LinkedList<>();
    private final Object lock = new Object();
    private final Semaphore wSemaphore;
    private final Semaphore rSemaphore;

    public BoundedBlockingQueue(int capacity) {
        wSemaphore = new Semaphore(capacity);
        rSemaphore = new Semaphore(0);
    }

    public void enqueue(int element) throws InterruptedException {
        wSemaphore.acquire();
        synchronized (lock) {
            queue.add(element);
            rSemaphore.release();
        }
    }

    public int dequeue() throws InterruptedException {
        rSemaphore.acquire();
        synchronized (lock) {
            final Integer elem = queue.remove();
            wSemaphore.release();
            return elem;
        }
    }

    public int size() {
        synchronized (lock) {
            return queue.size();
        }
    }
}
