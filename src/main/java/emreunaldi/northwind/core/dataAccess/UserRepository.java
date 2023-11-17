package emreunaldi.northwind.core.dataAccess;

import emreunaldi.northwind.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
