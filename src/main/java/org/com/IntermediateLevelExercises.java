package org.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateLevelExercises {
    public static void main(String[] args) {
        // Find the Sum of Digits of a Number
        int number = 12345;
        int digitSum = String.valueOf(number).chars()
                .map(ch -> Character.getNumericValue(ch))
                .reduce(0, (a, b) -> a + b);
        System.out.println(digitSum);

        // Find the Factorial of a Number. Ex: 5!
        int factorial = IntStream.range(1, 6).
                reduce(1, (a, b) -> a * b);
        System.out.println(factorial);
        factorial = IntStream.rangeClosed(1, 5)
                .reduce(1, (a, b) -> a * b);
        System.out.println(factorial);

        // Find the Second-Largest Element in a List
        List<Integer> numbers = new ArrayList<>(List.of(3, 1, 2, 4, 5));
        int secondLargestNumber = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().orElse(0);
        System.out.println(secondLargestNumber);

        // Find the Second-Smallest Element in a List
        int secondSmallestNumber = numbers.stream()
                .sorted()
                .skip(1)
                .findFirst().orElse(0);
        System.out.println(secondSmallestNumber);

        // Find the Longest String in a List
        List<String> words = new ArrayList<>(List.of("apple", "be", "digger", "maths"));
        String longestWord = words.stream()
                .max(Comparator.comparingInt(word -> word.length())).orElse("");
        System.out.println(longestWord);

        longestWord = words.stream()
                .reduce((word1, word2) -> word1.length() >= word2.length() ? word1 : word2)
                .orElse(" ");
        System.out.println(longestWord);

        // Find the Shortest String in a List
        String smallestWord = words.stream()
                .min(Comparator.comparingInt(word -> word.length())).orElse(" ");
        System.out.println(smallestWord);

        smallestWord = words.stream()
                .reduce((word1, word2) -> word1.length() <= word2.length() ? word1 : word2)
                .orElse("");
        System.out.println(smallestWord);

        // Group a List of Strings by Their Length
        Map<Integer, List<String>> groupedWordsByTheirLength = words.stream()
                .collect(Collectors.groupingBy(word -> word.length()));
        System.out.println(groupedWordsByTheirLength);

        // Group a List of Objects by a Specific Attribute
        class Person {
            String name;
            int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }
        }
        List<Person> persons = new ArrayList<>(List.of(new Person("Yousuf", 18),
                new Person("Laddu", 20),
                new Person("Baba", 18)));
        Map<Integer, List<Person>> groupedByAge = persons.stream()
                .collect(Collectors.groupingBy(person -> person.getAge()));
        System.out.println(groupedByAge);

        // Partition a List of Integers into Even and Odd Numbers
        Map<Boolean, List<Integer>> evenOddPartitionedNumbers = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(evenOddPartitionedNumbers);

        // Merge Two Lists into a Single List
        List<Integer> list1 = List.of(1, 2, 3, 4);
        List<Integer> list2 = List.of(3, 4, 5);
        List<Integer> finalList = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());
        System.out.println(finalList);

        // Find the Intersection of Two Lists
        List<Integer> intersectedList = list1.stream()
                .filter(n -> list2.contains(n)).collect(Collectors.toList());
        System.out.println(intersectedList);

        // Find the Union of Two Lists
        List<Integer> unionList = Stream.concat(list1.stream(), list2.stream())
                .distinct().collect(Collectors.toList());
        System.out.println(unionList);

        // Find the Difference Between Two Lists
        List<Integer> differenceList = list1.stream()
                .filter(n -> !list2.contains(n)).collect(Collectors.toList());
        System.out.println(differenceList);

        // Count the Occurrences of Each Element in a List
        Map<Integer, Long> occurrencesOfEachElement = finalList.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        System.out.println(occurrencesOfEachElement);

        // Count the Occurrences of Each Character in a String
        String str = "hello";
        Map<Character, Long> characterOccurrences = str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        System.out.println(characterOccurrences);

        // Count the Occurrences of Each Word in a String
        str = "hello world hEllo";
        String[] strs = str.split(" ");
        Map<String, Long> wordOccurrences = Arrays.stream(strs)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(wordOccurrences);

        // Count the Occurrences of Each Vowel in a String
        Map<Character, Long> vowelOccurrences = str.chars()
                .mapToObj(ch -> (char) ch)
                .map(ch -> Character.toLowerCase(ch))
                .filter(ch -> "aeiou".contains(String.valueOf(ch).toLowerCase()))
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        System.out.println(vowelOccurrences);

        // Count the Occurrences of Each Digit in a String
        str = "hello 123 hello 345";
        Map<Integer, Long> digitOccurrences = str.chars()
                .map(ch -> Character.getNumericValue(ch))
                .filter(digit -> digit >= 0 && digit <= 9)
                .boxed()
                .collect(Collectors.groupingBy(digit -> digit, Collectors.counting()));
        System.out.println(digitOccurrences);

        // Reverse a String Using Streams
        str = "hello";
        String reversedString = str.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .reduce("", (a, b) -> b + a);
        System.out.println(reversedString);
    }
}
