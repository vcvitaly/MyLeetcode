package com.github.vcvitaly._1116;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private final AtomicReference<NumberKind> currentKind = new AtomicReference<>(NumberKind.ZERO);
    private final AtomicInteger number = new AtomicInteger(1);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (number.get() <= n) {
            waitForAndExecute(NumberKind.ZERO, () -> {
                printNumber.accept(0);
                currentKind.set(number.get() % 2 == 1 ? NumberKind.ODD : NumberKind.EVEN);
            });
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        prntNm(NumberKind.EVEN, printNumber);
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        prntNm(NumberKind.ODD, printNumber);
    }

    private void prntNm(NumberKind kind, IntConsumer printNumber) throws InterruptedException {
        while (number.get() <= n) {
            waitForAndExecute(kind, () -> {
                printNumber.accept(number.getAndIncrement());
                currentKind.set(NumberKind.ZERO);
            });

        }
    }

    private void waitForAndExecute(NumberKind kind, Runnable r) throws InterruptedException {
        while (currentKind.get() != kind && number.get() <= n) {
            Thread.sleep(0, 1);
        }
        if (number.get() <= n) {
            r.run();
        }
    }

    private enum NumberKind {
        ZERO, EVEN, ODD
    }
}
