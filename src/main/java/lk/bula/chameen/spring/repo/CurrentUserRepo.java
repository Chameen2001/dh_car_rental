package lk.bula.chameen.spring.repo;

import lk.bula.chameen.spring.entity.CurrentUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentUserRepo extends JpaRepository<CurrentUser, String> {

}
