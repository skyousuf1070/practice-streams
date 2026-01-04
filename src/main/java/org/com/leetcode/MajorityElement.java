package org.com.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElement {
    public static void main(String[] args) {
        /*
        Given an array nums of size n, return the majority element.
        The majority element is the element that appears more than ⌊n / 2⌋ times.
        You may assume that the majority element always exists in the array.
        Input: nums = [2,2,1,1,1,2,2]
        Output: 2
         */

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int majorityNumber = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
                .entrySet()
                .stream()
                .reduce((a, b) -> a.getValue() >= b.getValue() ? a : b)
                .stream().findFirst().get().getKey();
        System.out.println(majorityNumber);
    }
}
