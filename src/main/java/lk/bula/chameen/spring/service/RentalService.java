package lk.bula.chameen.spring.service;

import lk.bula.chameen.spring.dto.RentalDTO;

import java.util.List;


public interface RentalService {
    void addRental(RentalDTO dto);

    void deleteRental(String id);

    void updateRental(RentalDTO dto);

    RentalDTO searchRental(String id);

    List<RentalDTO> getAllRental();

    String getNewId();
}
