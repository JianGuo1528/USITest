package com.test.algo.array;

import com.test.algo.Demo;
import org.junit.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test() {
//        int[] nums = {3, 2, 2, 3};
//        int val = 3;
//        System.out.println(removeElement(nums, val));

//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        System.out.println(removeDuplicates(nums));
//        System.out.println(Arrays.toString(nums));

//        int[] nums = {1, 2, 2, 2};
//        System.out.println(removeDuplicates2(nums));
//        System.out.println(Arrays.toString(nums));

//        int[] nums = {1, 2, 3};
//        rotate(nums, 4);
//        System.out.println(Arrays.toString(nums));

        int[] nums = {8,2,9,11,12};
        System.out.println(firstMissingPositive(nums));
        System.out.println(Arrays.toString(nums));
    }

    //27
    private int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;

        for (int num : nums) {
            if (val != num) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }

    //26
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }
        int i = 1;
        int previous = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != previous) {
                nums[i] = nums[j];
                previous = nums[j];
                i++;
            }
        }

        return i;
    }

    //80
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        } else if (nums.length == 2) {
            return 2;
        }
        int i = 1;
        int times = 0;
        int previous = nums[0];

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != previous) {
                nums[i] = nums[j];
                previous = nums[j];
                i++;
                times = 0;
            } else if (nums[j] == previous && times++ < 1) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

    //277
    public void findTheCelebrity() {
        new Demo().test12();
    }

    //189
    //1,2,3,4,5,6,7 and k = 3 => 5,6,7,1,2,3,4
    //7,6,5,4,3,2,1
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0 ) {
            return;
        }
        int length = nums.length;
        int j = length - 1;
        int i = 0;
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }

        k = k % length;

        i = 0;
        j = k - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }

        i = k;
        j = length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }

    //41
    //1, 8, 2, 11
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0)
            return 1;
        // The i-th position stores the value of i+1
        for(int i = 0; i < nums.length;i++){
            if(nums[i] > 0){//nums[i] is a positive number placed in the i+1 position
                // Assume that the exchanged data is still greater than 0 and <i+1, put in the appropriate position, and the data is not equal, avoiding infinite loops
                //This while is the key, the others are not difficult
                while(nums[i] > 0 && nums[i] < i+1 && nums[i] != nums[nums[i] -1]){
                    int temp = nums[nums[i]-1];//exchange data
                    nums[nums[i]-1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        // Loop to find data that does not meet the requirements, return
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        // If the assumptions are met, return a value of length +1
        return nums.length + 1;
    }
}
