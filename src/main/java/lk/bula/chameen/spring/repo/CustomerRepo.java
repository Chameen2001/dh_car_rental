package lk.bula.chameen.spring.repo;

import lk.bula.chameen.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    Boolean existsCustomerByEmail(String email);

    @Query(value = "SELECT id FROM customer ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String getLatestId();

}
