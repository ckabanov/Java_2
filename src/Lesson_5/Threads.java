package Lesson_5;

import java.util.Arrays;

public class Threads {
    static final int size = 1000000;
    static float[] arr = new float[size];
    static final int h = size / 2;

    public static void main(String[] args) {
        version1();
        version2();
    }

    private static void version1() {
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        completion(arr);
        System.out.println("Время подсчета в одном потоке равняется: " + (System.currentTimeMillis() - a));
    }

    private static void version2() {
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();
        float[] newArray1 = new float[h];
        float[] newArray2 = new float[h];
        System.arraycopy(arr, 0, newArray1, 0, h);
        System.arraycopy(arr, h, newArray2, 0, h);
        Thread thread1 = new Thread(() -> completion(newArray1));
        Thread thread2 = new Thread(() -> completion(newArray2));
        thread1.start();
        thread2.start();
        System.arraycopy(newArray1, 0, arr, 0, h);
        System.arraycopy(newArray2, 0, arr, h, h);
        System.out.println("Время подсчета в двух потоках равняется: " + (System.currentTimeMillis() - a));

    }

    private static void completion(float[] newArrays) {
        for (int i = 0; i < newArrays.length; i++) {
            newArrays[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }


}