package lk.bula.chameen.spring.repo;

import lk.bula.chameen.spring.config.JPAConfig;
import lk.bula.chameen.spring.entity.Admin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
class AdminRepoTest {

    @Autowired
    AdminRepo adminRepo;

    @Test
    public void getAllAdmins() {
        List<Admin> all = adminRepo.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void saveAdmin() {

        adminRepo.save(new Admin("200132203039", "Dilhara", 767047467, "dilhara1117@gmail.com", "123456788"));

    }

}