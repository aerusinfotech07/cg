package com.cg.java8.scenarios.book;

import java.util.*;
import java.util.stream.Collectors;





public class BookExample {

    private List<Book> getBooks() {
        return Arrays.asList(
                new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, Genre.FICTION, 8.5),
                new Book("1984", "George Orwell", 1949, Genre.FICTION, 9.0),
                new Book("To Kill a Mockingbird", "Harper Lee", 1960, Genre.FICTION, 9.2),
                new Book("A Brief History of Time", "Stephen Hawking", 1988, Genre.NON_FICTION, 8.6),
                new Book("The Catcher in the Rye", "J.D. Salinger", 1951, Genre.FICTION, 7.5),
                new Book("The Hobbit", "J.R.R. Tolkien", 1937, Genre.FANTASY, 9.1),
                new Book("The Da Vinci Code", "Dan Brown", 2003, Genre.MYSTERY, 6.4),
                new Book("Sapiens", "Yuval Noah Harari", 2011, Genre.NON_FICTION, 9.0),
                new Book("The Silent Patient", "Alex Michaelides", 2019, Genre.MYSTERY, 8.0),
                new Book("Dune", "Frank Herbert", 1965, Genre.SCIFI, 8.8),
                new Book("Becoming", "Michelle Obama", 2018, Genre.BIOGRAPHY, 9.5),
                new Book("The Alchemist", "Paulo Coelho", 1988, Genre.FICTION, 8.5),
                new Book("The Subtle Art of Not Giving a F*ck", "Mark Manson", 2016, Genre.NON_FICTION, 8.3),
                new Book("Gone Girl", "Gillian Flynn", 2012, Genre.MYSTERY, 8.1),
                new Book("Fahrenheit 451", "Ray Bradbury", 1953, Genre.SCIFI, 8.4),
                new Book("Pride and Prejudice", "Jane Austen", 1813, Genre.FICTION, 8.7)
        );
    }

    public void runExamples() {
        List<Book> bookList = getBooks();

        // 1. Filter: Find all books published after 1950
        List<Book> booksAfter1950 = bookList.stream()
                .filter(book -> book.getYear() > 1950)
                .collect(Collectors.toList());
        System.out.println("Books published after 1950: " + booksAfter1950);

        // 2. Map: Get a list of book titles
        List<String> bookTitles = bookList.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
        System.out.println("Book titles: " + bookTitles);

        // 3. Count: Count books with a rating above 8
        long countHighRated = bookList.stream()
                .filter(book -> book.getRating() > 8)
                .count();
        System.out.println("Count of books with rating above 8: " + countHighRated);

        // 4. Grouping: Count books by genre
        Map<Genre, Long> booksByGenre = bookList.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()));
        System.out.println("Count of books by genre: " + booksByGenre);
        
        
        // 5. Sorted: Sort books by rating in descending order
        List<Book> sortedByRating = bookList.stream()
                .sorted(Comparator.comparingDouble(Book::getRating).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Books sorted by rating (descending): " + sortedByRating);

        // 6. Peek: Print each book while counting them
        long totalBooks = bookList.stream()
                .peek(book -> System.out.println("Book: " + book))
                .count();
        System.out.println("Total number of books: " + totalBooks);

        // 7. Limit: Get the first 3 books
        List<Book> firstThreeBooks = bookList.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("First three books: " + firstThreeBooks);

        // 8. Skip: Skip the first 5 books
        List<Book> skippedBooks = bookList.stream()
                .skip(5)
                .collect(Collectors.toList());
        System.out.println("Books after skipping the first 5: " + skippedBooks);

        // 9. Take While: Take books until a certain condition fails (by rating)
        List<Book> takeWhileRatingAbove9 = bookList.stream()
                .takeWhile(book -> book.getRating() > 9)
                .collect(Collectors.toList());
        System.out.println("Books with rating above 9 (taking while): " + takeWhileRatingAbove9);

        // 10. Drop While: Drop books until a certain condition fails (by rating)
        List<Book> dropWhileRatingAbove8 = bookList.stream()
                .dropWhile(book -> book.getRating() > 8)
                .collect(Collectors.toList());
        System.out.println("Books after dropping while rating above 8: " + dropWhileRatingAbove8);

        // 11. Min: Get the book with the minimum rating
        Optional<Book> minRatedBook = bookList.stream()
                .min(Comparator.comparingDouble(Book::getRating));
        minRatedBook.ifPresent(book -> System.out.println("Minimum rated book: " + book));

        // 12. Max: Get the book with the maximum rating
        Optional<Book> maxRatedBook = bookList.stream()
                .max(Comparator.comparingDouble(Book::getRating));
        maxRatedBook.ifPresent(book -> System.out.println("Maximum rated book: " + book));

        // 13. Any Match: Check if any book is from the genre SCIFI
        boolean anyScifi = bookList.stream()
                .anyMatch(book -> book.getGenre() == Genre.SCIFI);
        System.out.println("Any SCIFI book: " + anyScifi);

        // 14. All Match: Check if all books are rated above 5
        boolean allRatedAbove5 = bookList.stream()
                .allMatch(book -> book.getRating() > 5);
        System.out.println("All books rated above 5: " + allRatedAbove5);

        // 15. None Match: Check if no book is rated below 5
        boolean noneRatedBelow5 = bookList.stream()
                .noneMatch(book -> book.getRating() < 5);
        System.out.println("No book rated below 5: " + noneRatedBelow5);

        // 16. Find First: Find the first book with a rating above 9
        Optional<Book> firstHighRatedBook = bookList.stream()
                .filter(book -> book.getRating() > 9)
                .findFirst();
        firstHighRatedBook.ifPresent(book -> System.out.println("First book with rating above 9: " + book));

        // 17. Find Any: Find any book published in the 2000s
        Optional<Book> anyBook2000s = bookList.stream()
                .filter(book -> book.getYear() >= 2000 && book.getYear() < 2010)
                .findAny();
        anyBook2000s.ifPresent(book -> System.out.println("Any book published in the 2000s: " + book));

        // 18. Reduce: Find the longest title
        Optional<String> longestTitle = bookList.stream()
                .map(Book::getTitle)
                .reduce((title1, title2) -> title1.length() > title2.length() ? title1 : title2);
        longestTitle.ifPresent(title -> System.out.println("Longest title: " + title));

        // 19. Collect: Gather books with rating above 8.5 into a list
        List<Book> highRatedBooks = bookList.stream()
                .filter(book -> book.getRating() > 8.5)
                .collect(Collectors.toList());
        System.out.println("Books with rating above 8.5: " + highRatedBooks);

        // 20. Grouping By Year: Group books by their publication year
        Map<Integer, List<Book>> booksByYear = bookList.stream()
                .collect(Collectors.groupingBy(Book::getYear));
        System.out.println("Books grouped by year: " + booksByYear);

        // 21. Joining: Join all book titles into a single string
        String allTitles = bookList.stream()
                .map(Book::getTitle)
                .collect(Collectors.joining(", "));
        System.out.println("All book titles: " + allTitles);

        // 22. FlatMap: Flatten a list of lists of books (for this example, simulating it)
        List<List<Book>> bookLists = List.of(
                bookList.subList(0, 5),
                bookList.subList(5, bookList.size())
        );
        List<Book> flattenedBooks = bookLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened list of books: " + flattenedBooks);

        // 23. Distinct: Get distinct genres from the books
        List<Genre> distinctGenres = bookList.stream()
                .map(Book::getGenre)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct genres: " + distinctGenres);

        // 24. Collecting to Set: Collect unique book authors
        Set<String> uniqueAuthors = bookList.stream()
                .map(Book::getAuthor)
                .collect(Collectors.toSet());
        System.out.println("Unique authors: " + uniqueAuthors);

        // 25. Filtering and Collecting: Collect books of a specific genre
        List<Book> fictionBooks = bookList.stream()
                .filter(book -> book.getGenre() == Genre.FICTION)
                .collect(Collectors.toList());
        System.out.println("Fiction books: " + fictionBooks);

        // 26. Average Rating: Calculate the average rating of all books
        OptionalDouble averageRating = bookList.stream()
                .mapToDouble(Book::getRating)
                .average();
        averageRating.ifPresent(avg -> System.out.println("Average rating: " + avg));

        // 27. Count by Rating Range: Count books within a specific rating range
        long countInRange = bookList.stream()
                .filter(book -> book.getRating() >= 8 && book.getRating() <= 9)
                .count();
        System.out.println("Count of books with rating between 8 and 9: " + countInRange);

        // 28. Mapping and Filtering: Get authors of books with rating > 8.5
        List<String> authorsHighRatedBooks = bookList.stream()
                .filter(book -> book.getRating() > 8.5)
                .map(Book::getAuthor)
                .collect(Collectors.toList());
        System.out.println("Authors of books with rating > 8.5: " + authorsHighRatedBooks);

        // 29. Grouping and Summing: Sum the ratings of all books by genre
        Map<Genre, Double> totalRatingsByGenre = bookList.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.summingDouble(Book::getRating)));
        System.out.println("Total ratings by genre: " + totalRatingsByGenre);

        // 30. Partitioning: Partition books into those rated above and below 8
        Map<Boolean, List<Book>> partitionedByRating = bookList.stream()
                .collect(Collectors.partitioningBy(book -> book.getRating() > 8));
        System.out.println("Books partitioned by rating > 8: " + partitionedByRating);
    }

    public static void main(String[] args) {
        BookExample example = new BookExample();
        example.runExamples();
    }
}
