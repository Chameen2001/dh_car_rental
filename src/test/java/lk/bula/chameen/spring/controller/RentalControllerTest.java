package lk.bula.chameen.spring.controller;

import lk.bula.chameen.spring.config.WebAppConfig;
import lk.bula.chameen.spring.dto.AdminDTO;
import lk.bula.chameen.spring.dto.RentalDTO;
import lk.bula.chameen.spring.dto.ReservationDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class})
@ExtendWith(SpringExtension.class)
@Transactional
class RentalControllerTest {

    @Autowired
    RentalController rentalController;

    @Test
    public void addRental() {
        assertDoesNotThrow(() -> {
            rentalController.addRental(new RentalDTO("rental001", 25000, 28000, new ReservationDTO("R00-001"), new AdminDTO("200132203039")));
        });

    }

}