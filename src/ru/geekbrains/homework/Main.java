package ru.geekbrains.homework;

import java.util.Arrays;

public class Main extends Threads implements Runnable{
    private static final int SIZE = 10_000_000;
    private static final int thCOUNT = 2;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        Main main = new Main();
        float[]a = new float[SIZE];
        Arrays.fill(a,1f);

        long start = System.currentTimeMillis();
        main.firstMethod(a,0);
        final long res1 = System.currentTimeMillis() - start;
        System.out.println("One thread time:" + res1);

        start = System.currentTimeMillis();
        main.secondMethod(a, thCOUNT);
        final long res2 = System.currentTimeMillis() - start;
        System.out.println("Two threads time:" + res2);
        System.out.println("Ratio threads time: " + ((double)res1 / res2));
    }
    @Override
    public void run() {
    }
}
