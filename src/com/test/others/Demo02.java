package com.test.others;

import java.util.ArrayList;
import java.util.List;

public class Demo02 {
    public static void main(String[] args) {
        /*
        1
        11
        21
        1211
        111221
        312211
        13112221
        1113213211
        31131211131221
        */
        showResult(60);
    }

    public static void showResult(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);

        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            Integer previous = list.get(0);
            for (Integer integer : list) {
                if (integer != previous) {
                    newList.add(count);
                    count = 1;
                    newList.add(previous);
                    previous = integer;
                } else {
                    count ++;
                }
            }
            newList.add(count);
            newList.add(previous);

            list.clear();
            list = newList;
            newList = new ArrayList<>();
        }
        System.out.println(list);
    }
}
