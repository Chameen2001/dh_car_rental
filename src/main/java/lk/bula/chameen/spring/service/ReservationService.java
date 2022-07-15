package lk.bula.chameen.spring.service;

import lk.bula.chameen.spring.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {
    void addReservation(ReservationDTO dto);

    void deleteReservation(String id);

    void updateReservation(ReservationDTO dto);

    ReservationDTO searchReservation(String id);

    List<ReservationDTO> getAllReservation();

    String getNewId();
}
