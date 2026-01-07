package org.com.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String[] args) {
        /*
        Given an integer array nums and an integer k, return the k most frequent elements.
        You may return the answer in any order.
        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]
        */
        int[] nums = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        int k = 2;

        Map<Integer, Long> numbersFrequency = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        int[] topKFrequentElements = numbersFrequency
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(k)
                .mapToInt(entry -> entry.getKey())
                .toArray();
        System.out.println(numbersFrequency);
        System.out.println(Arrays.toString(topKFrequentElements));
    }
}
