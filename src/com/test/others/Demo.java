package com.test.others;

import java.util.*;

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

        Integer[] integers = newList.toArray(new Integer[]{});
        quickSort2(integers, 0, newList.size() - 1);
        System.out.println(Arrays.toString(integers));


    }

    public static void quickSort(List<Integer> list, int first, int last) {
        //8 24 3 7 19 22 15 6 4
        if (first >= last) {
            return;
        }

        int begin = first;
        int end = last;
        int pivotalValue = list.get(first);
        while (begin < end) {
            while (begin < end && list.get(begin) <= pivotalValue) {
                begin++;
            }
            if (begin < end) list.set(end--, list.get(begin));
            while (begin < end && list.get(end) >= pivotalValue) {
                end--;
            }
            if (begin < end) list.set(begin++, list.get(end));
        }
        list.set(begin, pivotalValue);
        quickSort(list, first, begin - 1);
        quickSort(list, begin, last);
    }

    public static void quickSort2(Integer s[], int left, int right) {
        LinkedHashMap<Integer, Integer> lhp = new LinkedHashMap<>();
        //将0,n放入LinkedHashMap
        lhp.put(left, right);
        while (!lhp.isEmpty()) {      //只要有需要排序的段
            //读取left，right
            Iterator<Map.Entry<Integer, Integer>> it = lhp.entrySet().iterator();
            left = it.next().getKey();
            right = lhp.get(left);
            //并从LinkedHashMap中删除
            lhp.remove(left, right);
            if (left >= right) continue;
            int i = left, j = right, temp = s[right];
            while (i < j) {         //遍历排序一遍
                while (s[i] <= temp && i < j) i++;
                if (i < j) s[j--] = s[i];
                while (s[j] >= temp && i < j) j--;
                if (i < j) s[i++] = s[j];
            }
            s[i] = temp;
            lhp.put(left, i - 1);
            lhp.put(i + 1, right);
        }
    }
}
