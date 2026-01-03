package org.com;

import java.util.List;
import java.util.stream.Collectors;

public class ListManipulationExamplesWithStreams {
    public static void main(String[] args) {
        // Find the Sum of All Elements in a List
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream().mapToInt(number -> number).sum();
        System.out.println(sum);

        // Find the Product of All Elements in a List
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product);

        // Find the Average of All Elements in a List
        double average = numbers.stream().mapToInt(number -> number).average().orElse(0);
        System.out.println(average);

        // Find the Maximum Element in a List
        int max = numbers.stream().mapToInt(number -> number).max().orElse(0);
        System.out.println(max);

        // Find the Minimum Element in a List
        int min = numbers.stream().mapToInt(number -> number).min().orElse(0);
        System.out.println(min);

        // Count the Number of Elements in a List
        long count = numbers.stream().count();
        System.out.println(count);

        // Check if a List Contains a Specific Element
        boolean contains = numbers.stream().anyMatch(number -> number == 3);
        System.out.println(contains);

        // Filter Out Even Numbers from a List
        List<Integer> evenNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

        // Filter Out Odd Numbers from a List
        List<Integer> oddNumbers = numbers.stream()
                .filter(number -> number % 2 != 0)
                .collect(Collectors.toList());
        System.out.println(oddNumbers);
    }
}
