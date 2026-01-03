package org.com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTheNamesStartingWithJAndLengthMoreThan3 {
    public static void main(String[] args) {
        // Given a list of names, count how many names start with the letter "J"
        // and have a length greater than 3

        String[] names = {"John", "Jane", "Joe", "James", "Al"};
        List<String> namesStartingWithJ = Arrays.stream(names)
                .filter(name -> name.startsWith("J") && name.length() > 3)
                .collect(Collectors.toList());
        System.out.println(namesStartingWithJ);
        System.out.println(namesStartingWithJ.size());
    }
}
