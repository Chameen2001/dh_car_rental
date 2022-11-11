package lk.bula.chameen.spring.repo;

import lk.bula.chameen.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver, String> {
    Boolean existsByEmail(String email);

    boolean existsDriverByEmailAndPassword(String email, String password);

    Object findByEmailAndPassword(String email, String password);

    Driver findByEmail(String email);
}
