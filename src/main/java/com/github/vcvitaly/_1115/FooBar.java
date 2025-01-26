package com.github.vcvitaly._1115;

import java.util.concurrent.atomic.AtomicReference;

class FooBar {
    private int n;
    private final Object lock = new Object();
    private boolean isFoo = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (lock) {
            System.out.println("Entering foo synchronized");
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while (!isFoo) {
                    try {
                        System.out.println("FooThread is waiting for lock");
                        lock.wait();
                        System.out.println("FooThread woke up");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                printFoo.run();
                isFoo = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (lock) {
            System.out.println("Entering bar synchronized");
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while (isFoo) {
                    try {
                        System.out.println("BarThread is waiting for lock");
                        lock.wait();
                        System.out.println("BarThread woke up");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                printBar.run();
                isFoo = true;
                lock.notifyAll();
            }
        }
    }

    private void printFoo() {
        System.out.print("foo");
    }

    private void printBar() {
        System.out.print("bar");
    }

    public static void main(String[] args) throws Exception {
        final FooBar fooBar = new FooBar(2);
        test1(fooBar);
//        test2(fooBar);
//        test3(fooBar);
    }

    private static void test1(FooBar fooBar) throws Exception {
        startB(fooBar);
        Thread.sleep(0, 1);
        startA(fooBar);
    }

    private static void test2(FooBar fooBar) throws Exception {
        startA(fooBar);
        Thread.sleep(50);
        startB(fooBar);
    }

    private static void test3(FooBar fooBar) throws Exception {
        startB(fooBar);
        Thread.sleep(50);
        startA(fooBar);
    }

    private static void startB(FooBar fooBar) {
        new Thread(() -> {
            try {
                fooBar.bar(fooBar::printBar);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private static void startA(FooBar fooBar) {
        new Thread(() -> {
            try {
                fooBar.foo(fooBar::printFoo);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
