package lk.bula.chameen.spring.controller;

import lk.bula.chameen.spring.dto.DriverDTO;
import lk.bula.chameen.spring.service.DriverService;
import lk.bula.chameen.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDrivers() {
        return new ResponseUtil(200, "Ok", driverService.getAllDriver());
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(@RequestBody DriverDTO dto) {
        driverService.addDriver(dto);
        return new ResponseUtil(201, "Successfully added", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO dto) {
        driverService.updateDriver(dto);
        return new ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(String id) {
        driverService.deleteDriver(id);
        return new ResponseUtil(200, "Deleted", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDriver(@PathVariable String id) {
        return new ResponseUtil(200, "Ok", driverService.searchDriver(id));
    }

}
