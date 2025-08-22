package com.github.vcvitaly._1195;

import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Test
    void test1() throws Exception {
        runTest(
                15,
                List.of(
                        "1","2","fizz","4","buzz","fizz","7","8",
                        "fizz","buzz","11","fizz","13","14","fizzbuzz"
                )
        );
    }

    @Test
    void test2() throws Exception {
        runTest(
                5,
                List.of(
                        "1","2","fizz","4","buzz"
                )
        );
    }

    @Test
    void test3() throws Exception {
        runTest(
                2,
                List.of(
                        "1","2"
                )
        );
    }

    private void runTest(int n, List<String> expected) throws InterruptedException {
        fizzBuzz = new FizzBuzz(n);
        final List<String> res = new LinkedList<>();
        new Thread(() -> {
            try {
                fizzBuzz.number(i -> res.add(String.valueOf(i)));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> res.add("fizz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> res.add("buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> res.add("fizzbuzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        Thread.sleep(1_000);
        assertThat(res).isEqualTo(expected);
    }
}