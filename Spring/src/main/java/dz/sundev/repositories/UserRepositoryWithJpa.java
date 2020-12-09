package dz.sundev.repositories;

import dz.sundev.db.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryWithJpa extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}
