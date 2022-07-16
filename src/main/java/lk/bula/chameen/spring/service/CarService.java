package lk.bula.chameen.spring.service;

import lk.bula.chameen.spring.dto.CarDTO;
import lk.bula.chameen.spring.dto.CustomerDTO;

import java.util.List;

public interface CarService {
    void addCar(CarDTO dto);

    void deleteCar(String id);

    void updateCar(CarDTO dto);

    CarDTO searchCar(String id);

    List<CarDTO> getAllCars();

    String getNewId();
}
