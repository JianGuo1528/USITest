package com.test.others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();

        list1.add(1);
        list1.add(10);
        list1.add(5);
        list1.add(6);
        list1.add(16);

        list2.add(3);
        list2.add(25);
        list2.add(10);

        List<Integer> newList = new LinkedList<>();

        int size1 = list1.size();
        int size2 = list2.size();

        int maxLen = size1 > size2 ? size1 : size2;
        for (int i = 0; i < maxLen; i++) {
            if (i < size1) {
                newList.add(list1.get(i));
            }
            if (i < size2) {
                newList.add(list2.get(i));
            }
        }
        System.out.println(newList);

        /*for (int i = newList.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (newList.get(j) > newList.get(j + 1)) {
                    Integer temp = newList.get(j);
                    newList.set(j, newList.get(j + 1));
                    newList.set(j + 1, temp);
                }
            }
        }*/

        quickSort(newList, 0, newList.size() - 1);
        System.out.println(newList);


    }

    public static void quickSort(List<Integer> list, int first, int last) {
        //8 24 3 7 19 22 15 6 4
        if (first >= last) {
            return;
        }

        int begin = first;
        int end = last;
        int pivotalIndex = first;
        int pivotalValue = list.get(pivotalIndex);
        while (begin < end) {
            while (begin < end && list.get(begin) <= pivotalValue) {
                begin ++;
            }
            while (begin < end && list.get(end) >= pivotalValue) {
                end --;
            }
            if (begin != end) {
                Integer temp = list.get(begin);
                list.set(begin, list.get(end));
                list.set(end, temp);
            }
        }
        if (list.get(begin) < pivotalValue) {
            Integer temp = list.get(begin);
            list.set(begin, list.get(pivotalIndex));
            list.set(pivotalIndex, temp);
        }
        quickSort(list, first, begin - 1);
        quickSort(list, begin, last);
    }
}
