package lk.bula.chameen.spring.repo;

import lk.bula.chameen.spring.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservationRepo extends JpaRepository<Reservation, String> {
    @Query(value = "SELECT id FROM reservation ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String getLastId();
}
