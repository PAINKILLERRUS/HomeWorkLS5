package ru.geekbrains.homework;

import java.util.Arrays;

public class Threads {

    public  void firstMethod(float[]a, int shift) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (float) (a[i] * Math.sin(0.2f + (i + shift) / 5)
                    * Math.cos(0.2f + (i + shift)/ 5) * Math.cos(0.4f + (i + shift)/ 2));
        }
    }

    public  void secondMethod(float[]a, int thCOUNT) throws InterruptedException {
        int partSize = a.length/ thCOUNT;
        float[][]parts = new float[thCOUNT][partSize];
        Thread[] thread1 = new Thread[thCOUNT];
        for (int i = 0, s = 0; i < a.length; i += partSize, s++) {
            parts[s] = Arrays.copyOfRange(a,i,Math.min(i + partSize, a.length));
            int j = s;
            int SHF = i;
            thread1[j] = new Thread(() -> firstMethod(parts[j], SHF));
            thread1[j].start();
        }
        for (int i = 0; i < thCOUNT; i++) {
            thread1[i].join();
        }

        for (int i = 0, s = 0; i < a.length; i+= partSize, s++) {
            System.arraycopy(parts[s],0,a,i,parts[s].length);
        }
    }
}
