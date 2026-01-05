package org.com;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdvancedLevelExercises {
    public static void main(String[] args) {
        // Find the Most Frequent Element in a List
        List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        String mostFrequentWord = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .reduce((entry1, entry2) -> entry1.getValue() >= entry2.getValue() ? entry1 : entry2)
                .get().getKey();
        System.out.println(mostFrequentWord);

        // Find the Least Frequent Element in a List
        String leastFrequentWord = words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .reduce((entry1, entry2) -> entry1.getValue() <= entry2.getValue() ? entry1 : entry2)
                .get().getKey();
        System.out.println(leastFrequentWord);

        // Find the First Non-Repeated Character in a String
        String input = "hello";
        char firstNonRepeatingCharacter = input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst().orElse(' ');
        System.out.println(firstNonRepeatingCharacter);

        // Find the First Repeated Character in a String
        char firstRepeatedCharacter = input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() != 1)
                .map(entry -> entry.getKey())
                .findFirst().orElse(' ');
        System.out.println(firstRepeatedCharacter);

        // Check if a String is a Palindrome
        int n = input.length();
        String str = "madam";
        boolean isPalindrome = IntStream.range(0, n / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(n - 1 - i));
        System.out.println(isPalindrome);

        String s = "A man, a plan, a canal: Panama";
        String originalString = s.chars()
                .mapToObj(ch -> (char) ch)
                .map(ch -> Character.toLowerCase(ch))
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .map(ch -> String.valueOf(ch))
                .reduce("", (a, b) -> a + b);
        String reversedString = s.chars()
                .mapToObj(ch -> (char) ch)
                .map(ch -> Character.toLowerCase(ch))
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .map(ch -> String.valueOf(ch))
                .reduce("", (a, b) -> b + a);
        System.out.println(originalString.equals(reversedString));

        // Find All Anagrams of a String from a List
        List<String> anagramWords = List.of("listen", "silent", "enlist", "google", "inlets");
        String target = "silent";
        String targetString = target.chars()
                .sorted()
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
        List<String> targetMatchedAnagrams = anagramWords.stream()
                .filter(word -> {
                    String sortedWord = word.chars()
                            .sorted()
                            .mapToObj(ch -> String.valueOf((char) ch))
                            .collect(Collectors.joining());
                    return sortedWord.equals(targetString);
                })
                .collect(Collectors.toList());
        System.out.println(targetMatchedAnagrams);

        // Flatten a List of Lists into a Single List
        List<List<Integer>> listOfLists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );
        List<Integer> flatList = listOfLists.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        System.out.println(flatList);

        // Find the Sum of All Even Numbers in a Nested List
        Integer sum = listOfLists.stream()
                .flatMap(list -> list.stream())
                .filter(ele -> ele % 2 == 0)
                .reduce((a, b) -> a + b).orElse(0);
        System.out.println(sum);

        sum = listOfLists.stream()
                .flatMap(list -> list.stream())
                .filter(ele -> ele % 2 == 0)
                .mapToInt(ele -> ele)
                .sum();
        System.out.println(sum);

        // Find the Longest Palindrome in a List of Strings
        words = List.of("madam", "racecar", "apple", "banana", "level");
        String longestPalindrome = words.stream()
                .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                .max((word1, word2) -> Integer.compare(word1.length(), word2.length()))
                .orElse("No Palindrome");
        System.out.println(longestPalindrome);

        // Find the Shortest Palindrome in a List of Strings
        String shortestPalindrome = words.stream()
                .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                .min((word1, word2) -> Integer.compare(word1.length(), word2.length()))
                .orElse("No Palindrome");
        System.out.println(shortestPalindrome);

        // Find the Longest Word in a String
        input = "hello world this is a test";
        String longestWord = Arrays.stream(input.split(" "))
                .collect(Collectors.toMap(word -> word, word -> word.length()))
                .entrySet()
                .stream()
                .max((word1, word2) -> Integer.compare(word1.getValue(), word2.getValue()))
                .map(entry -> entry.getKey())
                .stream()
                .findFirst()
                .orElse("None");
        System.out.println(longestWord);

        longestWord = Arrays.stream(input.split(" "))
                .max((word1, word2) -> Integer.compare(word1.length(), word2.length()))
                .stream().findFirst()
                .orElse("None");
        System.out.println(longestWord);

        // Find the Shortest Word in a String
        String shortestWord = Arrays.stream(input.split(" "))
                .min((word1, word2) -> Integer.compare(word1.length(), word2.length()))
                .stream()
                .findFirst()
                .orElse("None");
        System.out.println(shortestWord);

        // Find the Number of Words in a String
        System.out.println(Arrays.stream(input.split(" ")).count());
    }
}
