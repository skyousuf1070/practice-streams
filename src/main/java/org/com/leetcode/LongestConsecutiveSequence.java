package org.com.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        /*
        Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
        You must write an algorithm that runs in O(n) time

        Input: nums = [100,4,200,1,3,2]
        Output: 4
        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

        Input: nums = [0,3,7,2,5,8,4,6,0,1]
        Output: 9

        Input: nums = [1,0,1,2]
        Output: 3
        */
        int[] nums = {100, 4, 200, 1, 3, 2};
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int sequenceCount = set.stream()
                .filter(num -> !set.contains(num - 1))
                .mapToInt(num -> {
                    int count = 0;
                    int ele = num;
                    while (set.contains(ele)) {
                        ele++;
                        count++;
                    }
                    return count;
                })
                .max().orElse(0);
        System.out.println(sequenceCount);
    }
}
