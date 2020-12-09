package dz.sundev.db.cascade_persist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person_ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "person_", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Address_> addresses_;

    public Person_(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person_{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", addresses_=" + addresses_ +
                '}';
    }
}
