package org.com.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MissingNumber {
    public static void main(String[] args) {
        // Given an array nums containing n distinct numbers in the range [0, n],
        // return the only number in the range that is missing from the array.
        // Input: nums = [3,0,1]
        //Output: 2
        //Explanation:
        //n = 3 since there are 3 numbers, so all numbers are in the range [0,3].
        // 2 is the missing number in the range since it does not appear in nums.

        int[] nums = {3, 0, 1};
        int missingNumber = IntStream.rangeClosed(0, nums.length).sum() -
                Arrays.stream(nums).sum();
        System.out.println(missingNumber);
    }
}
