package com.cg.java8.scenarios.movie;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

enum Genre {
    ACTION, DRAMA, COMEDY, THRILLER, SCIFI, DOCUMENTARY
}

class Movie {
    private String title;
    private String director;
    private int releaseYear;
    private Genre genre;
    private double rating;

    public Movie(String title, String director, int releaseYear, Genre genre, double rating) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }
}

public class MovieExample {

    private List<Movie> getMovies() {
        return List.of(
                new Movie("Inception", "Christopher Nolan", 2010, Genre.SCIFI, 8.8),
                new Movie("The Dark Knight", "Christopher Nolan", 2008, Genre.ACTION, 9.0),
                new Movie("Forrest Gump", "Robert Zemeckis", 1994, Genre.DRAMA, 8.8),
                new Movie("The Shawshank Redemption", "Frank Darabont", 1994, Genre.DRAMA, 9.3),
                new Movie("The Godfather", "Francis Ford Coppola", 1972, Genre.DRAMA, 9.2),
                new Movie("The Matrix", "The Wachowskis", 1999, Genre.SCIFI, 8.7),
                new Movie("Pulp Fiction", "Quentin Tarantino", 1994, Genre.ACTION, 8.9),
                new Movie("Parasite", "Bong Joon-ho", 2019, Genre.DRAMA, 8.6),
                new Movie("Get Out", "Jordan Peele", 2017, Genre.THRILLER, 7.7),
                new Movie("The Social Network", "David Fincher", 2010, Genre.DRAMA, 7.7),
                new Movie("Avengers: Endgame", "Anthony and Joe Russo", 2019, Genre.ACTION, 8.4),
                new Movie("The Silence of the Lambs", "Jonathan Demme", 1991, Genre.THRILLER, 8.6),
                new Movie("The Intouchables", "Olivier Nakache", 2011, Genre.COMEDY, 8.5),
                new Movie("Black Panther", "Ryan Coogler", 2018, Genre.ACTION, 7.3),
                new Movie("Inside Out", "Pete Docter", 2015, Genre.COMEDY, 8.1),
                new Movie("13th", "Ava DuVernay", 2016, Genre.DOCUMENTARY, 8.2)
        );
    }

