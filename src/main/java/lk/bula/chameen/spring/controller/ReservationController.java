package lk.bula.chameen.spring.controller;

import lk.bula.chameen.spring.dto.ReservationDTO;
import lk.bula.chameen.spring.service.ReservationService;
import lk.bula.chameen.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reservation")
@CrossOrigin
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping
    public ResponseUtil getAllReservations() {
        return new ResponseUtil(200,"Successfully Fetched",reservationService.getAllReservation());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil makeReservation(@RequestBody ReservationDTO dto) {
        System.out.println("in controller");
        reservationService.addReservation(dto);
        return new ResponseUtil(200, "success", null);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateReservation(@RequestBody ReservationDTO dto){
        reservationService.updateReservation(dto);
        return new ResponseUtil(200,"Update Successfully",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteReservation(String id){
        reservationService.deleteReservation(id);
        return new ResponseUtil(200,"Reservation deleted successfully",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchReservation(@PathVariable String id){
        return new ResponseUtil(200,"successfully searched reservation",reservationService.searchReservation(id));
    }

}
