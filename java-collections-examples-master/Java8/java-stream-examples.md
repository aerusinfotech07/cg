# Data Set
```java
    private List<Footballer> getFootballers() {
        return List.of(
                new Footballer("Messi", 32, Gender.MALE, List.of("CF","CAM", "RF")),
                new Footballer("Griezmann", 28, Gender.MALE, List.of("CF", "CAM", "LF")),
                new Footballer("Arthur", 23, Gender.MALE, List.of("CM", "CAM")),
                new Footballer("Ter Stegen", 27, Gender.MALE, List.of("GK")),
                new Footballer("Puig", 20, Gender.MALE, List.of("CM", "CDM")),
                new Footballer("Jennifer", 29, Gender.FEMALE, List.of("CF", "CAM")),
                new Footballer("Jana", 17, Gender.FEMALE, List.of("CB")),
                new Footballer("Alexia", 25, Gender.FEMALE, List.of("CAM", "RF", "LF"))
        );
    }
```
# Intermediate Operations
1. [filter](#filter)
2. [map](#map)
3. [flatMap](#flatMap)
4. [distinct](#distinct)
5. [sorted](#sorted)
6. [peek](#peek)
7. [limit](#limit)
8. [skip](#skip)
9. [takeWhile](#take-while)
10. [dropWhile](#drop-while)

# Terminal Operations
1. [count](#count)
2. [forEach](#for-each)
3. [forEachOrdered](#for-each-ordered)
4. [toArray](#to-array)
5. [min](#min)
6. [max](#max)
7. [anyMatch](#any-match)
8. [allMatch](#all-match)
9. [noneMatch](#none-match)
10. [findFirst](#find-first)
11. [findAny](#find-any)
12. [reduce](#reduce)
13. [collect](#collect)

# Filter
The ‘filter’ method is used to eliminate elements based on a criteria.
```java
        List<Footballer> collect = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.FEMALE))
                .filter(footballer -> footballer.getAge() > 23)
                .collect(Collectors.toList());
                
                //List collect contains -
                //{name='Jennifer', age=29, gender=FEMALE, positions=[CF, CAM]} &
                //{name='Alexia', age=25, gender=FEMALE, positions=[CAM, RF, LF]}
```
# Map
map() produces a new stream after applying a function to each element of the original stream. The new stream could be of different type.
```java
        long femalesMoreThan24y= footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.FEMALE))
                .map(Footballer::getAge)
                .filter(age -> age > 24)
                .count();

        System.out.println("femalesMoreThan24y = " + femalesMoreThan24y);
        //prints femalesMoreThan24y = 2
```
# FlatMap
A stream can hold complex data structures like Stream<List<String>>. In cases like this, flatMap() helps us to flatten the data structure to simplify further operations.
```java
        String allPositionsOfMaleLessThan30y = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.MALE))
                .filter(footballer -> footballer.getAge() < 30)
                .map(Footballer::getPositions)
                .flatMap(Collection::stream)
                .collect(Collectors.joining(","));

        System.out.println("allPositionsOfMaleLessThan30y = " + allPositionsOfMaleLessThan30y);
        //prints allPositionsOfMaleLessThan30y = CF,CAM,LF,CM,CAM,GK,CM,CDM
```
# Distinct
Returns distinct elements in the stream, eliminating duplicates. It uses the equals() method of the elements to decide whether two elements are equal or not.
```java
        String allUniquePositionsOfMaleLessThan30y = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.MALE))
                .filter(footballer -> footballer.getAge() < 30)
                .map(Footballer::getPositions)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.joining(","));

        System.out.println("allUniquePositionsOfMaleLessThan30y = " + allUniquePositionsOfMaleLessThan30y);
        //prints allUniquePositionsOfMaleLessThan30y = CF,CAM,LF,CM,GK,CDM
```
# Sorted
The ‘sorted’ method is used to sort the stream.
```java
        List<Footballer>  sortByGenderAndName= footballerList.stream()
                .sorted(Comparator.comparing(Footballer::getGender).thenComparing(Footballer::getName))
                .collect(Collectors.toList());

        System.out.println("sortByGenderAndName = " + sortByGenderAndName);
        
        //prints (prettified) sortByGenderAndName = [
//Footballer{name='Arthur', age=23, gender=MALE, positions=[CM, CAM]}, 
//Footballer{name='Griezmann', age=28, gender=MALE, positions=[CF, CAM, LF]}, 
//Footballer{name='Messi', age=32, gender=MALE, positions=[CF, CAM, RF]}, 
//Footballer{name='Puig', age=20, gender=MALE, positions=[CM, CDM]}, 
//Footballer{name='Ter Stegen', age=27, gender=MALE, positions=[GK]},
//Footballer{name='Alexia', age=25, gender=FEMALE, positions=[CAM, RF, LF]}, 
//Footballer{name='Jana', age=17, gender=FEMALE, positions=[CB]}, 
//Footballer{name='Jennifer', age=29, gender=FEMALE, positions=[CF, CAM]}, 
//]
```
# Peek
It performs the specified operation on each element of the stream and returns a new stream which can be used further.
```java        
        long malePlayerCount = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.MALE))
                .sorted(Comparator.comparing(Footballer::getAge))
                .peek(footballer -> {
                    System.out.println("footballer = " + footballer);
                })
                .count();

        System.out.println("malePlayerCount = " + malePlayerCount);
//        prints
//        footballer = Footballer{name='Puig', age=20, gender=MALE, positions=[CM, CDM]}
//        footballer = Footballer{name='Arthur', age=23, gender=MALE, positions=[CM, CAM]}
//        footballer = Footballer{name='Ter Stegen', age=27, gender=MALE, positions=[GK]}
//        footballer = Footballer{name='Griezmann', age=28, gender=MALE, positions=[CF, CAM, LF]}
//        footballer = Footballer{name='Messi', age=32, gender=MALE, positions=[CF, CAM, RF]}
//        malePlayerCount = 5
```
# Limit
The ‘limit’ method is used to reduce the size of the stream.
```java
        List<Footballer> twoMaleFootballers = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.MALE))
                .limit(2)
                .collect(Collectors.toList());
                //prints 
                //twoMaleFootballers = [Footballer{name='Messi', age=32, gender=MALE, positions=[CF, CAM, RF]}, Footballer{name='Griezmann', age=28, gender=MALE, positions=[CF, CAM, LF]}]

```
# Skip
```java
        List<Footballer>  sortByGenderAndNameSkipping5= footballerList.stream()
                .sorted(Comparator.comparing(Footballer::getGender).thenComparing(Footballer::getName))
                .skip(5)
                .collect(Collectors.toList());
                //prints (prettified)
                //sortByGenderAndNameSkipping5 = [
                //Footballer{name='Alexia', age=25, gender=FEMALE, positions=[CAM, RF, LF]}, 
                //Footballer{name='Jana', age=17, gender=FEMALE, positions=[CB]}, 
                //Footballer{name='Jennifer', age=29, gender=FEMALE, positions=[CF, CAM]}]
                //Note : See the above mentioned Sorted example for comparison


```
# Take While
```
        //Normal Filter
        List<Integer> filteredList = Stream.of(2, 4, 6, 8, 9, 10, 11, 12)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("filteredList = " + filteredList);
        //prints filteredList = [2, 4, 6, 8, 10, 12]

        //Take, While ...
        List<Integer> takeAWhile = Stream.of(2, 4, 6, 8, 9, 10, 11, 12)
                .takeWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("takeAWhile = " + takeAWhile);
        //prints takeAWhile = [2, 4, 6, 8]

```
# Drop While
```
        List<Integer> dropWhile = Stream.of(2, 4, 6, 8, 9, 10, 11, 12)
                .dropWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("dropWhile = " + dropWhile);
        //prints dropWhile = [9, 10, 11, 12]
```
# Count
```java
        long femalesMoreThan24y= footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.FEMALE))
                .map(Footballer::getAge)
                .filter(age -> age > 24)
                .count();

        System.out.println("femalesMoreThan24y = " + femalesMoreThan24y);
        //prints femalesMoreThan24y = 2
```
# For Each
It loops over the stream elements, calling the supplied function on each element.
```java
        List.of(4,1,6,7,19,2,3,81,64).stream()
                .parallel()
                .filter(number -> number<65)
                .forEach(number -> System.out.println("number = " + number));
                //prints
                //forEach
                //number = 2
                //number = 19
                //number = 3
                //number = 4
                //number = 6
                //number = 7
                //number = 1
                //number = 64
```
# For Each Ordered
```java
List.of(4,1,6,7,19,2,3,81,64).stream()
                .parallel()
                .filter(number -> number<65)
                .forEachOrdered(number -> System.out.println("number = " + number));
                //prints
                //forEach
                //number = 4
                //number = 1
                //number = 6
                //number = 7
                //number = 19
                //number = 2
                //number = 3
                //number = 64
```
# To Array
If we need to get an array out of the stream, we can simply use toArray().
```java
        Footballer[] femaleFootballers = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.FEMALE))
                .toArray(Footballer[]::new);

        System.out.println("femaleFootballers = " + Arrays.asList(femaleFootballers));
        //prints To Array femaleFootballers = [Footballer{name='Jennifer', age=29, gender=FEMALE, positions=[CF, CAM]}, Footballer{name='Jana', age=17, gender=FEMALE, positions=[CB]}, Footballer{name='Alexia', age=25, gender=FEMALE, positions=[CAM, RF, LF]}]

```
# Min
Returns the minimum element in the stream.
```java
        Integer minAge = footballerList.stream()
                .min(Comparator.comparing(Footballer::getAge))
                .map(Footballer::getAge)
                .get();

        System.out.println("min age = " + minAge);
        //prints min age = 17
```
# Max
Returns the maximum element in the stream.
```java
        Integer maxAge = footballerList.stream()
                .max(Comparator.comparing(Footballer::getAge))
                .map(Footballer::getAge)
                .get();

        System.out.println("max age = " + maxAge);
        //prints max age = 32
```
# Any Match
anyMatch() checks if the predicate is true for any one element in the stream.
```java
        boolean anyMatch = footballerList
                .stream()
                .anyMatch(footballer -> footballer.getAge() > 25);
        System.out.println("anyMatch = " + anyMatch);
        
        //prints anyMatch = true
```
# All Match
allMatch() checks if the predicate is true for all the elements in the stream. 
```java
        boolean allMatch = footballerList.stream()
                .allMatch(footballer -> footballer.getAge() > 25);
        System.out.println("allMatch = " + allMatch);
        
        //prints allMatch = false
```
# None Match
noneMatch() checks if there are no elements matching the predicate. 
```java
        boolean noneMatch = footballerList.stream()
                .noneMatch(footballer -> footballer.getAge() > 100);
        System.out.println("noneMatch = " + noneMatch);
        //prints noneMatch = true
```
# Find First
findFirst() returns an Optional for the first entry in the stream; the Optional can, of course, be empty.
```java
        Integer findFirst = List.of(4, 1, 3, 7, 5, 6, 2, 28, 15, 29)
                .parallelStream()
                .filter(number -> number > 5)
                .findFirst()
                .get();

        System.out.println("findFirst = " + findFirst);
        //prints findFirst = 7
```
# Find Any
```java
        Integer findAny = List.of(4, 1, 3, 7, 5, 6, 2, 28, 15, 29)
                .parallelStream()
                .filter(number -> number > 5)
                .findAny()
                .get();

        System.out.println("findAny = " + findAny);
        //prints findAny = 28
```
# Reduce
```java
        Optional<String> longestName = footballerList.stream()
                .map(Footballer::getName)
                .reduce((name1, name2)
                        -> name1.length() > name2.length()
                        ? name1 : name2);

        longestName.ifPresent(System.out::println);
        //prints Ter Stegen
```
# Collect
```java
        List<Footballer> collect = footballerList.stream()
                .filter(footballer -> footballer.getGender().equals(Gender.FEMALE))
                .filter(footballer -> footballer.getAge() > 23)
                .collect(Collectors.toList());
                
                //List collect contains -
                //{name='Jennifer', age=29, gender=FEMALE, positions=[CF, CAM]} &
                //{name='Alexia', age=25, gender=FEMALE, positions=[CAM, RF, LF]}
```
## Reference
1. [Stackify](https://stackify.com/streams-guide-java-8/)
2. [Advanced Java Programming](https://www.rokomari.com/book/179965/advanced-java-programing)