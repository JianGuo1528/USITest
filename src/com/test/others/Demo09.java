package com.test.others;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;

public class Demo09 {
    public boolean f;

    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner("--");
        sj.add("a").add("b").add("c");
        System.out.println(sj);
//        System.out.println(test());

        int a = 16;
        int b = 24;
        System.out.println(lcm(a, b));
        System.out.println(gcd(a, b));
    }

    public static int test() {
        try {
            System.out.println("Demo09.main--try");
            String s = String.valueOf(new Demo());
            System.out.println(1/0);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            return 1;
        } finally {
            System.out.println("Demo09.main--finally");
        }
        return 123456;
    }

    public static int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return (a / gcd) * (b / gcd) * gcd;
    }

    public static int gcd(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        if (max % min == 0) {
            return min;
        }else {
            return gcd(min, max % min);
        }
    }
}
