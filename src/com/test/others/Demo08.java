package com.test.others;

public class Demo08 {
    public static void main(String[] args) {
        int n = 10;

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + n);
                }
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + n);
        }
    }
}
