package dz.sundev.dto;

import dz.sundev.db.entites.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class UserDTO {
    private String userName;
    private Set<Book> books;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public UserDTO(String userName, Set<Book> books) {
        this.userName = userName;
        this.books = books;
    }

    public UserDTO(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + userName + '\'' +
                ", books=" + books +
                '}';
    }
}
