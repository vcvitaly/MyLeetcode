package com.github.vcvitaly._1195;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntConsumer;

public class FizzBuzz {

    private int n;
    private final AtomicInteger cur = new AtomicInteger(1);
    private final AtomicReference<Method> currentMethod;

    public FizzBuzz(int n) {
        this.n = n;
        currentMethod = new AtomicReference<>(Method.NUMBER);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        runInLoop(Method.FIZZ, printFizz);
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        runInLoop(Method.BUZZ, printBuzz);
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        runInLoop(Method.FIZZBUZZ, printFizzBuzz);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        runInLoop(Method.NUMBER, () -> printNumber.accept(cur.get()));
    }

    private void runInLoop(Method m, Runnable r) throws InterruptedException {
        while (cur.get() <= n) {
            if (currentMethod.get() == m) {
                r.run();
                currentMethod.set(next(cur.incrementAndGet()));
            } else {
                busyWait();
            }
        }
    }

    private void busyWait() throws InterruptedException {
        Thread.sleep(0, 10);
    }

    private Method next(int curNum) {
        if (curNum % 3 == 0 && curNum % 5 == 0) {
            return Method.FIZZBUZZ;
        }
        if (curNum % 3 == 0) {
            return Method.FIZZ;
        }
        if (curNum % 5 == 0) {
            return Method.BUZZ;
        }
        return Method.NUMBER;
    }

    private enum Method {
        FIZZ, BUZZ, FIZZBUZZ, NUMBER
    }
}
