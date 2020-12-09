package dz.sundev.db.entites;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
//@Table(name = "book")
public class Book {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    @Enumerated(EnumType.STRING)
    private AuthorStatus status;

    private LocalDateTime released;

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorStatus getStatus() {
        return status;
    }

    public void setStatus(AuthorStatus status) {
        this.status = status;
    }

    public LocalDateTime getReleased() {
        return released;
    }

    public void setReleased(LocalDateTime released) {
        this.released = released;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", released=" + released +
                '}';
    }

    public Book() {
    }

    public Book(String name, AuthorStatus status, LocalDateTime released) {
        this.name = name;
        this.status = status;
        this.released = released;
    }
}
