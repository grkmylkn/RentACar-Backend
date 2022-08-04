package backend.rentacar.repositories.abstracts;

import backend.rentacar.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByUserId(int userId);
    boolean existsByEmail(String email);
    boolean existsByUserId(int userId);
}
