package org.com.leetcode;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountSpecialIntegers {
    public int countSpecialNumbers(int n) {
        return (int) IntStream.rangeClosed(1, n)
                .filter(num -> isSpecial(num))
                .count();
    }

    public boolean isSpecial(int num) {
        String strNum = String.valueOf(num);
        Map<Character, Long> map = strNum.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        return map.entrySet()
                .parallelStream()
                .allMatch(entry -> entry.getValue() == 1);
    }

    public static void main(String[] args) {
        /*
        We call a positive integer special if all of its digits are distinct.
        Given a positive integer n, return the number of special integers that belong to the interval [1, n]
        Input: n = 20
        Output: 19
        Explanation: All the integers from 1 to 20, except 11, are special. Thus, there are 19 special integers
        */

        System.out.println(new CountSpecialIntegers().countSpecialNumbers(20));
    }
}
