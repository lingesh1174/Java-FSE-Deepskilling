import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementSystem{
    public static void main(String[] args) {
        Library library = new Library(10);
        library.addBook(new Book(1, "The Alchemist", "Paulo Coelho"));
        library.addBook(new Book(2, "Romeo Juliet", "William Shakesphere"));
        library.addBook(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(4, "Pride and Prejudice", "Jane Austen"));
        System.out.println("\nLinear Search for 'Romeo Juliet':");
        library.linearSearchByTitle("Romeo Juliet");
        library.sortBooksByTitle();
        System.out.println("\nBinary Search for 'To Kill a Mockingbird':");
        library.binarySearchByTitle("To Kill a Mockingbird");
        System.out.println("\nBinary Search for 'Invisible Man':");
        library.binarySearchByTitle("Invisible Man");
    }
}

class Book {
    int bookId;
    String title;
    String author;
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("ID: " + bookId + ", Title: \"" + title + "\", Author: " + author);
    }
}

class Library {
    private Book[] books;
    private int count;

    public Library(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    public void addBook(Book book) {
        if (count >= books.length) {
            System.out.println("Library is full. Cannot add more books.");
            return;
        }
        books[count++] = book;
        System.out.println("Book added: " + book.title);
    }

    public void linearSearchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                System.out.println("Book found (Linear Search):");
                books[i].displayInfo();
                return;
            }
        }
        System.out.println("Book not found using Linear Search.");
    }

    public void binarySearchByTitle(String title) {
        int left = 0;
        int right = count-1;
        while (left <= right){
            int mid = left + (right - left)/2;
            int cmp = books[mid].title.compareToIgnoreCase(title);

            if (cmp == 0) {
                System.out.println("Book found (Binary Search):");
                books[mid].displayInfo();
                return;
            } else if (cmp < 0) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        System.out.println("Book not found using Binary Search.");
    }
    public void sortBooksByTitle() {
        Arrays.sort(books, 0, count, Comparator.comparing(book -> book.title.toLowerCase()));
        System.out.println("\nBooks sorted by title for Binary Search.");
    }
}