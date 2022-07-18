package lk.bula.chameen.spring.service.impl;

import lk.bula.chameen.spring.dto.DriverDTO;
import lk.bula.chameen.spring.entity.Driver;
import lk.bula.chameen.spring.repo.DriverRepo;
import lk.bula.chameen.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void addDriver(DriverDTO dto) {
        if (!driverRepo.existsById(dto.getId())) {
            driverRepo.save(modelMapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException("This driver is already exists");
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (driverRepo.existsById(id)) {
            driverRepo.deleteById(id);
        } else {
            throw new RuntimeException("There is no driver like " + id);
        }
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (driverRepo.existsById(dto.getId())) {
            driverRepo.save(modelMapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException("There is not a driver like " + dto.getId());
        }
    }

    @Override
    public DriverDTO searchDriver(String id) {
        if (driverRepo.existsById(id)) {
            System.out.println(driverRepo.findById(id).get());
            return modelMapper.map(driverRepo.findById(id).get(), DriverDTO.class);
        } else {
            throw new RuntimeException("No driver For " + id + " ..!");
        }
    }

    @Override
    public List<DriverDTO> getAllDriver() {
        return modelMapper.map(driverRepo.findAll(), new TypeToken<List<DriverDTO>>() {

        }.getType());
    }

    @Override
    public String getNewId() {
        return null;
    }
}
