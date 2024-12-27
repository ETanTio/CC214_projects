package User;

import java.util.*;
import SettersAndGetters.Books;

public class users {
    private String Name;
    private int Id;
    private String email;
    private String pass;
    private List<Books> borrowedBooks;
    private List<Books> returnedBooks;

    public users(int Id, String Name, String pass, String email) {
        this.Id = Id;
        this.Name = Name;
        this.pass = pass;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
        this.returnedBooks = new ArrayList<>();
    }

    public users() {
        this.borrowedBooks = new ArrayList<>();
        this.returnedBooks = new ArrayList<>();
    }

    public int getId() {
        return Id;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return Name;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Books> getBorrowedBooks() {
        return borrowedBooks;
    }

    public List<Books> getReturnedBooks() {
        return returnedBooks;
    }

    public void borrowBook(Books book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setBorrowed(true);
            book.setAvailableCopy(book.getAvailableCopy() - 1);
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            System.out.println("Book is not available: " + book.getTitle());
        }
    }

    public void returnBook(Books book) {
        if (borrowedBooks.remove(book)) {
            returnedBooks.add(book);
            book.setBorrowed(false);
            book.setAvailableCopy(book.getAvailableCopy() + 1);
            System.out.println("Book returned: " + book.getTitle());
        } else {
            System.out.println("Book was not borrowed by this user: " + book.getTitle());
        }
    }
}
