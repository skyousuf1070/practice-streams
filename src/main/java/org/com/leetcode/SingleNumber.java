package org.com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SingleNumber {
    public static void main(String[] args) {
        // Given a non-empty array of integers nums, every element appears twice except for one.
        // Find that single one
        // Input: nums = [4,1,2,1,2]
        //Output: 4

        int[] nums = {4, 1, 2, 1, 2};
        Integer singleNumber = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num))
                .entrySet()
                .stream()
                .filter(key -> key.getValue().size() == 1)
                .findFirst().get().getKey();
        System.out.println(singleNumber);
    }
}
