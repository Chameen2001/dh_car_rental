package lk.bula.chameen.spring.controller;

import lk.bula.chameen.spring.dto.CarDTO;
import lk.bula.chameen.spring.service.CarService;
import lk.bula.chameen.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping
    public ResponseUtil getAllCar(){
        return new ResponseUtil(200,"Data Fetched Successfully",carService.getAllCars());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil addCar(@RequestBody CarDTO carDTO){
        System.out.println("add car meth invoked");
        carService.addCar(carDTO);
        return new ResponseUtil(201, "Successfully added car", null);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCar(@RequestBody CarDTO carDTO) {
        carService.updateCar(carDTO);
        return new ResponseUtil(200, "Successfully updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCar(@RequestParam String id) {
        carService.deleteCar(id);
        return new ResponseUtil(200, "Car deleted successfully", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCar(@PathVariable String id) {
        return new ResponseUtil(200, "successfully searched car", carService.searchCar(id));
    }

}
