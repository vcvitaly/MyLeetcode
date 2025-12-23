package com.github.vcvitaly._225;

import java.util.LinkedList;
import java.util.Queue;

public class QueueBasedStack {

    private final Queue<Integer> q1 = new LinkedList<>();
    private final Queue<Integer> q2 = new LinkedList<>();

    public QueueBasedStack() {}

    public void push(int x) {
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        q1.add(x);
        while (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
