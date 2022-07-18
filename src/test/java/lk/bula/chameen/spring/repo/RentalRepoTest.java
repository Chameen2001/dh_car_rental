package lk.bula.chameen.spring.repo;

import lk.bula.chameen.spring.config.JPAConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {JPAConfig.class})
@ExtendWith(SpringExtension.class)
class RentalRepoTest {

    @Autowired
    RentalRepo rentalRepo;

    @Test
    public void getAllRental() {

    }

}