package org.com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        // Given two integer arrays nums1 and nums2, return an array of their intersection.
        // Each element in the result must appear as many times as it shows in both arrays
        // and you may return the result in any order.
        //Input: nums1 = [1,2,2,1], nums2 = [2,2]
        //Output: [2,2]

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        Map<Integer, Long> nums2Map = Arrays.stream(nums2)
                .boxed()
                .collect(Collectors.groupingBy(num -> num,
                        Collectors.counting()));
        List<Integer> intersectedList = Arrays.stream(nums1).boxed()
                .filter(num -> {
                    if (nums2Map.getOrDefault(num, 0L) > 0) {
                        nums2Map.put(num, nums2Map.get(num) - 1);
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());
        int[] intersectedArray = intersectedList.stream().distinct().mapToInt(num -> num).toArray();
        System.out.println(intersectedList);
        System.out.println(Arrays.toString(intersectedArray));
    }
}
