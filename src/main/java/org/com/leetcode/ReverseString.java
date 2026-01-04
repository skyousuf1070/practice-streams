package org.com.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseString {
    public static void main(String[] args) {
        /*
        Write a function that reverses a string. The input string is given as an array of characters s.
        You must do this by modifying the input array in-place with O(1) extra memory.
        Input: s = ["h","e","l","l","o"]
        Output: ["o","l","l","e","h"]
        */
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        int n = s.length;
        IntStream.range(0, n / 2).forEach(i -> {
            char temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        });
        System.out.println(Arrays.toString(s));
    }
}
