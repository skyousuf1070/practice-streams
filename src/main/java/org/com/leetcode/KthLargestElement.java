package org.com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class KthLargestElement {
    public static void main(String[] args) {
        // Given an integer array nums and an integer k, return the kth largest element in the array.
        //Note that it is the kth largest element in the sorted order, not the kth distinct element

        int[] numbers = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int kthLargestElement = Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(k - 1)
                .findFirst().orElse(0);
        System.out.println(kthLargestElement);
    }
}
