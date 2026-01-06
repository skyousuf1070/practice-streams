package org.com;

import java.util.List;
import java.util.stream.IntStream;

public class MathematicalExercises {
    public static void main(String[] args) {
        // Find the Sum of Squares of All Elements in a List
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .mapToInt(n -> n * n)
                .sum();
        System.out.println(sum);

        // Find the Sum of Cubes of All Elements in a List
        sum = numbers.stream()
                .mapToInt(n -> n * n * n)
                .sum();
        System.out.println(sum);

        // Find the Sum of All Prime Numbers in a List
        sum = numbers.stream()
                .filter(n -> n > 1 && IntStream.rangeClosed(2, n / 2).noneMatch(i -> n % i == 0))
                .mapToInt(n -> n)
                .sum();
        System.out.println(sum);

        // Find the Sum of All Even-Indexed Elements in a List
        sum = IntStream.range(0, numbers.size())
                .filter(i -> i % 2 == 0)
                .map(i -> numbers.get(i))
                .sum();
        System.out.println(sum);

        // Find the Sum of All Odd-Indexed Elements in a List
        sum = IntStream.range(0, numbers.size())
                .filter(i -> i % 2 != 0)
                .map(i -> numbers.get(i))
                .sum();
        System.out.println(sum);

        // Find the Sum of All Elements Greater Than a Specific Value
        sum = numbers.stream()
                .filter(number -> number > 3)
                .mapToInt(number -> number)
                .sum();
        System.out.println(sum);
    }
}
