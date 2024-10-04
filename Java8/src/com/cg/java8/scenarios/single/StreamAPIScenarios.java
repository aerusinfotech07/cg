package com.cg.java8.scenarios.single;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIScenarios {

    public static void main(String[] args) {
        StreamAPIScenarios scenarios = new StreamAPIScenarios();
        scenarios.runAllScenarios();
    }

    public void runAllScenarios() {
        scenario1(); // Filtering even numbers
        scenario2(); // Mapping to string lengths
        scenario3(); // Sorting names
        scenario4(); // Reducing to sum
        scenario5(); // Collecting to comma-separated string
        scenario6(); // Grouping by age
        scenario7(); // Finding maximum age
        scenario8(); // Getting distinct ages
        scenario9(); // Average name length for names starting with 'A'
        scenario10(); // Parallel processing for squares

        // Continue to fill in the rest...
        for (int i = 11; i <= 100; i++) {
            try {
                getClass().getDeclaredMethod("scenario" + i).invoke(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Scenario 1: Filter even numbers
    public void scenario1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even Numbers: " + evenNumbers);
    }

    // Scenario 2: Map strings to lengths
    public void scenario2() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<Integer> lengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("String Lengths: " + lengths);
    }

    // Scenario 3: Sort names
    public void scenario3() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted Names: " + sortedNames);
    }

    // Scenario 4: Sum of numbers
    public void scenario4() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
    }

    // Scenario 5: Collect names to a comma-separated string
    public void scenario5() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        String result = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Joined Names: " + result);
    }

    // Scenario 6: Group by age
    public void scenario6() {
        List<Person> people = Arrays.asList(new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 30));
        Map<Integer, List<Person>> groupedByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println("Grouped by Age: " + groupedByAge);
    }

    // Scenario 7: Find maximum age
    public void scenario7() {
        List<Person> people = Arrays.asList(new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));
        Optional<Person> oldest = people.stream()
                .max(Comparator.comparingInt(Person::getAge));
        oldest.ifPresent(person -> System.out.println("Oldest: " + person.getName()));
    }

    // Scenario 8: Distinct ages
    public void scenario8() {
        List<Person> people = Arrays.asList(new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 30));
        Set<Integer> distinctAges = people.stream()
                .map(Person::getAge)
                .distinct()
                .collect(Collectors.toSet());
        System.out.println("Distinct Ages: " + distinctAges);
    }

    // Scenario 9: Average length of names starting with 'A'
    public void scenario9() {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie");
        double averageLength = names.stream()
                .filter(name -> name.startsWith("A"))
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
        System.out.println("Average Length of Names Starting with 'A': " + averageLength);
    }

    // Scenario 10: Parallel processing for squares
    public void scenario10() {
        List<Integer> squares = IntStream.rangeClosed(1, 1000)
                .parallel()
                .map(n -> n * n)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Squares: " + squares);
    }

    // Scenario 11: Find all names with more than 3 characters
    public void scenario11() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        List<String> longNames = names.stream()
                .filter(name -> name.length() > 3)
                .collect(Collectors.toList());
        System.out.println("Names with more than 3 characters: " + longNames);
    }

    // Scenario 12: Map to uppercase
    public void scenario12() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> uppercased = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercased Words: " + uppercased);
    }

    // Scenario 13: Find first name starting with 'B'
    public void scenario13() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        Optional<String> firstB = names.stream()
                .filter(name -> name.startsWith("B"))
                .findFirst();
        firstB.ifPresent(name -> System.out.println("First name starting with 'B': " + name));
    }

    // Scenario 14: Count names with length > 4
    public void scenario14() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        long count = names.stream()
                .filter(name -> name.length() > 4)
                .count();
        System.out.println("Count of names with length > 4: " + count);
    }

    // Scenario 15: Flattening a list of lists
    public void scenario15() {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f")
        );
        List<String> flatList = listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened List: " + flatList);
    }

    // Scenario 16: Find the shortest name
    public void scenario16() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        Optional<String> shortest = names.stream()
                .min(Comparator.comparingInt(String::length));
        shortest.ifPresent(name -> System.out.println("Shortest Name: " + name));
    }

    // Scenario 17: Create a list of squares of even numbers
    public void scenario17() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> squaresOfEvens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares of Even Numbers: " + squaresOfEvens);
    }

    // Scenario 18: Convert list of integers to strings
    public void scenario18() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> numberStrings = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println("String Representation of Numbers: " + numberStrings);
    }

    // Scenario 19: Remove duplicates from a list
    public void scenario19() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct Numbers: " + distinctNumbers);
    }

    // Scenario 20: Sum of squares of the first 10 natural numbers
    public void scenario20() {
        int sumOfSquares = IntStream.rangeClosed(1, 10)
                .map(n -> n * n)
                .sum();
        System.out.println("Sum of Squares of First 10 Natural Numbers: " + sumOfSquares);
    }

    // Scenario 21: Create a map of names and their lengths
    public void scenario21() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        Map<String, Integer> nameLengthMap = names.stream()
                .collect(Collectors.toMap(name -> name, String::length));
        System.out.println("Name Length Map: " + nameLengthMap);
    }

    // Scenario 22: Create a list of people over 30
    public void scenario22() {
        List<Person> people = Arrays.asList(new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));
        List<Person> over30 = people.stream()
                .filter(p -> p.getAge() > 30)
                .collect(Collectors.toList());
        System.out.println("People over 30: " + over30);
    }

    // Scenario 23: Concatenate names with a separator
    public void scenario23() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        String concatenatedNames = names.stream()
                .collect(Collectors.joining(" | "));
        System.out.println("Concatenated Names: " + concatenatedNames);
    }

    // Scenario 24: Check if any name starts with 'C'
    public void scenario24() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        boolean anyStartsWithC = names.stream()
                .anyMatch(name -> name.startsWith("C"));
        System.out.println("Any name starts with 'C': " + anyStartsWithC);
    }

    // Scenario 25: Check if all names are longer than 2 characters
    public void scenario25() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        boolean allLongerThan2 = names.stream()
                .allMatch(name -> name.length() > 2);
        System.out.println("All names longer than 2 characters: " + allLongerThan2);
    }

    // Scenario 26: Check if no name contains 'Z'
    public void scenario26() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        boolean noneContainsZ = names.stream()
                .noneMatch(name -> name.contains("Z"));
        System.out.println("No name contains 'Z': " + noneContainsZ);
    }

    // Scenario 27: Convert a list of numbers to their string representation and back
    public void scenario27() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> convertedBack = numbers.stream()
                .map(String::valueOf)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println("Converted Back Numbers: " + convertedBack);
    }

    // Scenario 28: Find names containing 'a'
    public void scenario28() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        List<String> namesWithA = names.stream()
                .filter(name -> name.contains("a"))
                .collect(Collectors.toList());
        System.out.println("Names containing 'a': " + namesWithA);
    }

    // Scenario 29: Get the first three names
    public void scenario29() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        List<String> firstThree = names.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("First Three Names: " + firstThree);
    }

    // Scenario 30: Get names in reverse order
    public void scenario30() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        List<String> reversedNames = names.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Reversed Names: " + reversedNames);
    }

    // Scenario 31: Get the sum of lengths of all names
    public void scenario31() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        int totalLength = names.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("Total Length of All Names: " + totalLength);
    }

 // Scenario 32: Get names in uppercase and lowercase
    /*public void scenario32() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        List<String> upperLower = names.stream()
                .flatMap((Function<String, Stream<String>>) name -> Stream.of(name.toUpperCase(), name.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("Upper and Lower Names: " + upperLower);
    }
*/

    // Scenario 33: Get names with their index
    public void scenario33() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        List<String> indexedNames = IntStream.range(0, names.size())
                .mapToObj(i -> i + ": " + names.get(i))
                .collect(Collectors.toList());
        System.out.println("Names with Index: " + indexedNames);
    }

    // Scenario 34: Find the second largest number
    public void scenario34() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> secondLargest = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst();
        secondLargest.ifPresent(num -> System.out.println("Second Largest Number: " + num));
    }

    // Scenario 35: Get names sorted by length
    public void scenario35() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        List<String> sortedByLength = names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("Names Sorted by Length: " + sortedByLength);
    }

    // Scenario 36: Create a list of Person objects and sort by age
    public void scenario36() {
        List<Person> people = Arrays.asList(new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
        System.out.println("People Sorted by Age: " + sortedByAge);
    }

    // Scenario 37: Get a list of names sorted by last character
    public void scenario37() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        List<String> sortedByLastChar = names.stream()
                .sorted(Comparator.comparingInt(name -> name.charAt(name.length() - 1)))
                .collect(Collectors.toList());
        System.out.println("Names Sorted by Last Character: " + sortedByLastChar);
    }

    // Scenario 38: Create a map of age counts
    public void scenario38() {
        List<Person> people = Arrays.asList(new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 30));
        Map<Integer, Long> ageCounts = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        System.out.println("Age Counts: " + ageCounts);
    }

    // Scenario 39: Get the oldest and youngest person
    public void scenario39() {
        List<Person> people = Arrays.asList(new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));
        Optional<Person> oldest = people.stream().max(Comparator.comparingInt(Person::getAge));
        Optional<Person> youngest = people.stream().min(Comparator.comparingInt(Person::getAge));
        oldest.ifPresent(person -> System.out.println("Oldest: " + person.getName()));
        youngest.ifPresent(person -> System.out.println("Youngest: " + person.getName()));
    }

    // Scenario 40: Create a list of concatenated names with their ages
    public void scenario40() {
        List<Person> people = Arrays.asList(new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));
        List<String> nameWithAge = people.stream()
                .map(person -> person.getName() + " (" + person.getAge() + ")")
                .collect(Collectors.toList());
        System.out.println("Names with Ages: " + nameWithAge);
    }

    // Scenario 41: Count occurrences of characters in a string
    public void scenario41() {
        String input = "hello world";
        Map<Character, Long> charCount = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("Character Count: " + charCount);
    }

    // Scenario 42: Create a list of even squares
    public void scenario42() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Even Squares: " + evenSquares);
    }

    // Scenario 43: Get the first name that starts with 'A'
    public void scenario43() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        Optional<String> firstA = names.stream()
                .filter(name -> name.startsWith("A"))
                .findFirst();
        firstA.ifPresent(name -> System.out.println("First Name Starting with 'A': " + name));
    }

    // Scenario 44: Create a list of numbers and multiply them by 10
    public void scenario44() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> multipliedByTen = numbers.stream()
                .map(n -> n * 10)
                .collect(Collectors.toList());
        System.out.println("Numbers Multiplied by 10: " + multipliedByTen);
    }

    // Scenario 45: Create a list of unique letters from a string
    public void scenario45() {
        String input = "hello world";
        Set<Character> uniqueLetters = input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> Character.isLetter(c))
                .collect(Collectors.toSet());
        System.out.println("Unique Letters: " + uniqueLetters);
    }

    // Scenario 46: Find the first 5 prime numbers
    public void scenario46() {
        List<Integer> primes = IntStream.iterate(2, n -> n + 1)
                .filter(n -> isPrime(n))
                .limit(5)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("First 5 Prime Numbers: " + primes);
    }

    private boolean isPrime(int n) {
        return n > 1 && IntStream.range(2, (int) Math.sqrt(n) + 1).noneMatch(i -> n % i == 0);
    }

    // Scenario 47: Get names sorted by their length in reverse order
    public void scenario47() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        List<String> sortedByLengthReverse = names.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());
        System.out.println("Names Sorted by Length in Reverse Order: " + sortedByLengthReverse);
    }

    // Scenario 48: Filter names that start with a vowel
    public void scenario48() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        List<String> vowelNames = names.stream()
                .filter(name -> "AEIOUaeiou".indexOf(name.charAt(0)) >= 0)
                .collect(Collectors.toList());
        System.out.println("Names Starting with a Vowel: " + vowelNames);
    }

    // Scenario 49: Calculate the factorial of the first 5 numbers
    public void scenario49() {
        List<Integer> factorials = IntStream.rangeClosed(1, 5)
                .map(this::factorial)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Factorials of First 5 Numbers: " + factorials);
    }

    private int factorial(int n) {
        return (n == 0) ? 1 : n * factorial(n - 1);
    }

    // Scenario 50: Count the number of words in a sentence
    public void scenario50() {
        String sentence = "Hello world this is Java 8";
        long wordCount = Arrays.stream(sentence.split(" "))
                .count();
        System.out.println("Word Count: " + wordCount);
    }

    // Scenario 51: Filter numbers greater than 5
    public void scenario51() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> greaterThanFive = numbers.stream()
                .filter(n -> n > 5)
                .collect(Collectors.toList());
        System.out.println("Numbers Greater Than 5: " + greaterThanFive);
    }

    // Scenario 52: Get the square root of each number
    public void scenario52() {
        List<Integer> numbers = Arrays.asList(1, 4, 9, 16, 25);
        List<Double> squareRoots = numbers.stream()
                .map(Math::sqrt)
                .collect(Collectors.toList());
        System.out.println("Square Roots: " + squareRoots);
    }

    // Scenario 53: Find the longest name
    public void scenario53() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        Optional<String> longestName = names.stream()
                .max(Comparator.comparingInt(String::length));
        longestName.ifPresent(name -> System.out.println("Longest Name: " + name));
    }

    // Scenario 54: Check if all numbers are even
    public void scenario54() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8);
        boolean allEven = numbers.stream()
                .allMatch(n -> n % 2 == 0);
        System.out.println("All Numbers are Even: " + allEven);
    }

    // Scenario 55: Get the product of a list of numbers
    public void scenario55() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product of Numbers: " + product);
    }

    // Scenario 56: Check if a string is a palindrome
    public void scenario56() {
        String input = "madam";
        boolean isPalindrome = input.equals(new StringBuilder(input).reverse().toString());
        System.out.println("Is Palindrome: " + isPalindrome);
    }

    // Scenario 57: Create a list of random numbers
    public void scenario57() {
        List<Integer> randomNumbers = new Random().ints(10, 0, 100)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Random Numbers: " + randomNumbers);
    }

    // Scenario 58: Find the index of a specific element
    public void scenario58() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        int index = names.indexOf("Alice");
        System.out.println("Index of Alice: " + index);
    }

    // Scenario 59: Check if a name is present in a list
    public void scenario59() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        boolean containsAlice = names.contains("Alice");
        System.out.println("Contains Alice: " + containsAlice);
    }

    // Scenario 60: Find the average of a list of numbers
    public void scenario60() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
        System.out.println("Average: " + average);
    }

    // Scenario 61: Create a list of integers from a string of numbers
    public void scenario61() {
        String numberString = "1,2,3,4,5";
        List<Integer> numbers = Arrays.stream(numberString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("List of Integers: " + numbers);
    }

    // Scenario 62: Reverse a list
    public void scenario62() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        List<String> reversed = new ArrayList<>(names);
        Collections.reverse(reversed);
        System.out.println("Reversed List: " + reversed);
    }

    // Scenario 63: Calculate the difference between two lists
    public void scenario63() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
        List<Integer> difference = list1.stream()
                .filter(n -> !list2.contains(n))
                .collect(Collectors.toList());
        System.out.println("Difference between two lists: " + difference);
    }

    // Scenario 64: Get a list of odd numbers
    public void scenario64() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
        System.out.println("Odd Numbers: " + oddNumbers);
    }

    // Scenario 65: Create a list of Fibonacci numbers
    public void scenario65() {
        List<Integer> fibonacci = IntStream.iterate(0, n -> n + 1)
                .limit(10)
                .map(n -> fibonacci(n))
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Fibonacci Numbers: " + fibonacci);
    }

    private int fibonacci(int n) {
        return (n <= 1) ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Scenario 66: Get a list of uppercase letters from a string
    public void scenario66() {
        String input = "Hello World";
        List<Character> uppercaseLetters = input.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase Letters: " + uppercaseLetters);
    }

    // Scenario 67: Find the most frequent element in a list
    public void scenario67() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Alice", "Charlie", "Bob", "Alice");
        Map<String, Long> frequencyMap = names.stream()
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));
        String mostFrequent = frequencyMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println("Most Frequent Name: " + mostFrequent);
    }

    // Scenario 68: Count the number of vowels in a string
    public void scenario68() {
        String input = "Hello World";
        long vowelCount = input.chars()
                .filter(c -> "AEIOUaeiou".indexOf(c) != -1)
                .count();
        System.out.println("Number of Vowels: " + vowelCount);
    }

    // Scenario 69: Create a list of even numbers from a range
    public void scenario69() {
        List<Integer> evenNumbers = IntStream.rangeClosed(1, 20)
                .filter(n -> n % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Even Numbers from 1 to 20: " + evenNumbers);
    }

    // Scenario 70: Create a list of powers of 2
    public void scenario70() {
        List<Integer> powersOfTwo = IntStream.rangeClosed(0, 10)
                .map(n -> (int) Math.pow(2, n))
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Powers of 2: " + powersOfTwo);
    }

    // Scenario 71: Find the longest word in a sentence
    public void scenario71() {
        String sentence = "Hello world this is Java 8";
        String longestWord = Arrays.stream(sentence.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("Longest Word: " + longestWord);
    }

    // Scenario 72: Check if all words in a sentence are unique
    public void scenario72() {
        String sentence = "Hello world this is Java Java";
        long uniqueWords = Arrays.stream(sentence.split(" "))
                .distinct()
                .count();
        boolean allUnique = uniqueWords == Arrays.stream(sentence.split(" ")).count();
        System.out.println("All Words Unique: " + allUnique);
    }

    // Scenario 73: Create a list of digits from a string
    public void scenario73() {
        String input = "Hello123World456";
        List<Character> digits = input.chars()
                .mapToObj(c -> (char) c)
                .filter(Character::isDigit)
                .collect(Collectors.toList());
        System.out.println("Digits in String: " + digits);
    }

    // Scenario 74: Check if a number is Armstrong
    public void scenario74() {
        int number = 153;
        boolean isArmstrong = isArmstrong(number);
        System.out.println("Is Armstrong Number: " + isArmstrong);
    }

    private boolean isArmstrong(int number) {
        int sum = 0, temp = number, digits = String.valueOf(number).length();
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }
        return sum == number;
    }

    // Scenario 75: Create a list of palindromes from a list of strings
    public void scenario75() {
        List<String> words = Arrays.asList("madam", "racecar", "hello", "world", "level");
        List<String> palindromes = words.stream()
                .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                .collect(Collectors.toList());
        System.out.println("Palindromes: " + palindromes);
    }

    // Scenario 76: Get the second smallest number
    public void scenario76() {
        List<Integer> numbers = Arrays.asList(4, 3, 1, 2, 5);
        Optional<Integer> secondSmallest = numbers.stream()
                .sorted()
                .distinct()
                .skip(1)
                .findFirst();
        secondSmallest.ifPresent(num -> System.out.println("Second Smallest Number: " + num));
    }

    // Scenario 77: Count the number of consonants in a string
    public void scenario77() {
        String input = "Hello World";
        long consonantCount = input.chars()
                .filter(c -> Character.isLetter(c) && "AEIOUaeiou".indexOf(c) == -1)
                .count();
        System.out.println("Number of Consonants: " + consonantCount);
    }

    // Scenario 78: Create a list of unique elements from two lists
    public void scenario78() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
        List<Integer> uniqueElements = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique Elements from Both Lists: " + uniqueElements);
    }

    // Scenario 79: Get a list of multiples of 3 from a range
    public void scenario79() {
        List<Integer> multiplesOfThree = IntStream.rangeClosed(1, 30)
                .filter(n -> n % 3 == 0)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Multiples of 3 from 1 to 30: " + multiplesOfThree);
    }

    // Scenario 80: Create a list of squares of even numbers
    public void scenario80() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squares of Even Numbers: " + evenSquares);
    }

    // Scenario 81: Find the average length of names
    public void scenario81() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        double averageLength = names.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);
        System.out.println("Average Length of Names: " + averageLength);
    }

    // Scenario 82: Create a list of integers from a comma-separated string
    public void scenario82() {
        String numberString = "10,20,30,40,50";
        List<Integer> numbers = Arrays.stream(numberString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("List of Integers: " + numbers);
    }

    // Scenario 83: Count the number of occurrences of a specific word in a sentence
    public void scenario83() {
        String sentence = "Java is fun. Java is powerful. Java is everywhere.";
        long count = Arrays.stream(sentence.split("\\W+"))
                .filter(word -> word.equalsIgnoreCase("Java"))
                .count();
        System.out.println("Occurrences of 'Java': " + count);
    }

    // Scenario 84: Create a list of powers of 3
    public void scenario84() {
        List<Integer> powersOfThree = IntStream.rangeClosed(0, 10)
                .map(n -> (int) Math.pow(3, n))
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Powers of 3: " + powersOfThree);
    }

    // Scenario 85: Create a list of numbers as strings
    public void scenario85() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> numbersAsStrings = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println("Numbers as Strings: " + numbersAsStrings);
    }

    // Scenario 86: Get the last three elements of a list
    public void scenario86() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");
        List<String> lastThree = names.stream()
                .skip(Math.max(0, names.size() - 3))
                .collect(Collectors.toList());
        System.out.println("Last Three Names: " + lastThree);
    }

    // Scenario 87: Check if a number is even or odd
    public void scenario87() {
        int number = 4;
        String result = (number % 2 == 0) ? "Even" : "Odd";
        System.out.println("The number is: " + result);
    }

    // Scenario 88: Get a list of cubes of numbers
    public void scenario88() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> cubes = numbers.stream()
                .map(n -> n * n * n)
                .collect(Collectors.toList());
        System.out.println("Cubes of Numbers: " + cubes);
    }

    // Scenario 89: Find the sum of squares of even numbers
    public void scenario89() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sumOfSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println("Sum of Squares of Even Numbers: " + sumOfSquares);
    }

    // Scenario 90: Check if a string contains a specific substring
    public void scenario90() {
        String input = "Hello World";
        boolean contains = input.contains("World");
        System.out.println("Contains 'World': " + contains);
    }

    // Scenario 91: Get the sum of all digits in a number
    public void scenario91() {
        int number = 12345;
        int sumOfDigits = String.valueOf(number).chars()
                .map(Character::getNumericValue)
                .sum();
        System.out.println("Sum of Digits: " + sumOfDigits);
    }

    // Scenario 92: Convert a string to uppercase
    public void scenario92() {
        String input = "Hello World";
        String uppercased = input.toUpperCase();
        System.out.println("Uppercased String: " + uppercased);
    }

    // Scenario 93: Create a list of random integers
    public void scenario93() {
        List<Integer> randomNumbers = new Random().ints(10, 1, 100)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Random Integers: " + randomNumbers);
    }

    // Scenario 94: Get the maximum number from a list
    public void scenario94() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> maxNumber = numbers.stream()
                .max(Integer::compareTo);
        maxNumber.ifPresent(num -> System.out.println("Maximum Number: " + num));
    }

    // Scenario 95: Create a list of elements that are not in the second list
    public void scenario95() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
        List<Integer> notInSecondList = list1.stream()
                .filter(n -> !list2.contains(n))
                .collect(Collectors.toList());
        System.out.println("Elements in List 1 but not in List 2: " + notInSecondList);
    }

    // Scenario 96: Count the number of spaces in a string
    public void scenario96() {
        String input = "Hello World, this is Java.";
        long spaceCount = input.chars()
                .filter(c -> c == ' ')
                .count();
        System.out.println("Number of Spaces: " + spaceCount);
    }

    // Scenario 97: Find the first non-repeated character in a string
    public void scenario97() {
        String input = "swiss";
        Optional<Character> firstNonRepeated = input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> input.indexOf(c) == input.lastIndexOf(c))
                .findFirst();
        firstNonRepeated.ifPresent(c -> System.out.println("First Non-Repeated Character: " + c));
    }

    // Scenario 98: Convert a list of strings to uppercase
    public void scenario98() {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        List<String> uppercasedNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercased Names: " + uppercasedNames);
    }

    // Scenario 99: Create a list of characters from a string
    public void scenario99() {
        String input = "Hello";
        List<Character> characters = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        System.out.println("Characters in String: " + characters);
    }

    // Scenario 100: Check if two strings are anagrams
    public void scenario100() {
        String str1 = "listen";
        String str2 = "silent";
        boolean isAnagram = isAnagram(str1, str2);
        System.out.println("Are Anagrams: " + isAnagram);
    }

    private boolean isAnagram(String str1, String str2) {
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }
}
