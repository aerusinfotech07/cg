package com.cg.java8.scenarios.single;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Scenarios2 {

    // Scenario 1: Convert a list of integers to a list of their string representations
    public void scenario1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<String> stringNumbers = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println("String Numbers: " + stringNumbers);
    }

    // Scenario 2: Find the maximum number in a list
    public void scenario2() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1);
        Optional<Integer> maxNumber = numbers.stream().max(Integer::compareTo);
        maxNumber.ifPresent(max -> System.out.println("Max Number: " + max));
    }

    // Scenario 3: Filter out empty strings from a list
    public void scenario3() {
        List<String> strings = Arrays.asList("Java", "", "Python", "C++", "");
        List<String> nonEmptyStrings = strings.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
        System.out.println("Non-empty Strings: " + nonEmptyStrings);
    }

    // Scenario 4: Calculate the product of all numbers in a list
    public void scenario4() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);
    }

    // Scenario 5: Create a map from a list of strings with their lengths
    public void scenario5() {
        List<String> words = Arrays.asList("Java", "Python", "JavaScript");
        Map<String, Integer> wordLengthMap = words.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("Word Length Map: " + wordLengthMap);
    }

    // Scenario 6: Get the first three elements from a list
    public void scenario6() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> firstThree = numbers.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("First Three: " + firstThree);
    }

    // Scenario 7: Convert a list of integers to their binary representations
    public void scenario7() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<String> binaryNumbers = numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
        System.out.println("Binary Numbers: " + binaryNumbers);
    }

    // Scenario 8: Find the first element that is greater than a given value
    public void scenario8() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);
        Optional<Integer> firstGreaterThanFive = numbers.stream()
                .filter(n -> n > 5)
                .findFirst();
        firstGreaterThanFive.ifPresent(n -> System.out.println("First Greater than 5: " + n));
    }

    // Scenario 9: Sort a list of strings by their length
    public void scenario9() {
        List<String> words = Arrays.asList("Java", "Python", "C++", "JavaScript");
        List<String> sortedByLength = words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Sorted by Length: " + sortedByLength);
    }

    // Scenario 10: Create a list of the first 10 Fibonacci numbers
    public void scenario10() {
        List<Integer> fibonacci = IntStream.range(0, 10)
                .map(n -> fibonacci(n))
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Fibonacci Numbers: " + fibonacci);
    }

    private int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Scenario 11: Concatenate a list of strings
    public void scenario11() {
        List<String> words = Arrays.asList("Java", "is", "fun");
        String sentence = words.stream().collect(Collectors.joining(" "));
        System.out.println("Concatenated Sentence: " + sentence);
    }

    // Scenario 12: Get the distinct characters from a string
    public void scenario12() {
        String str = "Hello World";
        Set<Character> distinctChars = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        System.out.println("Distinct Characters: " + distinctChars);
    }

    // Scenario 13: Count the occurrences of each character in a string
    public void scenario13() {
        String str = "hello";
        Map<Character, Long> charCount = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Character Count: " + charCount);
    }

    // Scenario 14: Find the smallest number in a list
    public void scenario14() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1);
        Optional<Integer> minNumber = numbers.stream().min(Integer::compareTo);
        minNumber.ifPresent(min -> System.out.println("Min Number: " + min));
    }

    // Scenario 15: Check if any number in the list is even
    public void scenario15() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7);
        boolean hasEven = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("Has Even: " + hasEven);
    }

    // Scenario 16: Check if all numbers in the list are positive
    public void scenario16() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, -4);
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("All Positive: " + allPositive);
    }

    // Scenario 17: Create a list of squares of numbers
    public void scenario17() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares: " + squares);
    }

    // Scenario 18: Group words by their lengths
    public void scenario18() {
        List<String> words = Arrays.asList("Java", "Python", "C++", "JavaScript");
        Map<Integer, List<String>> groupedByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by Length: " + groupedByLength);
    }

    // Scenario 19: Get the second largest number in a list
    public void scenario19() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 7);
        Optional<Integer> secondLargest = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        secondLargest.ifPresent(num -> System.out.println("Second Largest: " + num));
    }

    // Scenario 20: Convert a list of names to a comma-separated string
    public void scenario20() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        String nameString = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Name String: " + nameString);
    }

    // Scenario 21: Find the intersection of two sets
    public void scenario21() {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(2, 3, 4));
        Set<Integer> intersection = set1.stream()
                .filter(set2::contains)
                .collect(Collectors.toSet());
        System.out.println("Intersection: " + intersection);
    }

    // Scenario 22: Check if a string is a palindrome
    public void scenario22() {
        String str = "madam";
        boolean isPalindrome = str.equals(new StringBuilder(str).reverse().toString());
        System.out.println("Is Palindrome: " + isPalindrome);
    }

    // Scenario 23: Count the number of words in a sentence
    public void scenario23() {
        String sentence = "Java is fun and powerful";
        long wordCount = Arrays.stream(sentence.split(" ")).count();
        System.out.println("Word Count: " + wordCount);
    }

    // Scenario 24: Filter out negative numbers from a list
    public void scenario24() {
        List<Integer> numbers = Arrays.asList(-1, 2, -3, 4);
        List<Integer> nonNegativeNumbers = numbers.stream()
                .filter(n -> n >= 0)
                .collect(Collectors.toList());
        System.out.println("Non-Negative Numbers: " + nonNegativeNumbers);
    }

    // Scenario 25: Get the longest word in a list
    public void scenario25() {
        List<String> words = Arrays.asList("Java", "Python", "JavaScript");
        Optional<String> longestWord = words.stream()
                .max(Comparator.comparingInt(String::length));
        longestWord.ifPresent(word -> System.out.println("Longest Word: " + word));
    }

    // Scenario 26: Remove duplicates from a list
    public void scenario26() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4);
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique Numbers: " + uniqueNumbers);
    }

    // Scenario 27: Create a list of factorials
    public void scenario27() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> factorials = numbers.stream()
                .map(this::factorial)
                .collect(Collectors.toList());
        System.out.println("Factorials: " + factorials);
    }

    private int factorial(int n) {
        return (n == 0) ? 1 : n * factorial(n - 1);
    }

    // Scenario 28: Check if a string is numeric
    public void scenario28() {
        String str = "1234";
        boolean isNumeric = str.chars().allMatch(Character::isDigit);
        System.out.println("Is Numeric: " + isNumeric);
    }

    // Scenario 29: Get the current date and time formatted
    public void scenario29() {
        String formattedDateTime = java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("Current DateTime: " + formattedDateTime);
    }

    // Scenario 30: Create a list of even numbers from a given list
    public void scenario30() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);
    }

    // Scenario 31: Get the total number of characters in a list of strings
    public void scenario31() {
        List<String> words = Arrays.asList("Java", "Python", "C++");
        int totalCharacters = words.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("Total Characters: " + totalCharacters);
    }

    // Scenario 32: Generate a list of random integers
    public void scenario32() {
        List<Integer> randomNumbers = new Random().ints(10, 1, 100)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Random Numbers: " + randomNumbers);
    }

    // Scenario 33: Get the first n prime numbers
    public void scenario33() {
        List<Integer> primes = IntStream.iterate(2, n -> n + 1)
                .filter(this::isPrime)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("First 10 Prime Numbers: " + primes);
    }

    private boolean isPrime(int n) {
        return IntStream.range(2, (int) Math.sqrt(n) + 1).noneMatch(i -> n % i == 0);
    }

    // Scenario 34: Find the average of a list of integers
    public void scenario34() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        System.out.println("Average: " + average);
    }

    // Scenario 35: Generate a list of squares of the first 10 natural numbers
    public void scenario35() {
        List<Integer> squares = IntStream.rangeClosed(1, 10)
                .map(n -> n * n)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Squares of First 10 Natural Numbers: " + squares);
    }

    // Scenario 36: Flatten a list of lists
    public void scenario36() {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Java", "Python"),
                Arrays.asList("C++", "JavaScript")
        );
        List<String> flattened = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened List: " + flattened);
    }

    // Scenario 37: Count the number of occurrences of each word in a sentence
    public void scenario37() {
        String sentence = "Java is Java and Python is fun";
        Map<String, Long> wordCount = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Word Count: " + wordCount);
    }

    // Scenario 38: Get the last element of a list
    public void scenario38() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        Integer lastElement = numbers.stream()
                .reduce((first, second) -> second)
                .orElse(null);
        System.out.println("Last Element: " + lastElement);
    }

    // Scenario 39: Create a list of cubed values
    public void scenario39() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> cubes = numbers.stream()
                .map(n -> n * n * n)
                .collect(Collectors.toList());
        System.out.println("Cubed Values: " + cubes);
    }

    // Scenario 40: Check if a list contains a specific element
    public void scenario40() {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
        boolean containsBanana = fruits.contains("Banana");
        System.out.println("Contains Banana: " + containsBanana);
    }

    // Scenario 41: Generate a list of the first 10 factorial numbers
    public void scenario41() {
        List<Integer> factorials = IntStream.rangeClosed(0, 9)
                .map(this::factorial)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("First 10 Factorials: " + factorials);
    }

    // Scenario 42: Find the second smallest number in a list
    public void scenario42() {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 7);
        Optional<Integer> secondSmallest = numbers.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst();
        secondSmallest.ifPresent(num -> System.out.println("Second Smallest: " + num));
    }

    // Scenario 43: Get the maximum length of strings in a list
    public void scenario43() {
        List<String> words = Arrays.asList("Java", "Python", "JavaScript");
        int maxLength = words.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
        System.out.println("Max Length: " + maxLength);
    }

    // Scenario 44: Create a map with words and their lengths
    public void scenario44() {
        List<String> words = Arrays.asList("Java", "Python", "JavaScript");
        Map<String, Integer> wordLengthMap = words.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("Word Length Map: " + wordLengthMap);
    }

    // Scenario 45: Count the total number of even and odd numbers
    public void scenario45() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Map<Boolean, Long> countMap = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0, Collectors.counting()));
        System.out.println("Count of Even and Odd: " + countMap);
    }

    // Scenario 46: Get the unique lengths of words in a list
    public void scenario46() {
        List<String> words = Arrays.asList("Java", "Python", "JavaScript");
        Set<Integer> uniqueLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toSet());
        System.out.println("Unique Lengths: " + uniqueLengths);
    }

    // Scenario 47: Create a list of integers from 1 to 20 that are divisible by 3
    public void scenario47() {
        List<Integer> divisibleByThree = IntStream.rangeClosed(1, 20)
                .filter(n -> n % 3 == 0)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Divisible by 3: " + divisibleByThree);
    }

    // Scenario 48: Get the sum of even numbers from a list
    public void scenario48() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sumOfEvens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of Even Numbers: " + sumOfEvens);
    }

    // Scenario 49: Find the first non-repeated character in a string
    public void scenario49() {
        String str = "swiss";
        Optional<Character> firstNonRepeated = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str.indexOf(c) == str.lastIndexOf(c))
                .findFirst();
        firstNonRepeated.ifPresent(c -> System.out.println("First Non-Repeated Character: " + c));
    }

    // Scenario 50: Count how many times a specific word appears in a sentence
    public void scenario50() {
        String sentence = "Java is Java and Java is fun";
        String targetWord = "Java";
        long count = Arrays.stream(sentence.split(" "))
                .filter(word -> word.equals(targetWord))
                .count();
        System.out.println("Count of '" + targetWord + "': " + count);
    }

    // Scenario 51: Reverse a list of integers
    public void scenario51() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> reversed = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Reversed List: " + reversed);
    }

    // Scenario 52: Create a list of random strings
    public void scenario52() {
        List<String> randomStrings = new Random().ints(5, 97, 122)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.toList());
        System.out.println("Random Strings: " + randomStrings);
    }

    // Scenario 53: Get the average length of words in a list
    public void scenario53() {
        List<String> words = Arrays.asList("Java", "Python", "JavaScript");
        double averageLength = words.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);
        System.out.println("Average Length: " + averageLength);
    }

    // Scenario 54: Create a list of numbers from 1 to 100 and filter only prime numbers
    public void scenario54() {
        List<Integer> primeNumbers = IntStream.rangeClosed(1, 100)
                .filter(this::isPrime)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Prime Numbers from 1 to 100: " + primeNumbers);
    }

    // Scenario 55: Count the number of vowels in a string
    public void scenario55() {
        String str = "Hello World";
        long vowelCount = str.chars()
                .filter(c -> "AEIOUaeiou".indexOf(c) != -1)
                .count();
        System.out.println("Vowel Count: " + vowelCount);
    }

    // Scenario 56: Check if a list is empty
    public void scenario56() {
        List<String> list = new ArrayList<>();
        boolean isEmpty = list.isEmpty();
        System.out.println("Is List Empty: " + isEmpty);
    }

    // Scenario 57: Get the last n elements of a list
    public void scenario57() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int n = 3;
        List<Integer> lastN = numbers.stream()
                .skip(numbers.size() - n)
                .collect(Collectors.toList());
        System.out.println("Last " + n + " Elements: " + lastN);
    }

    // Scenario 58: Get the current year
    public void scenario58() {
        int currentYear = java.time.LocalDate.now().getYear();
        System.out.println("Current Year: " + currentYear);
    }

    // Scenario 59: Find the common elements between two lists
    public void scenario59() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
        List<Integer> commonElements = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
        System.out.println("Common Elements: " + commonElements);
    }

    // Scenario 60: Create a list of the squares of even numbers from 1 to 20
    public void scenario60() {
        List<Integer> squaresOfEvens = IntStream.rangeClosed(1, 20)
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Squares of Even Numbers: " + squaresOfEvens);
    }

    // Scenario 61: Get the most frequent element in a list
    public void scenario61() {
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana");
        Optional<String> mostFrequent = items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
        mostFrequent.ifPresent(item -> System.out.println("Most Frequent Item: " + item));
    }

    // Scenario 62: Create a list of characters from a string
    public void scenario62() {
        String str = "Java";
        List<Character> characters = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        System.out.println("Characters: " + characters);
    }

    // Scenario 63: Find the index of the first occurrence of a character in a string
    public void scenario63() {
        String str = "Hello World";
        int index = str.indexOf('o');
        System.out.println("Index of First 'o': " + index);
    }

    // Scenario 64: Check if a list contains only distinct elements
    public void scenario64() {
        List<String> items = Arrays.asList("apple", "banana", "apple");
        boolean hasDuplicates = items.size() != new HashSet<>(items).size();
        System.out.println("Contains Duplicates: " + hasDuplicates);
    }

    // Scenario 65: Create a list of characters that are vowels from a string
    public void scenario65() {
        String str = "Hello World";
        List<Character> vowels = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> "AEIOUaeiou".indexOf(c) != -1)
                .collect(Collectors.toList());
        System.out.println("Vowels: " + vowels);
    }

    // Scenario 66: Get the unique words from a sentence
    public void scenario66() {
        String sentence = "Java is fun and Java is powerful";
        Set<String> uniqueWords = Arrays.stream(sentence.split(" "))
                .collect(Collectors.toSet());
        System.out.println("Unique Words: " + uniqueWords);
    }

    // Scenario 67: Calculate the sum of the squares of a list of integers
    public void scenario67() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int sumOfSquares = numbers.stream()
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Sum of Squares: " + sumOfSquares);
    }

    // Scenario 68: Filter and collect words longer than 4 characters
    public void scenario68() {
        List<String> words = Arrays.asList("Java", "Python", "C++", "JavaScript");
        List<String> longWords = words.stream()
                .filter(word -> word.length() > 4)
                .collect(Collectors.toList());
        System.out.println("Words Longer than 4 Characters: " + longWords);
    }

    // Scenario 69: Get a list of all substrings of a given string
    /*public void scenario69() {
        String str = "abc";
        List<String> substrings = IntStream.range(0, str.length())
                .flatMap(i -> IntStream.range(i + 1, str.length() + 1)
                        .mapToObj(j -> str.substring(i, j)))
                .collect(Collectors.toList());
        System.out.println("Substrings: " + substrings);
    }*/

    // Scenario 70: Get the unique integers from a list of mixed numbers
    public void scenario70() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 1, 4);
        Set<Integer> uniqueIntegers = new HashSet<>(numbers);
        System.out.println("Unique Integers: " + uniqueIntegers);
    }

    // Scenario 71: Check if a string starts with a specific prefix
    public void scenario71() {
        String str = "Hello World";
        boolean startsWithHello = str.startsWith("Hello");
        System.out.println("Starts with 'Hello': " + startsWithHello);
    }

    // Scenario 72: Get the first character of each word in a sentence
    public void scenario72() {
        String sentence = "Java is fun and powerful";
        List<Character> firstChars = Arrays.stream(sentence.split(" "))
                .map(word -> word.charAt(0))
                .collect(Collectors.toList());
        System.out.println("First Characters: " + firstChars);
    }

    // Scenario 73: Count the total number of words in a sentence
    public void scenario73() {
        String sentence = "Java is fun and powerful";
        long wordCount = Arrays.stream(sentence.split(" "))
                .count();
        System.out.println("Word Count: " + wordCount);
    }

    // Scenario 74: Create a list of random doubles
    public void scenario74() {
        List<Double> randomDoubles = new Random().doubles(10, 1.0, 100.0)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Random Doubles: " + randomDoubles);
    }

    // Scenario 75: Create a list of squares from a given list of integers
    public void scenario75() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares: " + squares);
    }

    // Scenario 76: Get the first n elements of a list
    public void scenario76() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int n = 3;
        List<Integer> firstN = numbers.stream()
                .limit(n)
                .collect(Collectors.toList());
        System.out.println("First " + n + " Elements: " + firstN);
    }

    // Scenario 77: Concatenate a list of strings
    public void scenario77() {
        List<String> strings = Arrays.asList("Java", "is", "fun");
        String concatenated = strings.stream()
                .collect(Collectors.joining(" "));
        System.out.println("Concatenated String: " + concatenated);
    }

    // Scenario 78: Find the longest string in a list
    public void scenario78() {
        List<String> words = Arrays.asList("Java", "Python", "JavaScript");
        Optional<String> longestString = words.stream()
                .max(Comparator.comparingInt(String::length));
        longestString.ifPresent(word -> System.out.println("Longest String: " + word));
    }

    // Scenario 79: Get the distinct elements from a list
    public void scenario79() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct Numbers: " + distinctNumbers);
    }

    // Scenario 80: Check if a number is even or odd
    public void scenario80() {
        int number = 7;
        String evenOrOdd = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println("Number is: " + evenOrOdd);
    }

    // Scenario 81: Find the sum of a list of integers
    public void scenario81() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum: " + sum);
    }

    // Scenario 82: Calculate the length of each word in a list
    public void scenario82() {
        List<String> words = Arrays.asList("Java", "Python", "JavaScript");
        List<Integer> lengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Lengths of Words: " + lengths);
    }

    // Scenario 83: Create a list of strings from a given string
    public void scenario83() {
        String str = "Java is fun";
        List<String> stringList = Arrays.asList(str.split(" "));
        System.out.println("String List: " + stringList);
    }

    // Scenario 84: Find the difference between the highest and lowest number in a list
    public void scenario84() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int min = numbers.stream().min(Integer::compare).orElse(0);
        int max = numbers.stream().max(Integer::compare).orElse(0);
        int difference = max - min;
        System.out.println("Difference: " + difference);
    }

    // Scenario 85: Get the middle element of a list
    public void scenario85() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer middle = numbers.get(numbers.size() / 2);
        System.out.println("Middle Element: " + middle);
    }

    // Scenario 86: Calculate the product of a list of integers
    public void scenario86() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);
    }

    // Scenario 87: Find the maximum number in a list
    public void scenario87() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int max = numbers.stream().max(Integer::compare).orElse(0);
        System.out.println("Max: " + max);
    }

    // Scenario 88: Get the minimum number in a list
    public void scenario88() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int min = numbers.stream().min(Integer::compare).orElse(0);
        System.out.println("Min: " + min);
    }

    // Scenario 89: Get the sum of the lengths of all strings in a list
    public void scenario89() {
        List<String> words = Arrays.asList("Java", "Python", "JavaScript");
        int totalLength = words.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("Total Length of Strings: " + totalLength);
    }

    // Scenario 90: Get the last n elements of a list using subList
    public void scenario90() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int n = 3;
        List<Integer> lastN = numbers.subList(numbers.size() - n, numbers.size());
        System.out.println("Last " + n + " Elements: " + lastN);
    }

    // Scenario 91: Get the unique words from a sentence ignoring case
    public void scenario91() {
        String sentence = "Java is fun and java is powerful";
        Set<String> uniqueWords = Arrays.stream(sentence.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        System.out.println("Unique Words (Case Insensitive): " + uniqueWords);
    }

    // Scenario 92: Find the longest palindrome in a list of strings
    public void scenario92() {
        List<String> words = Arrays.asList("racecar", "hello", "level", "world");
        Optional<String> longestPalindrome = words.stream()
                .filter(this::isPalindrome)
                .max(Comparator.comparingInt(String::length));
        longestPalindrome.ifPresent(palindrome -> System.out.println("Longest Palindrome: " + palindrome));
    }

    private boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    // Scenario 93: Get the total number of sentences in a paragraph
    public void scenario93() {
        String paragraph = "Java is great. Python is fun. C++ is powerful.";
        long sentenceCount = Arrays.stream(paragraph.split("\\."))
                .filter(sentence -> !sentence.trim().isEmpty())
                .count();
        System.out.println("Total Sentences: " + sentenceCount);
    }

    // Scenario 94: Create a list of integers from a given range
    public void scenario94() {
        List<Integer> range = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Range from 1 to 10: " + range);
    }

    // Scenario 95: Create a list of random booleans
    public void scenario95() {
        List<Boolean> randomBooleans = new Random().ints(10, 0, 2)
                .mapToObj(i -> i == 0)
                .collect(Collectors.toList());
        System.out.println("Random Booleans: " + randomBooleans);
    }

    // Scenario 96: Get the frequency of each character in a string
    public void scenario96() {
        String str = "hello";
        Map<Character, Long> frequencyMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Character Frequencies: " + frequencyMap);
    }

    // Scenario 97: Get the longest word in a list ignoring case
    public void scenario97() {
        List<String> words = Arrays.asList("Java", "python", "JavaScript");
        Optional<String> longestWord = words.stream()
                .map(String::toLowerCase)
                .max(Comparator.comparingInt(String::length));
        longestWord.ifPresent(word -> System.out.println("Longest Word (Ignore Case): " + word));
    }

    // Scenario 98: Count the number of unique characters in a string
    public void scenario98() {
        String str = "hello";
        long uniqueCharCount = str.chars()
                .distinct()
                .count();
        System.out.println("Unique Character Count: " + uniqueCharCount);
    }

    // Scenario 99: Check if a string is a pangram
    public void scenario99() {
        String str = "The quick brown fox jumps over the lazy dog";
        boolean isPangram = str.chars().map(Character::toLowerCase)
                .distinct()
                .count() == 26;
        System.out.println("Is Pangram: " + isPangram);
    }

    // Scenario 100: Get the average of a list of integers
    public void scenario100() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        System.out.println("Average: " + average);
    }

    public static void main(String[] args) {
        Java8Scenarios2 scenarios = new Java8Scenarios2();
        scenarios.scenario1();
        scenarios.scenario2();
        scenarios.scenario3();
        scenarios.scenario4();
        scenarios.scenario5();
        scenarios.scenario6();
        scenarios.scenario7();
        scenarios.scenario8();
        scenarios.scenario9();
        scenarios.scenario10();
        // Add calls for additional scenarios as needed.
    }
}
