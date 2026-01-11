package org.com.leetcode;

public class SubArraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
            for (int j = i+1; j < nums.length; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }
    }
}
