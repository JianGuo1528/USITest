package com.test.algo;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

public class Demo {
    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * Example
     * Input: (2 -> 4 -> 5) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * Explanation: 342 + 465 = 807.
     */
    @Test
    public void test01() {
        int a = 999;
        int b = 999;

        List<Integer> listA = new LinkedList<>();
        List<Integer> listB = new LinkedList<>();
        List<Integer> listResult = new LinkedList<>();

        String strA = String.valueOf(a);
        String strB = String.valueOf(b);

        int lengthA = strA.length();
        int lengthB = strB.length();

        int maxLength = lengthA > lengthB ? lengthA : lengthB;

        for (int i = 0; i < maxLength; i++) {
            int tempA = i < lengthA ? (int) strA.charAt(i) - 48 : 0;
            ((LinkedList<Integer>) listA).push(tempA);
            int tempB = i < lengthB ? (int) strB.charAt(i) - 48 : 0;
            ((LinkedList<Integer>) listB).push(tempB);
        }

        for (int i = 0; i < maxLength; i++) {
            listResult.add(0);
        }

        for (int i = 0; i < maxLength; i++) {
            int tempA = listA.get(i);
            int tempB = listB.get(i);
            int current = (tempA + tempB) % 10;
            int next = (tempA + tempB) / 10;

            listResult.set(i, current + listResult.get(i));
            if (i != maxLength - 1) {
                listResult.set(i + 1, next);
            } else if (next != 0) {
                listResult.add(next);
            }
        }

        System.out.println(listA);
        System.out.println(listB);

        Collections.reverse(listResult);
        System.out.println(listResult);
    }

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * Examples:
     * Given "abcabcbb", the answer is "abc", which the length is 3.
     * Given "bbbbb", the answer is "b", with the length of 1.
     * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */
    @Test
    public void test02() {
        String str = "vkuirofcemulntsxfismaujeibsvesvccpkufpykdv";
        char[] chars = str.toCharArray();
        int length = chars.length;
        int max = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            int current = 0;
            for (int j = i; j < length; j++) {
                if (set.contains(chars[j])) {
                    break;
                } else {
                    set.add(chars[j]);
                }
                current = set.size();
            }
            max = current > max ? current : max;
            if (length - i <= max) {
                break;
            }
            set.clear();
        }
        System.out.println(max);

    }

    @Test
    public void test03() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return ans;
    }

    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * Example 1:
     * Input: "baabad"
     * Output: "baab"
     * Note: "aba" is also a valid answer.
     */
    @Test
    public void test04() {
        String s = "mwwfjysbkebpdjyabcfkgprtxpwvhglddhmvaprcvrnuxifcrjpdgnktvmggmguiiquibmtviwjsqwtchkqgxqwljouunurcdtoeygdqmijdympcamawnlzsxucbpqtuwkjfqnzvvvigifyvymfhtppqamlgjozvebygkxawcbwtouaankxsjrteeijpuzbsfsjwxejtfrancoekxgfyangvzjkdskhssdjvkvdskjtiybqgsmpxmghvvicmjxqtxdowkjhmlnfcpbtwvtmjhnzntxyfxyinmqzivxkwigkondghzmbioelmepgfttczskvqfejfiibxjcuyevvpawybcvvxtxycrfbcnpvkzryrqujqaqhoagdmofgdcbhvlwgwmsmhomknbanvntspvvhvccedzzngdywuccxrnzbtchisdwsrfdqpcwknwqvalczznilujdrlevncdsyuhnpmheukottewtkuzhookcsvctsqwwdvfjxifpfsqxpmpwospndozcdbfhselfdltmpujlnhfzjcgnbgprvopxklmlgrlbldzpnkhvhkybpgtzipzotrgzkdrqntnuaqyaplcybqyvidwcfcuxinchretgvfaepmgilbrtxgqoddzyjmmupkjqcypdpfhpkhitfegickfszermqhkwmffdizeoprmnlzbjcwfnqyvmhtdekmfhqwaftlyydirjnojbrieutjhymfpflsfemkqsoewbojwluqdckmzixwxufrdpqnwvwpbavosnvjqxqbosctttxvsbmqpnolfmapywtpfaotzmyjwnd"; //baabad
        //dabaab
        int n = s.length();
        String reverse = new StringBuilder(s).reverse().toString();
        int i = 0;
        int j = 0;
        int left = 0;
        int right = 0;


        for (i = 0; i < n; i++) {
            for (j = i; j <= n; j++) {
                if (i != j && s.substring(i, j).equals(reverse.substring(n - j, n - i)) && j - i > right - left) {
                    left = i;
                    right = j;
                }
            }
        }

        System.out.println(s.substring(left, right));
    }


    /**
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this
     * Input: s = "PAYPALISHIRING", numRows = 4
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     * P    I    N
     * A  L S  I G
     * Y A  H R
     * P    I
     */
    @Test
    public void test05() {
        String s = "AB";
        int numRows = 1;
        int length = s.length();
        if (s == null || s.trim().isEmpty() || length <= numRows || numRows == 1) {
            System.out.println(s);
            return;
        }
        int tempIndex = 0;
        int accumulation = 0;

        List<StringBuilder> list = new ArrayList<>();
//        List<Integer> indexList = new ArrayList<>();
//        List<String> directionList = new ArrayList<>();
        int[] indexList = new int[numRows];
        String[] directionList = new String[numRows];

        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
            if (i < length) {
                list.get(i).append(s.charAt(i));
            }
            indexList[i] = i;
            directionList[i] = "d";
        }

        for (int i = 0; ; i++) {
            if (accumulation == numRows) {
                break;
            }
            if (i == numRows) {
                i = 0;
                accumulation = 0;
            }

            if (i == 0) {
                tempIndex = (numRows - 1 - i) * 2 + indexList[i];
            } else if (i == numRows - 1) {
                tempIndex = i * 2 + indexList[i];
            } else {
                if (directionList[i].equals("d")) {
                    tempIndex = (numRows - 1 - i) * 2 + indexList[i];
                    directionList[i] = "u";
                } else {
                    tempIndex = i * 2 + indexList[i];
                    directionList[i] = "d";
                }
            }

            if (tempIndex < length) {
                list.get(i).append(s.charAt(tempIndex));
            } else {
                accumulation += 1;
            }
            indexList[i] = tempIndex;
        }


        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : list) {
            result.append(sb);
        }

        System.out.println(result);
    }

    /**
     * Implement atoi which converts a string to an integer.
     * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
     * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
     * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
     * If the first sequence of non-whitespace characters in str is not a valid integral number,
     * or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
     * If no valid conversion could be performed, a zero value is returned.
     * Note:
     * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
     * If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
     * <p>
     * Example 1:
     * Input: "42"
     * Output: 42
     */
    @Test
    public void test06() {
        String str = "+-2";
        if (str == null || str.trim().isEmpty()) {
            return;
        }
        int length = str.length();
        boolean firstDigit = false;
        int start = -1;
        int i = 0;
        for (i = 0; i < length; i++) {
            if (i - start > 11) {
                break;
            }
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                start = start == -1 ? i : start;
            } else {
                if (start == -1) {
                    if (c == 45 || c == 43) {
                        start = i;
                    } else if (!Character.isSpaceChar(c)) {
                        return;
                    }
                } else {
                    break;
                }
            }
        }

        String substring = str.substring(start, i);
        if (substring.equals("-") || substring.equals("+")) {
            return;
        }
        long result = Long.parseLong(substring);
        System.out.println(result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result < Integer.MIN_VALUE ? Integer.MIN_VALUE : result);
    }

    /**
     * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
     * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
     * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     * Note: You may not slant the container and n is at least 2.
     */
    @Test
    public void test07() {
        // 1, 1
        //(0, 1) (1, 1)
        System.out.println(maxArea(new int[]{1, 2, 1}));
    }

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return max;

    }

    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together.
     * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for four is not IIII. Instead, the number four is written as IV.
     * Because the one is before the five we subtract it making four.
     * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
     *
     * Example 1:
     * Input: 3
     * Output: "III"
     * Input: 58
     * Output: "LVIII"
     * Explanation: C = 100, L = 50, XXX = 30 and III = 3.
     * Input: 1994
     * Output: "MCMXCIV"
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */
    @Test
    public void test08() {
        int input = 213;
        if (input < 1 || input > 3999) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int[] values = new int[]{1, 5, 10, 50, 100, 500, 1000};
        String symbol = "IVXLCDM";
    }
}
