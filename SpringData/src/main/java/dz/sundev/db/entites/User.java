package dz.sundev.db.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
//@Table(name = "users")
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @Column(name = "name")
    private String userName;

    //    @Column(name = "email")
    private String email;

    //    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Book> books;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", books=" + books +
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