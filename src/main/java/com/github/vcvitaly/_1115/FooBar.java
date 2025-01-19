package com.github.vcvitaly._1115;

import java.util.concurrent.atomic.AtomicReference;

class FooBar {
    private int n;
    private final AtomicReference<Word> word = new AtomicReference<>(Word.FOO);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            while (!word.get().equals(Word.FOO)) {
                Thread.sleep(0, 1);
            }
            printFoo.run();
            word.set(Word.BAR);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!word.get().equals(Word.BAR)) {
                Thread.sleep(0, 1);
            }
            printBar.run();
            word.set(Word.FOO);
        }
    }

    private enum Word {
        FOO, BAR
    }

    private void printFoo() {
        System.out.print("foo");
    }

    private void printBar() {
        System.out.print("bar");
    }

    public static void main(String[] args) throws Exception {
        final FooBar fooBar = new FooBar(2);
//        test1(fooBar);
//        test2(fooBar);
        test3(fooBar);
    }

    private static void test1(FooBar fooBar) {
        startA(fooBar);
        startB(fooBar);
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
