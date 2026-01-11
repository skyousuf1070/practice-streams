package org.com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        /*
        You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
        You should return the array of nums such that the array follows the given conditions:
        Every consecutive pair of integers have opposite signs.
        For all integers with the same sign, the order in which they were present in nums is preserved.
        The rearranged array begins with a positive integer.
        Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
        Input: nums = [3,1,-2,-5,2,-4]
        Output: [3,-2,1,-5,2,-4]
        Explanation:
        The positive integers in nums are [3,1,2]. The negative integers are [-2,-5,-4].
        The only possible way to rearrange them such that they satisfy all conditions is [3,-2,1,-5,2,-4].
        Other ways such as [1,-2,2,-5,3,-4], [3,1,2,-2,-5,-4], [-2,3,-5,1,-4,2] are incorrect because they do not satisfy one or more conditions.
        */
        int[] nums = {3, 1, -2, -5, 2, -4};
        Map<Boolean, List<Integer>> map = Arrays.stream(nums).boxed()
                .collect(Collectors.partitioningBy(n -> n >= 0));
        List<Integer> positiveNums = map.get(true);
        List<Integer> negativeNums = map.get(false);
        int len = nums.length;
        int[] finalNums = IntStream.range(0, len)
                .map(i -> (i % 2 == 0) ? positiveNums.get(i / 2) : negativeNums.get(i / 2))
                .toArray();
        System.out.println(Arrays.toString(finalNums));
        System.out.println(positiveNums);
        System.out.println(negativeNums);

        // The Two-Pointer Approach
        int posIndex = 0;
        int negIndex = 1;
        int[] res = new int[len];
        for (Integer num : nums) {
            if (num >= 0) {
                res[posIndex] = num;
                posIndex += 2;
            } else {
                res[negIndex] = num;
                negIndex += 2;
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
