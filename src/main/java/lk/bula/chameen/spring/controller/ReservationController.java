package lk.bula.chameen.spring.controller;

import lk.bula.chameen.spring.dto.ReservationDTO;
import lk.bula.chameen.spring.service.ReservationService;
import lk.bula.chameen.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reservation")
@CrossOrigin
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping
    public String getAllReservations() {
        System.out.println("get method invoked");
        return "get method invoked";
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil makeReservation(@RequestBody ReservationDTO dto) {
        System.out.println("in controller");
        reservationService.addReservation(dto);
        return new ResponseUtil(200, "success", null);
    }

}
