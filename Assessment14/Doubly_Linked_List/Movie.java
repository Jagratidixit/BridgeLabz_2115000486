import java.util.*;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev, next;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = this.next = null;
    }
}

class MovieManagement {
    Movie head, tail;

    void addMovieAtBegin(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    void addMovieAtPos(String title, String director, int year, double rating, int position) {
        if (position <= 1 || head == null) {
            addMovieAtBegin(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        int count = 1;
        while (temp.next != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        newMovie.next = temp.next;
        if (temp.next != null) temp.next.prev = newMovie;
        temp.next = newMovie;
        newMovie.prev = temp;
        if (newMovie.next == null) tail = newMovie;
    }

    void removeMovie(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
    }

    List<Movie> searchByDirector(String director) {
        List<Movie> result = new ArrayList<>();
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) result.add(temp);
            temp = temp.next;
        }
        return result;
    }

    List<Movie> searchByRating(double rating) {
        List<Movie> result = new ArrayList<>();
        Movie temp = head;
        while (temp != null) {
            if (temp.rating == rating) result.add(temp);
            temp = temp.next;
        }
        return result;
    }

    void updateMovieRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    void displayMoviesForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    void displayMoviesReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MovieManagement mm = new MovieManagement();
        mm.addMovieAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        mm.addMovieAtBegin("Interstellar", "Christopher Nolan", 2014, 8.6);
        mm.addMovieAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        mm.addMovieAtPos("Parasite", "Bong Joon-ho", 2019, 8.6, 2);

        System.out.println("Movies in forward order:");
        mm.displayMoviesForward();

        System.out.println("\nMovies in reverse order:");
        mm.displayMoviesReverse();

        mm.updateMovieRating("Inception", 9.0);
        System.out.println("\nAfter updating rating:");
        mm.displayMoviesForward();

        mm.removeMovie("Parasite");
        System.out.println("\nAfter removing 'Parasite':");
        mm.displayMoviesForward();
    }
}
