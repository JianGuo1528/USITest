package com.test.others;

import javax.xml.soap.Node;

public class Demo03 {
    public static void main(String[] args) throws InterruptedException {
        String str = "test";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test("1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        test("main");
    }

    public static synchronized void test(String name) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Thread.sleep(100);
            System.out.println("Thread " + name + ": " + i);
        }
    }
}
