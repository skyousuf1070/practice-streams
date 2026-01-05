package org.com.leetcode;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        /*
        Given a string s, find the first non-repeating character in it and return its index.
        If it does not exist, return -1
        Input: s = "leetcode"
        Output: 0
        */

        String s = "leetcode";
        char firstNonRepeatingCharacter = s.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst().orElse(' ');
        System.out.println(s.indexOf(firstNonRepeatingCharacter));
    }
}
