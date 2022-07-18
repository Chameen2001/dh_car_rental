package lk.bula.chameen.spring.service;

import lk.bula.chameen.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void addDriver(DriverDTO dto);

    void deleteDriver(String id);

    void updateDriver(DriverDTO dto);

    DriverDTO searchDriver(String id);

    List<DriverDTO> getAllDriver();

    String getNewId();
}
