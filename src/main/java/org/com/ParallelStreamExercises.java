package org.com;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamExercises {
    public static void main(String[] args) {
        // Process a Large List of Numbers in Parallel
        List<Integer> numbers = IntStream.range(1, 1000000).boxed().collect(Collectors.toList());
        int sum = numbers.parallelStream()
                .mapToInt(number -> number)
                .sum();
        System.out.println(sum);

        // Find the Sum of All Elements in a List Using Parallel Streams
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 4, 3, 2);
        sum = nums.parallelStream()
                .mapToInt(num -> num)
                .sum();
        System.out.println(sum);

        // Find the Maximum Element in a List Using Parallel Streams
        Integer max = nums.parallelStream()
                .max((a, b) -> Integer.compare(a, b))
                .orElse(0);
        System.out.println(max);

        // Find the Minimum Element in a List Using Parallel Streams
        Integer min = nums.parallelStream()
                .min((a, b) -> a.compareTo(b))
                .orElse(0);
        System.out.println(min);

        // Sort a List of Integers in Parallel Using Parallel Streams
        List<Integer> sortedNumbers = nums.parallelStream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers);
    }
}
