package org.com.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        /*
        Given an integer array nums,
        return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
        Example 1:
        Input: nums = [1,2,3,4]
        Output: [24,12,8,6]

        Example 2:
        Input: nums = [-1,1,0,-3,3]
        Output: [0,0,9,0,0]
        */
        int[] nums = {1, 2, 3, 4};
        int len = nums.length;
        int[] productOfNumsExceptSelf = IntStream.range(0, len)
                .map(i -> {
                    return IntStream.range(0, len)
                            .filter(j -> j != i)
                            .map(j -> nums[j])
                            .reduce(1, (a, b) -> a * b);
                })
                .toArray();
        System.out.println(Arrays.toString(productOfNumsExceptSelf));

        // non stream way with TC O(n) & SC O(1)
        int[] finalNums = new int[len];
        int right = 1;
        finalNums[0] = 1;
        for(int i=1; i<len; i++) {
            finalNums[i] = finalNums[i-1]*nums[i-1];
        }
        for(int i=len-1; i>=0; i--) {
            finalNums[i] = right*finalNums[i];
            right = right*nums[i];
        }
        System.out.println(Arrays.toString(finalNums));
    }
}
