package lk.bula.chameen.spring.repo;

import lk.bula.chameen.spring.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepo extends JpaRepository<Rental, String> {
}
