package lk.bula.chameen.spring.controller;

import lk.bula.chameen.spring.dto.CarDTO;
import lk.bula.chameen.spring.service.CarService;
import lk.bula.chameen.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;


@RestController
@CrossOrigin
@RequestMapping("car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping
    public ResponseUtil getAllCar() {
        return new ResponseUtil(200, "Data Fetched Successfully", carService.getAllCars());
    }

    @GetMapping(path = "/check")
    public ResponseUtil check() {

        return new ResponseUtil(200, "checked Successfully", null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil addCar(@RequestPart("frontImg") MultipartFile frontImage, @RequestPart("backImg") MultipartFile backImage, @RequestPart("carData") CarDTO carDTO) {
        System.out.println(carDTO.toString());

        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadDir = new File(projectPath + "/uploads");
            uploadDir.mkdir();
            frontImage.transferTo(new File(uploadDir.getAbsolutePath() + "/" + frontImage.getOriginalFilename()));
            backImage.transferTo(new File(uploadDir.getAbsolutePath() + "/" + backImage.getOriginalFilename()));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
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

    @GetMapping(path = "/carname/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCarByName(@PathVariable String name) {
        return new ResponseUtil(200, "Car Fetched Successfully", carService.searchCarByName(name));
    }

}
