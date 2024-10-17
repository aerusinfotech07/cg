package com.cg.java8.scenarios.book;
import java.util.*;
import java.util.stream.Collectors;

public class BookExampleWithoutCode {

    private List<Book> getBooks() {
        return List.of(
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

        // Call each scenario method
        findBooksPublishedAfter1950(bookList);
        getBookTitles(bookList);
        countHighRatedBooks(bookList);
        countBooksByGenre(bookList);
        sortBooksByRating(bookList);
        printEachBook(bookList);
        getFirstThreeBooks(bookList);
        skipFirstFiveBooks(bookList);
        takeWhileRatingAbove9(bookList);
        dropWhileRatingAbove8(bookList);
        getMinRatedBook(bookList);
        getMaxRatedBook(bookList);
        checkAnyScifiBook(bookList);
        checkAllRatedAbove5(bookList);
        checkNoneRatedBelow5(bookList);
        findFirstHighRatedBook(bookList);
        findAnyBook2000s(bookList);
        findLongestTitle(bookList);
        collectHighRatedBooks(bookList);
        groupBooksByYear(bookList);
        joinAllBookTitles(bookList);
        flattenBookLists(bookList);
        getDistinctGenres(bookList);
        collectUniqueAuthors(bookList);
        collectFictionBooks(bookList);
        calculateAverageRating(bookList);
        countBooksInRange(bookList);
        getAuthorsOfHighRatedBooks(bookList);
        sumRatingsByGenre(bookList);
        partitionBooksByRating(bookList);
    }

    // 1. Filter: Find all books published after 1950
    private void findBooksPublishedAfter1950(List<Book> bookList) {
        // Implementation here
    }

    // 2. Map: Get a list of book titles
    private void getBookTitles(List<Book> bookList) {
        // Implementation here
    }

    // 3. Count: Count books with a rating above 8
    private void countHighRatedBooks(List<Book> bookList) {
        // Implementation here
    }

    // 4. Grouping: Count books by genre
    private void countBooksByGenre(List<Book> bookList) {
        // Implementation here
    }

    // 5. Sorted: Sort books by rating in descending order
    private void sortBooksByRating(List<Book> bookList) {
        // Implementation here
    }

    // 6. Peek: Print each book while counting them
    private void printEachBook(List<Book> bookList) {
        // Implementation here
    }

    // 7. Limit: Get the first 3 books
    private void getFirstThreeBooks(List<Book> bookList) {
        // Implementation here
    }

    // 8. Skip: Skip the first 5 books
    private void skipFirstFiveBooks(List<Book> bookList) {
        // Implementation here
    }

    // 9. Take While: Take books until a certain condition fails (by rating)
    private void takeWhileRatingAbove9(List<Book> bookList) {
        // Implementation here
    }

    // 10. Drop While: Drop books until a certain condition fails (by rating)
    private void dropWhileRatingAbove8(List<Book> bookList) {
        // Implementation here
    }

    // 11. Min: Get the book with the minimum rating
    private void getMinRatedBook(List<Book> bookList) {
        // Implementation here
    }

    // 12. Max: Get the book with the maximum rating
    private void getMaxRatedBook(List<Book> bookList) {
        // Implementation here
    }

    // 13. Any Match: Check if any book is from the genre SCIFI
    private void checkAnyScifiBook(List<Book> bookList) {
        // Implementation here
    }

    // 14. All Match: Check if all books are rated above 5
    private void checkAllRatedAbove5(List<Book> bookList) {
        // Implementation here
    }

    // 15. None Match: Check if no book is rated below 5
    private void checkNoneRatedBelow5(List<Book> bookList) {
        // Implementation here
    }

    // 16. Find First: Find the first book with a rating above 9
    private void findFirstHighRatedBook(List<Book> bookList) {
        // Implementation here
    }

    // 17. Find Any: Find any book published in the 2000s
    private void findAnyBook2000s(List<Book> bookList) {
        // Implementation here
    }

    // 18. Reduce: Find the longest title
    private void findLongestTitle(List<Book> bookList) {
        // Implementation here
    }

    // 19. Collect: Gather books with rating above 8.5 into a list
    private void collectHighRatedBooks(List<Book> bookList) {
        // Implementation here
    }

    // 20. Grouping By Year: Group books by their publication year
    private void groupBooksByYear(List<Book> bookList) {
        // Implementation here
    }

    // 21. Joining: Join all book titles into a single string
    private void joinAllBookTitles(List<Book> bookList) {
        // Implementation here
    }

    // 22. FlatMap: Flatten a list of lists of books (for this example, simulating it)
    private void flattenBookLists(List<Book> bookList) {
        // Implementation here
    }

    // 23. Distinct: Get distinct genres from the books
    private void getDistinctGenres(List<Book> bookList) {
        // Implementation here
    }

    // 24. Collecting to Set: Collect unique book authors
    private void collectUniqueAuthors(List<Book> bookList) {
        // Implementation here
    }

    // 25. Filtering and Collecting: Collect books of a specific genre
    private void collectFictionBooks(List<Book> bookList) {
        // Implementation here
    }

    // 26. Average Rating: Calculate the average rating of all books
    private void calculateAverageRating(List<Book> bookList) {
        // Implementation here
    }

    // 27. Count by Rating Range: Count books within a specific rating range
    private void countBooksInRange(List<Book> bookList) {
        // Implementation here
    }

    // 28. Get Authors of High Rated Books: Collect authors of books rated above 8.5
    private void getAuthorsOfHighRatedBooks(List<Book> bookList) {
        // Implementation here
    }

    // 29. Sum Ratings by Genre: Calculate the sum of ratings for each genre
    private void sumRatingsByGenre(List<Book> bookList) {
        // Implementation here
    }

    // 30. Partitioning: Partition books into two lists based on their rating (above or below 8)
    private void partitionBooksByRating(List<Book> bookList) {
        // Implementation here
    }

    public static void main(String[] args) {
        BookExampleWithoutCode example = new BookExampleWithoutCode();
        example.runExamples();
    }
}
