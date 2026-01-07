package org.com.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static void main(String[] args) {
        /*
        Given an integer array nums, return true if any value appears at least twice in the array,
        and return false if every element is distinct.

        Input: nums = [1,2,3,1]
        Output: true
        Explanation: The element 1 occurs at the indices 0 and 3.
        */
        int[] nums = {7, 10, 5, 5, 6, 6, 4, 10, 5, 4, 9, 4, 9, 6, 5, 9, 6, 3, 6, 5, 6, 7, 7, 4, 9, 9, 10, 5,
                8, 1, 8, 3, 2, 7, 5, 10, 1, 8, 5, 8, 4, 3, 6, 4, 9, 4, 2, 8, 3, 2, 2, 1, 5, 6, 3, 2, 6, 1,
                8, 6, 2, 9, 1, 4, 5, 10, 8, 5, 10, 5, 10, 1, 4, 8, 3, 6, 4, 10, 9, 1, 1, 1, 2, 2, 9, 6, 6,
                8, 1, 9, 2, 5, 5, 2, 1, 8, 5, 2, 3, 10};
        Map<Integer, Long> numbersFrequency = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        System.out.println(numbersFrequency);
        System.out.println(numbersFrequency
                .entrySet()
                .stream()
                .anyMatch(entry -> entry.getValue() >= 2));
    }
}