    public void runExamples() {
        List<Movie> movieList = getMovies();

        // 1. Filter: Find all movies released after 2000
        List<Movie> moviesAfter2000 = movieList.stream()
                .filter(movie -> movie.getReleaseYear() > 2000)
                .collect(Collectors.toList());
        System.out.println("Movies released after 2000: " + moviesAfter2000);

        // 2. Map: Get a list of movie titles
        List<String> movieTitles = movieList.stream()
                .map(Movie::getTitle)
                .collect(Collectors.toList());
        System.out.println("Movie titles: " + movieTitles);

        // 3. Count: Count movies with a rating above 8
        long countHighRated = movieList.stream()
                .filter(movie -> movie.getRating() > 8)
                .count();
        System.out.println("Count of movies with rating above 8: " + countHighRated);

        // 4. Grouping: Count movies by genre
        Map<Genre, Long> moviesByGenre = movieList.stream()
                .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));
        System.out.println("Count of movies by genre: " + moviesByGenre);

        // 5. Sorted: Sort movies by rating in descending order
        List<Movie> sortedByRating = movieList.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .collect(Collectors.toList());
        System.out.println("Movies sorted by rating (descending): " + sortedByRating);

        // 6. Peek: Print each movie while counting them
        long totalMovies = movieList.stream()
                .peek(movie -> System.out.println("Movie: " + movie))
                .count();
        System.out.println("Total number of movies: " + totalMovies);

        // 7. Limit: Get the first 5 movies
        List<Movie> firstFiveMovies = movieList.stream()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("First five movies: " + firstFiveMovies);

        // 8. Skip: Skip the first 5 movies
        List<Movie> skippedMovies = movieList.stream()
                .skip(5)
                .collect(Collectors.toList());
        System.out.println("Movies after skipping the first 5: " + skippedMovies);

        // 9. Take While: Take movies until a certain condition fails (by rating)
        List<Movie> takeWhileRatingAbove8 = movieList.stream()
                .takeWhile(movie -> movie.getRating() > 8)
                .collect(Collectors.toList());
        System.out.println("Movies with rating above 8 (taking while): " + takeWhileRatingAbove8);

        // 10. Drop While: Drop movies until a certain condition fails (by rating)
        List<Movie> dropWhileRatingAbove8 = movieList.stream()
                .dropWhile(movie -> movie.getRating() > 8)
                .collect(Collectors.toList());
        System.out.println("Movies after dropping while rating above 8: " + dropWhileRatingAbove8);

        // 11. Min: Get the movie with the minimum rating
        Optional<Movie> minRatedMovie = movieList.stream()
                .min(Comparator.comparingDouble(Movie::getRating));
        minRatedMovie.ifPresent(movie -> System.out.println("Minimum rated movie: " + movie));

        // 12. Max: Get the movie with the maximum rating
        Optional<Movie> maxRatedMovie = movieList.stream()
                .max(Comparator.comparingDouble(Movie::getRating));
        maxRatedMovie.ifPresent(movie -> System.out.println("Maximum rated movie: " + movie));

        // 13. Any Match: Check if any movie is from the genre ACTION
        boolean anyAction = movieList.stream()
                .anyMatch(movie -> movie.getGenre() == Genre.ACTION);
        System.out.println("Any ACTION movie: " + anyAction);

        // 14. All Match: Check if all movies are rated above 5
        boolean allRatedAbove5 = movieList.stream()
                .allMatch(movie -> movie.getRating() > 5);
        System.out.println("All movies rated above 5: " + allRatedAbove5);

        // 15. None Match: Check if no movie is rated below 5
        boolean noneRatedBelow5 = movieList.stream()
                .noneMatch(movie -> movie.getRating() < 5);
        System.out.println("No movie rated below 5: " + noneRatedBelow5);

        // 16. Find First: Find the first movie with a rating above 9
        Optional<Movie> firstHighRatedMovie = movieList.stream()
                .filter(movie -> movie.getRating() > 9)
                .findFirst();
        firstHighRatedMovie.ifPresent(movie -> System.out.println("First movie with rating above 9: " + movie));

        // 17. Find Any: Find any movie released in the 1990s
        Optional<Movie> anyMovie90s = movieList.stream()
                .filter(movie -> movie.getReleaseYear() >= 1990 && movie.getReleaseYear() < 2000)
                .findAny();
        anyMovie90s.ifPresent(movie -> System.out.println("Any movie released in the 1990s: " + movie));

        // 18. Reduce: Find the longest title
        Optional<String> longestTitle = movieList.stream()
                .map(Movie::getTitle)
                .reduce((title1, title2) -> title1.length() > title2.length() ? title1 : title2);
        longestTitle.ifPresent(title -> System.out.println("Longest title: " + title));

        // 19. Collect: Gather movies with rating above 8.5 into a list
        List<Movie> highRatedMovies = movieList.stream()
                .filter(movie -> movie.getRating() > 8.5)
                .collect(Collectors.toList());
        System.out.println("Movies with rating above 8.5: " + highRatedMovies);

        // 20. Grouping By Year: Group movies by their release year
        Map<Integer, List<Movie>> moviesByYear = movieList.stream()
                .collect(Collectors.groupingBy(Movie::getReleaseYear));
        System.out.println("Movies grouped by release year: " + moviesByYear);

        // 21. Count of Movies by Rating Range
        Map<String, Long> countByRatingRange = movieList.stream()
                .collect(Collectors.groupingBy(movie -> {
                    if (movie.getRating() >= 9) return "9+";
                    else if (movie.getRating() >= 8) return "8-9";
                    else return "Below 8";
                }, Collectors.counting()));
        System.out.println("Count of movies by rating range: " + countByRatingRange);
    }

    public static void main(String[] args) {
        MovieExample example = new MovieExample();
        example.runExamples();
    }
}
