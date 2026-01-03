package org.com;

import java.util.List;
import java.util.stream.Collectors;

public class StreamTransformation {
    public static void main(String[] args) {
        // Convert a List of Strings to Uppercase
        List<String> words = List.of("apple", "bat", "cat", "dog", "eye");
        List<String> upperCasedWords = words.stream()
                .map(word -> word.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(upperCasedWords);

        // Convert a List of Integers to Their Squares
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> squaredNumbers = numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
        System.out.println(squaredNumbers);

        // Find the First Element in a List
        numbers.stream().findFirst().ifPresent(System.out::println);

        // Find the Last Element in a List
        Integer lastNumber = numbers.stream().reduce((a, b) -> b).orElse(0);
        System.out.println(lastNumber);
    }
}
