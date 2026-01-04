package org.com;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTransformation {
    public static void main(String[] args) {
        // Convert a List of Strings to Uppercase
        List<String> words = List.of("cat", "dog", "apple", "bat", "eye");
        List<String> upperCasedWords = words.stream()
                .map(word -> word.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(upperCasedWords);

        // Convert a List of Integers to Their Squares
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> squaredNumbers = numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
        System.out.println(squaredNumbers);

        // Find the First Element in a List
        numbers.stream().findFirst().ifPresent(System.out::println);

        // Find the Last Element in a List
        Integer lastNumber = numbers.stream().reduce((a, b) -> b).orElse(0);
        System.out.println(lastNumber);

        // Check if All Elements in a List Satisfy a Condition
        boolean allMatches = numbers.stream().allMatch(number -> number == 3);
        System.out.println(allMatches);

        // Check if Any Element in a List Satisfies a Condition
        boolean anyMatches = numbers.stream().anyMatch(number -> number == 3);
        System.out.println(anyMatches);

        // Remove Duplicate Elements from a List
        numbers.add(5);
        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueNumbers);

        // Sort a List of Integers in Ascending Order
        numbers.addAll(List.of(1, 2, 3));
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedNumbers);

        // Sort a List of Integers in Descending Order
        List<Integer> descendingSortedNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(descendingSortedNumbers);

        // Sort a List of Strings in Alphabetical Order
        List<String> alphabeticalSortedWords = words.stream().sorted().collect(Collectors.toList());
        System.out.println(alphabeticalSortedWords);

        // Sort a List of Strings by Their Length
        List<String> sortedByLengthWords = words.stream()
                .sorted(Comparator.comparingInt(word -> word.length()))
                .collect(Collectors.toList());
        System.out.println(sortedByLengthWords);
    }
}
