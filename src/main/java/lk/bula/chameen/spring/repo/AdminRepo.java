package lk.bula.chameen.spring.repo;

import lk.bula.chameen.spring.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, String> {

}
