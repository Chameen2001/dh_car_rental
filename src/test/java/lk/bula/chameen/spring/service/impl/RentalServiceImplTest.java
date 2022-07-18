package lk.bula.chameen.spring.service.impl;

import lk.bula.chameen.spring.config.WebAppConfig;
import lk.bula.chameen.spring.dto.RentalDTO;
import lk.bula.chameen.spring.service.RentalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
class RentalServiceImplTest {

    @Autowired
    RentalService rentalService;

    @Test
    public void addRental() {
        rentalService.addRental(new RentalDTO());
    }

}