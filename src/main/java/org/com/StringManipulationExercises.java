package org.com;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StringManipulationExercises {
    public static void main(String[] args) {
        // Remove All Vowels from a String
        String input = "hello world";
        String vowelRemovedInput = input.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .filter(ch -> !"aeiou".contains(ch))
                .collect(Collectors.joining());
        System.out.println(vowelRemovedInput);

        // Remove All Consonants from a String
        String consonantRemovedInput = input.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .filter(ch -> "aeiou".contains(ch))
                .collect(Collectors.joining());
        System.out.println(consonantRemovedInput);

        // Remove All Digits from a String
        input = "hello 123 world";
        String digitRemovedInput = input.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .filter(ch -> !"0123456789".contains(ch))
                .collect(Collectors.joining());
        System.out.println(digitRemovedInput);

        // Remove All Special Characters from a String
        input = "hello@world!";
        String specialCharactersRemovedInput = input.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9'))
                .map(ch -> String.valueOf(ch))
                .collect(Collectors.joining());
        System.out.println(specialCharactersRemovedInput);

        // Extract All Digits from a String and Sum Them
        input = "hello 123 world";
        int sum = input.chars()
                .filter(ch -> ch >= '0' & ch <= '9')
                .map(ch -> Character.getNumericValue(ch))
                .sum();
        System.out.println(sum);

        // Extract All Digits from a String and Count Their Occurrences
        input = "hello 123 world 246";
        List<Integer> numbers = input.chars()
                .filter(ch -> ch >= '0' && ch <= '9')
                .mapToObj(ch -> Character.getNumericValue(ch))
                .collect(Collectors.toList());
        Map<Integer, Long> numberOccurrences = numbers.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        System.out.println(numberOccurrences);

        // Extract All Words from a String and Count Their Occurrences
        Map<String, Long> wordOccurrences = Arrays.stream(input.split(" "))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(wordOccurrences);

        // Extract All Unique Words from a String
        input = "hello 123 world 246 hello 123";
        Set<String> uniqueWords = Arrays.stream(input.split(" "))
                .collect(Collectors.toSet());
        System.out.println(uniqueWords);

        List<String> uniqueWordsList = Arrays.stream(input.split(" "))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueWordsList);

        // Extract All Palindromic Words from a String
        input = "madam racecar apple banana level";
        List<String> palindromeWords = Arrays.stream(input.split(" "))
                .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                .collect(Collectors.toList());
        System.out.println(palindromeWords);

        // Extract All Words Starting with a Specific Letter
        input = "anda madam racecara apple banana level ant";
        List<String> wordsStartingWithA = Arrays.stream(input.split(" "))
                .filter(word -> word.startsWith("a"))
                .collect(Collectors.toList());
        System.out.println(wordsStartingWithA);

        // Extract All Words Ending with a Specific Letter
        List<String> wordEndsWithA = Arrays.stream(input.split(" "))
                .filter(word -> word.endsWith("a"))
                .collect(Collectors.toList());
        System.out.println(wordEndsWithA);
    }
}
