package dz.sundev.db.entites;

import javax.persistence.*;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
//@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "name")
    private String userName;

//    @Column(name = "email")
    private String email;

//    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Book> books;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    //    public Set<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(Set<Book> books) {
//        this.books = books;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    /*public User() {
    }*/

    public User(String userName, String email, Set<Book> books) {
        this.userName = userName;
        this.email = email;
        this.books = books;
    }
}