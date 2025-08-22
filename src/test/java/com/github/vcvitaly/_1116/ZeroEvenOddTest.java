package com.github.vcvitaly._1116;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ZeroEvenOddTest {

    private ZeroEvenOdd zeroEvenOdd;
    private CountDownLatch latch;
    private final StringBuilder sb = new StringBuilder();

    @Test
    void testFor1() {
        asserted(1);
    }

    @Test
    void testFor2() {
        asserted(2);
    }

    @Test
    void testFor5() {
        asserted(5);
    }

    private void asserted(int n) {
        final String actual = runTest(n);
        final String expected = expected(n);
        assertThat(actual).isEqualTo(expected);
        System.out.printf("Actual [%s] is equal to expected [%s]%n", actual, expected);
    }

    private String runTest(int n) {
        try {
            zeroEvenOdd = new ZeroEvenOdd(n);
            latch = new CountDownLatch(n);
            runThread(zeroEvenOdd::zero);
            runThread(zeroEvenOdd::even);
            runThread(zeroEvenOdd::odd);
            latch.await(1, TimeUnit.SECONDS);
            return sb.toString();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Consumer<IntConsumer> getIntConsumerConsumer(ThrowingIntConsumerConsumer ticc) {
        return intConsumer -> {
            try {
                ticc.accept(intConsumer);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    private String expected(int n) {
        final StringBuilder expected = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            expected.append("0").append(i);
        }
        return expected.toString();
    }

    private void runThread(ThrowingIntConsumerConsumer ticc) {
        new Thread(() -> {
            try {
                ticc.accept(i -> {
                    sb.append(i);
                    if (i != 0) {
                        latch.countDown();
                    }
                });
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private interface ThrowingIntConsumerConsumer {
        void accept(IntConsumer consumer) throws Exception;
    }
}