package lk.bula.chameen.spring.repo;

import lk.bula.chameen.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {

}
