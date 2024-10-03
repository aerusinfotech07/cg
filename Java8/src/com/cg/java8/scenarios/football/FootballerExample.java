package com.cg.java8.scenarios.football;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Gender {
    MALE, FEMALE
}

class Footballer {
    private String name;
    private int age;
    private Gender gender;
    private List<String> positions;

    public Footballer(String name, int age, Gender gender, List<String> positions) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.positions = positions;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public List<String> getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return "Footballer{name='" + name + "', age=" + age + ", gender=" + gender + ", positions=" + positions + '}';
    }
}

public class FootballerExample {

    // Method to provide a list of Footballers
    private List<Footballer> getFootballers() {
        return List.of(
                new Footballer("Messi", 32, Gender.MALE, List.of("CF", "CAM", "RF")),
                new Footballer("Griezmann", 28, Gender.MALE, List.of("CF", "CAM", "LF")),
                new Footballer("Arthur", 23, Gender.MALE, List.of("CM", "CAM")),
                new Footballer("Ter Stegen", 27, Gender.MALE, List.of("GK")),
                new Footballer("Puig", 20, Gender.MALE, List.of("CM", "CDM")),
                new Footballer("Jennifer", 29, Gender.FEMALE, List.of("CF", "CAM")),
                new Footballer("Jana", 17, Gender.FEMALE, List.of("CB")),
                new Footballer("Alexia", 25, Gender.FEMALE, List.of("CAM", "RF", "LF"))
        );
    }

    public void runExamples() {
        List<Footballer> footballerList = getFootballers();

        // 1. Filter: Find all female footballers older than 23
        List<Footballer> collect = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.FEMALE))
                .filter(footballer -> footballer.getAge() > 23)
                .collect(Collectors.toList());
        System.out.println("Female footballers older than 23: " + collect);

        // 2. Map: Count females older than 24
        long femalesMoreThan24y = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.FEMALE))
                .map(Footballer::getAge)
                .filter(age -> age > 24)
                .count();
        System.out.println("Number of females older than 24: " + femalesMoreThan24y);

        // 3. FlatMap: Get all positions of male footballers younger than 30
        String allPositionsOfMaleLessThan30y = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.MALE))
                .filter(footballer -> footballer.getAge() < 30)
                .map(Footballer::getPositions)
                .flatMap(Collection::stream)
                .collect(Collectors.joining(","));
        System.out.println("All positions of male footballers younger than 30: " + allPositionsOfMaleLessThan30y);

        // 4. Distinct: Get unique positions of male footballers younger than 30
        String allUniquePositionsOfMaleLessThan30y = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.MALE))
                .filter(footballer -> footballer.getAge() < 30)
                .map(Footballer::getPositions)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.joining(","));
        System.out.println("Unique positions of male footballers younger than 30: " + allUniquePositionsOfMaleLessThan30y);

        // 5. Sorted: Sort footballers by gender and name
        List<Footballer> sortedByGenderAndName = footballerList.stream()
                .sorted(Comparator.comparing(Footballer::getGender).thenComparing(Footballer::getName))
                .collect(Collectors.toList());
        System.out.println("Sorted by gender and name: " + sortedByGenderAndName);

        // 6. Peek: Print each male footballer while counting them
        long malePlayerCount = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.MALE))
                .peek(footballer -> System.out.println("Male footballer: " + footballer))
                .count();
        System.out.println("Total male footballers: " + malePlayerCount);

        // 7. Limit: Get first 2 male footballers
        List<Footballer> twoMaleFootballers = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.MALE))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("First two male footballers: " + twoMaleFootballers);

        // 8. Skip: Skip the first 5 sorted footballers
        List<Footballer> skippedFootballers = footballerList.stream()
                .sorted(Comparator.comparing(Footballer::getGender).thenComparing(Footballer::getName))
                .skip(5)
                .collect(Collectors.toList());
        System.out.println("Footballers after skipping first 5: " + skippedFootballers);

        // 9. Take While: Take even numbers until condition fails
        List<Integer> takeAWhile = Stream.of(2, 4, 6, 8, 9, 10, 11, 12)
                .takeWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Take while even: " + takeAWhile);

        // 10. Drop While: Drop even numbers until condition fails
        List<Integer> dropWhile = Stream.of(2, 4, 6, 8, 9, 10, 11, 12)
                .dropWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Drop while even: " + dropWhile);

        // 11. Count: Count females older than 24
        long countFemalesMoreThan24 = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.FEMALE))
                .filter(footballer -> footballer.getAge() > 24)
                .count();
        System.out.println("Count of females older than 24: " + countFemalesMoreThan24);

        // 12. For Each: Print numbers less than 65
        List.of(4, 1, 6, 7, 19, 2, 3, 81, 64).stream()
                .parallel()
                .filter(number -> number < 65)
                .forEach(number -> System.out.println("Number less than 65: " + number));

        // 13. To Array: Convert female footballers to an array
        Footballer[] femaleFootballers = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.FEMALE))
                .toArray(Footballer[]::new);
        System.out.println("Array of female footballers: " + Arrays.asList(femaleFootballers));

        // 14. Min: Get minimum age
        Integer minAge = footballerList.stream()
                .min(Comparator.comparing(Footballer::getAge))
                .map(Footballer::getAge)
                .orElse(null);
        System.out.println("Minimum age: " + minAge);

        // 15. Max: Get maximum age
        Integer maxAge = footballerList.stream()
                .max(Comparator.comparing(Footballer::getAge))
                .map(Footballer::getAge)
                .orElse(null);
        System.out.println("Maximum age: " + maxAge);

        // 16. Any Match: Check if any footballer is older than 25
        boolean anyMatch = footballerList.stream()
                .anyMatch(footballer -> footballer.getAge() > 25);
        System.out.println("Any footballer older than 25: " + anyMatch);

        // 17. All Match: Check if all footballers are older than 25
        boolean allMatch = footballerList.stream()
                .allMatch(footballer -> footballer.getAge() > 25);
        System.out.println("All footballers older than 25: " + allMatch);

        // 18. None Match: Check if no footballer is older than 100
        boolean noneMatch = footballerList.stream()
                .noneMatch(footballer -> footballer.getAge() > 100);
        System.out.println("No footballer older than 100: " + noneMatch);

        // 19. Find First: Find the first number greater than 5
        Integer findFirst = List.of(4, 1, 3, 7, 5, 6, 2, 28, 15, 29)
                .parallelStream()
                .filter(number -> number > 5)
                .findFirst()
                .orElse(null);
        System.out.println("First number greater than 5: " + findFirst);

        // 20. Find Any: Find any number greater than 5
        Integer findAny = List.of(4, 1, 3, 7, 5, 6, 2, 28, 15, 29)
                .parallelStream()
                .filter(number -> number > 5)
                .findAny()
                .orElse(null);
        System.out.println("Any number greater than 5: " + findAny);

        // 21. Reduce: Find the longest name
        Optional<String> longestName = footballerList.stream()
                .map(Footballer::getName)
                .reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2);
        longestName.ifPresent(name -> System.out.println("Longest name: " + name));

        // 22. Collect: Gather female footballers into a list
        List<Footballer> collectedFemales = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        System.out.println("Collected female footballers: " + collectedFemales);
        
        // 23. Count of male and female footballers
        Map<Gender, Long> genderCount = getFootballers().stream()
                .collect(Collectors.groupingBy(Footballer::getGender, Collectors.counting()));
        System.out.println("Count of footballers by gender: " + genderCount);

        
    }

    public static void main(String[] args) {
        FootballerExample example = new FootballerExample();
        example.runExamples();
    }
}
