package com.cg.java8.scenarios.single;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Scenarios1 {

    // Scenario 1: Create a list of squares from 1 to 10
    public void scenario1() {
        List<Integer> squares = IntStream.rangeClosed(1, 10)
                .map(n -> n * n)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Squares: " + squares);
    }

    // Scenario 2: Filter even numbers from a list
    public void scenario2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evens);
    }

    // Scenario 3: Create a list of names in uppercase
    public void scenario3() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase Names: " + upperNames);
    }

    // Scenario 4: Find the maximum number in a list
    public void scenario4() {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8);
        Optional<Integer> maxNumber = numbers.stream().max(Integer::compareTo);
        maxNumber.ifPresent(max -> System.out.println("Max Number: " + max));
    }

    // Scenario 5: Create a list of even squares from 1 to 10
    public void scenario5() {
        List<Integer> evenSquares = IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Even Squares: " + evenSquares);
    }

    // Scenario 6: Get the sum of a list of integers
    public void scenario6() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum: " + sum);
    }

    // Scenario 7: Create a list of first 10 Fibonacci numbers
    public void scenario7() {
        List<Integer> fibonacci = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                .limit(10)
                .map(f -> f[0])
                .collect(Collectors.toList());
        System.out.println("First 10 Fibonacci Numbers: " + fibonacci);
    }

    // Scenario 8: Find the average of a list of numbers
    public void scenario8() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average: " + average);
    }

    // Scenario 9: Count the number of characters in a string
    public void scenario9() {
        String str = "Hello World";
        long count = str.chars().count();
        System.out.println("Character Count: " + count);
    }

    // Scenario 10: Filter names that contain the letter 'a'
    public void scenario10() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        List<String> containsA = names.stream()
                .filter(name -> name.contains("a") || name.contains("A"))
                .collect(Collectors.toList());
        System.out.println("Names Containing 'a': " + containsA);
    }

    // Scenario 11: Check if any number is greater than 10
    public void scenario11() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 15);
        boolean anyGreaterThanTen = numbers.stream().anyMatch(n -> n > 10);
        System.out.println("Any Number Greater than 10: " + anyGreaterThanTen);
    }

    // Scenario 12: Group names by their length
    public void scenario12() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        Map<Integer, List<String>> groupedByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by Length: " + groupedByLength);
    }

    // Scenario 13: Convert a list of strings to a single string
    public void scenario13() {
        List<String> words = Arrays.asList("Hello", "World");
        String combined = words.stream().collect(Collectors.joining(" "));
        System.out.println("Combined String: " + combined);
    }

    // Scenario 14: Find the first even number in a list
    public void scenario14() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 10);
        Optional<Integer> firstEven = numbers.stream().filter(n -> n % 2 == 0).findFirst();
        firstEven.ifPresent(n -> System.out.println("First Even Number: " + n));
    }

    // Scenario 15: Create a list of numbers squared greater than 10
    public void scenario15() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squaresGreaterThanTen = numbers.stream()
                .map(n -> n * n)
                .filter(n -> n > 10)
                .collect(Collectors.toList());
        System.out.println("Squares Greater than 10: " + squaresGreaterThanTen);
    }

    // Scenario 16: Get distinct characters from a string
    public void scenario16() {
        String str = "hello world";
        Set<Character> distinctChars = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        System.out.println("Distinct Characters: " + distinctChars);
    }

    // Scenario 17: Calculate the product of a list of integers
    public void scenario17() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);
    }

    // Scenario 18: Find the longest name
    public void scenario18() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        Optional<String> longestName = names.stream()
                .max(Comparator.comparingInt(String::length));
        longestName.ifPresent(name -> System.out.println("Longest Name: " + name));
    }

    // Scenario 19: Count the number of words in a sentence
    public void scenario19() {
        String sentence = "Hello world this is Java 8";
        long wordCount = Arrays.stream(sentence.split(" ")).count();
        System.out.println("Word Count: " + wordCount);
    }

    // Scenario 20: Check if all names start with a vowel
    public void scenario20() {
        List<String> names = Arrays.asList("Alice", "Eve", "Oscar");
        boolean allStartWithVowel = names.stream()
                .allMatch(name -> "AEIOUaeiou".indexOf(name.charAt(0)) >= 0);
        System.out.println("All Names Start with a Vowel: " + allStartWithVowel);
    }

    // Scenario 21: Filter out null values from a list
    public void scenario21() {
        List<String> names = Arrays.asList("John", null, "Alice", "Bob", null);
        List<String> nonNullNames = names.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        System.out.println("Non-null Names: " + nonNullNames);
    }

    // Scenario 22: Create a list of random integers
    public void scenario22() {
        List<Integer> randomNumbers = new Random().ints(10, 0, 100)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Random Numbers: " + randomNumbers);
    }

    // Scenario 23: Flatten a list of lists
    public void scenario23() {
        List<List<String>> listOfLists = Arrays.asList(Arrays.asList("John", "Alice"), Arrays.asList("Bob", "Charlie"));
        List<String> flattened = listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened List: " + flattened);
    }

    // Scenario 24: Find the second largest number in a list
    public void scenario24() {
        List<Integer> numbers = Arrays.asList(5, 1, 3, 4, 2);
        Optional<Integer> secondLargest = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst();
        secondLargest.ifPresent(num -> System.out.println("Second Largest Number: " + num));
    }

    // Scenario 25: Create a map of name lengths
    public void scenario25() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        Map<String, Integer> nameLengthMap = names.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("Name Length Map: " + nameLengthMap);
    }

    // Scenario 26: Convert a list of strings to lowercase
    public void scenario26() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        List<String> lowerNames = names.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println("Lowercase Names: " + lowerNames);
    }

    // Scenario 27: Check if all numbers are positive
    public void scenario27() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, -4, 5);
        boolean allPositive = numbers.stream().allMatch(n -> n > 0);
        System.out.println("All Numbers Positive: " + allPositive);
    }

    // Scenario 28: Count the number of occurrences of each word
    public void scenario28() {
        String sentence = "Java is fun and Java is powerful";
        Map<String, Long> wordCount = Arrays.stream(sentence.split("\\s+"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Word Count: " + wordCount);
    }

    // Scenario 29: Get the first three elements of a list
    public void scenario29() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        List<String> firstThree = names.stream().limit(3).collect(Collectors.toList());
        System.out.println("First Three Names: " + firstThree);
    }

    // Scenario 30: Create a list of prime numbers up to 30
    public void scenario30() {
        List<Integer> primes = IntStream.rangeClosed(2, 30)
                .filter(n -> IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0))
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Prime Numbers up to 30: " + primes);
    }

    // Scenario 31: Reverse a list of strings
    public void scenario31() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        List<String> reversedNames = names.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Reversed Names: " + reversedNames);
    }

    // Scenario 32: Get names in uppercase and lowercase
    public void scenario32() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        List<String> upperLower = names.stream()
                .flatMap(name -> Stream.of(name.toUpperCase(), name.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("Upper and Lower Names: " + upperLower);
    }

    // Scenario 33: Check if a string is a palindrome
    public void scenario33() {
        String str = "madam";
        boolean isPalindrome = str.equals(new StringBuilder(str).reverse().toString());
        System.out.println("Is Palindrome: " + isPalindrome);
    }

    // Scenario 34: Create a list of unique elements from two lists
    public void scenario34() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4, 5);
        List<Integer> uniqueElements = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique Elements: " + uniqueElements);
    }

    // Scenario 35: Get the last two elements of a list
    public void scenario35() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        List<String> lastTwo = names.stream()
                .skip(Math.max(0, names.size() - 2))
                .collect(Collectors.toList());
        System.out.println("Last Two Names: " + lastTwo);
    }

    // Scenario 36: Find the common elements between two lists
    public void scenario36() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
        List<Integer> commonElements = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
        System.out.println("Common Elements: " + commonElements);
    }

    // Scenario 37: Find the minimum number in a list
    public void scenario37() {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2);
        Optional<Integer> minNumber = numbers.stream().min(Integer::compareTo);
        minNumber.ifPresent(min -> System.out.println("Minimum Number: " + min));
    }

    // Scenario 38: Create a list of characters from a string
    public void scenario38() {
        String str = "Hello";
        List<Character> characters = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        System.out.println("Characters: " + characters);
    }

    // Scenario 39: Count the number of digits in a string
    public void scenario39() {
        String str = "Hello123";
        long digitCount = str.chars().filter(Character::isDigit).count();
        System.out.println("Digit Count: " + digitCount);
    }

    // Scenario 40: Create a list of numbers as strings
    public void scenario40() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        List<String> numberStrings = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println("Numbers as Strings: " + numberStrings);
    }

    // Scenario 41: Find the average length of words in a sentence
    public void scenario41() {
        String sentence = "Java is a programming language";
        double averageLength = Arrays.stream(sentence.split(" "))
                .mapToInt(String::length)
                .average()
                .orElse(0);
        System.out.println("Average Length of Words: " + averageLength);
    }

    // Scenario 42: Find the longest word in a sentence
    public void scenario42() {
        String sentence = "Java is a programming language";
        String longestWord = Arrays.stream(sentence.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("Longest Word: " + longestWord);
    }

    // Scenario 43: Create a list of multiples of 5
    public void scenario43() {
        List<Integer> multiplesOfFive = IntStream.rangeClosed(1, 20)
                .filter(n -> n % 5 == 0)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Multiples of 5: " + multiplesOfFive);
    }

    // Scenario 44: Create a list of powers of 2
    public void scenario44() {
        List<Integer> powersOfTwo = IntStream.rangeClosed(0, 10)
                .map(n -> (int) Math.pow(2, n))
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Powers of 2: " + powersOfTwo);
    }

    // Scenario 45: Get the sum of even numbers in a list
    public void scenario45() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sumOfEvens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of Even Numbers: " + sumOfEvens);
    }

    // Scenario 46: Create a list of unique characters in a string
    public void scenario46() {
        String str = "hello world";
        List<Character> uniqueChars = str.chars()
                .distinct()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        System.out.println("Unique Characters: " + uniqueChars);
    }

    // Scenario 47: Find the frequency of each character in a string
    public void scenario47() {
        String str = "hello";
        Map<Character, Long> charFrequency = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Character Frequency: " + charFrequency);
    }

    // Scenario 48: Create a list of random integers within a range
    public void scenario48() {
        List<Integer> randomNumbers = new Random().ints(10, 1, 100)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Random Numbers in Range: " + randomNumbers);
    }

    // Scenario 49: Count the number of spaces in a string
    public void scenario49() {
        String str = "Hello World! This is Java.";
        long spaceCount = str.chars().filter(c -> c == ' ').count();
        System.out.println("Space Count: " + spaceCount);
    }

    // Scenario 50: Create a list of even numbers from a given list
    public void scenario50() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);
    }

    // Scenario 51: Convert a list of integers to their absolute values
    public void scenario51() {
        List<Integer> numbers = Arrays.asList(-1, -2, 3, -4, 5);
        List<Integer> absoluteValues = numbers.stream()
                .map(Math::abs)
                .collect(Collectors.toList());
        System.out.println("Absolute Values: " + absoluteValues);
    }

    // Scenario 52: Find the first character of each word in a sentence
    public void scenario52() {
        String sentence = "Java is awesome";
        List<Character> firstChars = Arrays.stream(sentence.split(" "))
                .map(word -> word.charAt(0))
                .collect(Collectors.toList());
        System.out.println("First Characters: " + firstChars);
    }

    // Scenario 53: Get the last character of a string
    public void scenario53() {
        String str = "Hello";
        char lastChar = str.charAt(str.length() - 1);
        System.out.println("Last Character: " + lastChar);
    }

    // Scenario 54: Create a list of all substrings of a string
    /*public void scenario54() {
        String str = "abc";
        List<String> substrings = IntStream.range(0, str.length())
                .flatMap(i -> IntStream.range(i + 1, str.length() + 1)
                        .map(j -> str.substring(i, j)))
                .collect(Collectors.toList());
        System.out.println("Substrings: " + substrings);
    }*/

    // Scenario 55: Check if a string contains only digits
    public void scenario55() {
        String str = "12345";
        boolean isDigitsOnly = str.chars().allMatch(Character::isDigit);
        System.out.println("Contains Only Digits: " + isDigitsOnly);
    }

    // Scenario 56: Remove all vowels from a string
    public void scenario56() {
        String str = "Hello World";
        String withoutVowels = str.replaceAll("[aeiouAEIOU]", "");
        System.out.println("Without Vowels: " + withoutVowels);
    }

    // Scenario 57: Convert a list of strings to their lengths
    public void scenario57() {
        List<String> words = Arrays.asList("Java", "is", "fun");
        List<Integer> lengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Lengths: " + lengths);
    }

    // Scenario 58: Find the longest sentence in a list
    public void scenario58() {
        List<String> sentences = Arrays.asList("Hello World", "Java is great", "I love programming");
        Optional<String> longestSentence = sentences.stream()
                .max(Comparator.comparingInt(String::length));
        longestSentence.ifPresent(sentence -> System.out.println("Longest Sentence: " + sentence));
    }

    // Scenario 59: Count the number of lines in a string
    public void scenario59() {
        String text = "Line 1\nLine 2\nLine 3";
        long lineCount = Arrays.stream(text.split("\n")).count();
        System.out.println("Line Count: " + lineCount);
    }

    // Scenario 60: Get the unique words from a sentence
    public void scenario60() {
        String sentence = "Java is a programming language and Java is fun";
        List<String> uniqueWords = Arrays.stream(sentence.split(" "))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique Words: " + uniqueWords);
    }

    // Scenario 61: Get the first non-repeating character in a string
    public void scenario61() {
        String str = "swiss";
        Optional<Character> firstNonRepeat = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str.indexOf(c) == str.lastIndexOf(c))
                .findFirst();
        firstNonRepeat.ifPresent(c -> System.out.println("First Non-Repeating Character: " + c));
    }

    // Scenario 62: Group strings by their first character
    public void scenario62() {
        List<String> words = Arrays.asList("apple", "banana", "apricot", "blueberry");
        Map<Character, List<String>> groupedByFirstChar = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));
        System.out.println("Grouped by First Character: " + groupedByFirstChar);
    }

    // Scenario 63: Get the sum of the lengths of all words in a sentence
    public void scenario63() {
        String sentence = "Java is fun";
        int totalLength = Arrays.stream(sentence.split(" "))
                .mapToInt(String::length)
                .sum();
        System.out.println("Total Length of Words: " + totalLength);
    }

    // Scenario 64: Find the second smallest number in a list
    public void scenario64() {
        List<Integer> numbers = Arrays.asList(5, 1, 3, 4, 2);
        Optional<Integer> secondSmallest = numbers.stream()
                .sorted()
                .distinct()
                .skip(1)
                .findFirst();
        secondSmallest.ifPresent(num -> System.out.println("Second Smallest Number: " + num));
    }

    // Scenario 65: Create a list of cubes of numbers
    public void scenario65() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> cubes = numbers.stream()
                .map(n -> n * n * n)
                .collect(Collectors.toList());
        System.out.println("Cubes: " + cubes);
    }

    // Scenario 66: Create a list of squares of even numbers
    public void scenario66() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares of Even Numbers: " + evenSquares);
    }

    // Scenario 67: Check if a string starts with a given prefix
    public void scenario67() {
        String str = "Java Programming";
        boolean startsWithJava = str.startsWith("Java");
        System.out.println("Starts with 'Java': " + startsWithJava);
    }

    // Scenario 68: Create a map of word frequencies
    public void scenario68() {
        String sentence = "Java is a programming language and Java is fun";
        Map<String, Long> wordFreq = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Word Frequencies: " + wordFreq);
    }

    // Scenario 69: Create a list of all possible pairs from two lists
    public void scenario69() {
        List<String> list1 = Arrays.asList("A", "B");
        List<String> list2 = Arrays.asList("1", "2");
        List<String> pairs = list1.stream()
                .flatMap(a -> list2.stream().map(b -> a + b))
                .collect(Collectors.toList());
        System.out.println("Pairs: " + pairs);
    }

    // Scenario 70: Convert a string to a char array
    public void scenario70() {
        String str = "Hello";
        char[] charArray = str.toCharArray();
        System.out.println("Character Array: " + Arrays.toString(charArray));
    }

    // Scenario 71: Get a sublist from a list
    public void scenario71() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        List<String> sublist = names.subList(1, 3);
        System.out.println("Sublist: " + sublist);
    }

    // Scenario 72: Check if a number is a perfect square
    public void scenario72() {
        int number = 16;
        boolean isPerfectSquare = Math.sqrt(number) % 1 == 0;
        System.out.println("Is Perfect Square: " + isPerfectSquare);
    }

    // Scenario 73: Find the longest word in a list
    public void scenario73() {
        List<String> words = Arrays.asList("Java", "Python", "JavaScript");
        Optional<String> longestWord = words.stream()
                .max(Comparator.comparingInt(String::length));
        longestWord.ifPresent(word -> System.out.println("Longest Word: " + word));
    }

    // Scenario 74: Find all unique letters in a string
    public void scenario74() {
        String str = "hello";
        Set<Character> uniqueLetters = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        System.out.println("Unique Letters: " + uniqueLetters);
    }

    // Scenario 75: Create a map of name lengths
    public void scenario75() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        Map<String, Integer> nameLengthMap = names.stream()
                .collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("Name Length Map: " + nameLengthMap);
    }

    // Scenario 76: Check if a string ends with a given suffix
    public void scenario76() {
        String str = "Hello World";
        boolean endsWithWorld = str.endsWith("World");
        System.out.println("Ends with 'World': " + endsWithWorld);
    }

    // Scenario 77: Find the common elements between two lists
    public void scenario77() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(2, 3, 4);
        List<Integer> commonElements = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
        System.out.println("Common Elements: " + commonElements);
    }

    // Scenario 78: Get a list of characters from a string
    public void scenario78() {
        String str = "Hello";
        List<Character> characters = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        System.out.println("Characters: " + characters);
    }

    // Scenario 79: Count the number of vowels in a string
    public void scenario79() {
        String str = "Hello World";
        long vowelCount = str.chars().filter(c -> "aeiouAEIOU".indexOf(c) >= 0).count();
        System.out.println("Vowel Count: " + vowelCount);
    }

    // Scenario 80: Count the number of consonants in a string
    public void scenario80() {
        String str = "Hello World";
        long consonantCount = str.chars().filter(c -> "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) >= 0).count();
        System.out.println("Consonant Count: " + consonantCount);
    }

    // Scenario 81: Get the last n elements of a list
    public void scenario81() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        int n = 2;
        List<String> lastN = names.stream()
                .skip(Math.max(0, names.size() - n))
                .collect(Collectors.toList());
        System.out.println("Last " + n + " Names: " + lastN);
    }

    // Scenario 82: Convert a string to title case
    public void scenario82() {
        String str = "java programming language";
        String titleCase = Arrays.stream(str.split(" "))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
        System.out.println("Title Case: " + titleCase);
    }

    // Scenario 83: Check if a string contains a given substring
    public void scenario83() {
        String str = "Hello World";
        boolean containsHello = str.contains("Hello");
        System.out.println("Contains 'Hello': " + containsHello);
    }

    // Scenario 84: Create a list of numbers from a given range
    public void scenario84() {
        List<Integer> numbersInRange = IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Numbers in Range: " + numbersInRange);
    }

    // Scenario 85: Create a list of odd numbers from a given list
    public void scenario85() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
        System.out.println("Odd Numbers: " + oddNumbers);
    }

    // Scenario 86: Find the median of a list of numbers
    public void scenario86() {
        List<Double> numbers = Arrays.asList(1.0, 3.0, 2.0, 4.0);
        List<Double> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        double median;
        if (sortedNumbers.size() % 2 == 0) {
            median = (sortedNumbers.get(sortedNumbers.size() / 2 - 1) + sortedNumbers.get(sortedNumbers.size() / 2)) / 2;
        } else {
            median = sortedNumbers.get(sortedNumbers.size() / 2);
        }
        System.out.println("Median: " + median);
    }

    // Scenario 87: Check if a string is a pangram
    public void scenario87() {
        String str = "The quick brown fox jumps over the lazy dog";
        boolean isPangram = str.chars().distinct().filter(c -> Character.isLetter(c)).count() == 26;
        System.out.println("Is Pangram: " + isPangram);
    }

    // Scenario 88: Create a frequency map of digits in a string
    public void scenario88() {
        String str = "1234567890123";
        Map<Character, Long> digitFrequency = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Digit Frequency: " + digitFrequency);
    }

    // Scenario 89: Create a map of character frequencies from a string
    public void scenario89() {
        String str = "hello";
        Map<Character, Long> charFrequency = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Character Frequency: " + charFrequency);
    }

    // Scenario 90: Count the number of unique elements in a list
    public void scenario90() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 2, 3);
        long uniqueCount = numbers.stream().distinct().count();
        System.out.println("Unique Count: " + uniqueCount);
    }

    // Scenario 91: Find the first unique word in a sentence
    public void scenario91() {
        String sentence = "Java is fun and Java is powerful";
        Optional<String> firstUniqueWord = Arrays.stream(sentence.split(" "))
                .filter(word -> Arrays.stream(sentence.split(" ")).filter(w -> w.equals(word)).count() == 1)
                .findFirst();
        firstUniqueWord.ifPresent(word -> System.out.println("First Unique Word: " + word));
    }

    // Scenario 92: Get the average of numbers in a list
    public void scenario92() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average: " + average);
    }

    // Scenario 93: Get the sum of all characters in a string
    public void scenario93() {
        String str = "Hello";
        int sumOfChars = str.chars().sum();
        System.out.println("Sum of Characters: " + sumOfChars);
    }

    // Scenario 94: Get the sum of the squares of a list of numbers
    public void scenario94() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int sumOfSquares = numbers.stream()
                .map(n -> n * n)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of Squares: " + sumOfSquares);
    }

    // Scenario 95: Find the last non-repeating character in a string
    public void scenario95() {
        String str = "swiss";
        Optional<Character> lastNonRepeat = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> str.indexOf(c) == str.lastIndexOf(c))
                .reduce((first, second) -> second);
        lastNonRepeat.ifPresent(c -> System.out.println("Last Non-Repeating Character: " + c));
    }

    // Scenario 96: Find the longest substring without repeating characters
    public void scenario96() {
        String str = "abcabcbb";
        String longestSubstring = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                if (substring.chars().distinct().count() == substring.length() && substring.length() > longestSubstring.length()) {
                    longestSubstring = substring;
                }
            }
        }
        System.out.println("Longest Substring Without Repeating Characters: " + longestSubstring);
    }

    // Scenario 97: Find the first missing positive integer in an array
    public void scenario97() {
        int[] nums = {3, 4, -1, 1};
        int n = nums.length;
        boolean[] seen = new boolean[n + 1];
        for (int num : nums) {
            if (num > 0 && num <= n) {
                seen[num] = true;
            }
        }
        int missing = -1;
        for (int i = 1; i <= n; i++) {
            if (!seen[i]) {
                missing = i;
                break;
            }
        }
        System.out.println("First Missing Positive Integer: " + missing);
    }

    // Scenario 98: Count the number of set bits in an integer
    public void scenario98() {
        int number = 29; // Binary: 11101
        int setBitsCount = Integer.bitCount(number);
        System.out.println("Set Bits Count: " + setBitsCount);
    }

    // Scenario 99: Check if a string is a valid number
    public void scenario99() {
        String str = "123.45";
        boolean isValidNumber = str.matches("-?\\d+(\\.\\d+)?");
        System.out.println("Is Valid Number: " + isValidNumber);
    }

    // Scenario 100: Check if a string is a valid email
    public void scenario100() {
        String email = "test@example.com";
        boolean isValidEmail = email.matches("^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$");
        System.out.println("Is Valid Email: " + isValidEmail);
    }

    public static void main(String[] args) {
        Java8Scenarios1 scenarios = new Java8Scenarios1();
        // You can call any scenario method here
        scenarios.scenario1();
        // Call other scenarios as needed...
    }
}
