package org.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        // Input: List<String> words = Arrays.asList("rat", "tar", "bat", "ate", "eat", "tea");
        // Output: [[rat, tar], [bat], [ate, eat, tea]]

        List<String> words = Arrays.asList("rat", "tar", "bat", "ate", "eat", "tea");

        // with streams
        Map<String, List<String>> anagramsWithStreams = words
                .stream()
                .collect(Collectors.groupingBy(word -> {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }));
        System.out.println(anagramsWithStreams.values());

        // non stream way
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!anagrams.containsKey(sortedWord)) {
                List<String> anagram = new ArrayList<>();
                anagrams.put(sortedWord, anagram);
            }
            anagrams.get(sortedWord).add(word);
        }
        System.out.println(anagrams.values());
    }
}