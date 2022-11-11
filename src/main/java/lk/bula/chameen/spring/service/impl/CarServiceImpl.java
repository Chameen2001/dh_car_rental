package lk.bula.chameen.spring.service.impl;

import lk.bula.chameen.spring.dto.CarDTO;
import lk.bula.chameen.spring.entity.Car;
import lk.bula.chameen.spring.entity.DurationRate;
import lk.bula.chameen.spring.repo.CarRepo;
import lk.bula.chameen.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void addCar(CarDTO dto) {
        if (!carRepo.existsById(dto.getRegNo())) {
            dto.setDurationRate(new DurationRate(1));
            carRepo.save(modelMapper.map(dto, Car.class));
        }else {
            throw new RuntimeException("This car is already exists");
        }

    }

    @Override
    public void deleteCar(String id) {
        if (carRepo.existsById(id)) {
            carRepo.deleteById(id);
        } else {
            throw new RuntimeException("There is not such a car like " + id);
        }
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (carRepo.existsById(dto.getRegNo())) {
            carRepo.save(modelMapper.map(dto,Car.class));
        }else {
            throw new RuntimeException("There is not such a car like "+dto.getRegNo());
        }
    }

    @Override
    public CarDTO searchCar(String id) {
        if (carRepo.existsById(id)) {
            return modelMapper.map(carRepo.findById(id), CarDTO.class);
        } else {
            throw new RuntimeException("There is not such a car like " + id);
        }
    }

    @Override
    public List<CarDTO> getAllCars() {
        return modelMapper.map(carRepo.findAll(), new TypeToken<List<CarDTO>>() {
        }.getType());
    }

    @Override
    public String getNewId() {
        return null;
    }

    @Override
    public CarDTO searchCarByName(String name) {
        System.out.println(name);
        if (carRepo.existsByBrandAndModel(name.split(" ")[0], name.split(" ")[1])) {
            return modelMapper.map(carRepo.getCarByBrandAndModel(name.split(" ")[0], name.split(" ")[1]), CarDTO.class);
        } else {
            throw new RuntimeException("There is not such a car like " + name);
        }
    }
}
