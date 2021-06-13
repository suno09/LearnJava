package dz.sundev.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class User {
    private String id;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String rsaPublicKey;

    //we do not want to expose private RSA key in API responses
    @JsonIgnore
    private String rsaPrivateKey;

    //we do not want to expose AES primary key in API responses
    @JsonIgnore
    private String aesKey;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}