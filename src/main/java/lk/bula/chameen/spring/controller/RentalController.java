package lk.bula.chameen.spring.controller;

import lk.bula.chameen.spring.dto.RentalDTO;
import lk.bula.chameen.spring.service.RentalService;
import lk.bula.chameen.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rental")
@CrossOrigin
public class RentalController {
    @Autowired
    RentalService service;

    @GetMapping
    public ResponseUtil getAllRental() {
        return new ResponseUtil(200, "Data Fetched Successfully", service.getAllRental());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil addRental(@RequestBody RentalDTO dto) {
        System.out.println("add car meth invoked");
        service.addRental(dto);
        return new ResponseUtil(201, "Successfully added car", null);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateRental(@RequestBody RentalDTO dto) {
        service.updateRental(dto);
        return new ResponseUtil(200, "Successfully updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteRental(@RequestParam String id) {
        service.deleteRental(id);
        return new ResponseUtil(200, "Car deleted successfully", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchRental(@PathVariable String id) {
        return new ResponseUtil(200, "successfully searched car", service.searchRental(id));
    }

}
