package lk.bula.chameen.spring.service.impl;

import lk.bula.chameen.spring.dto.ReservationDTO;
import lk.bula.chameen.spring.entity.Reservation;
import lk.bula.chameen.spring.repo.ReservationRepo;
import lk.bula.chameen.spring.service.ReservationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepo reservationRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public void addReservation(ReservationDTO dto) {

        System.out.println("in service");
        dto.setId(this.getNewId());
        reservationRepo.save(modelMapper.map(dto, Reservation.class));

    }

    @Override
    public void deleteReservation(String id) {
        if (reservationRepo.existsById(id)) {
            reservationRepo.deleteById(id);
        }else {
            throw new RuntimeException("There is no such a reservation under "+id);
        }
    }

    @Override
    public void updateReservation(ReservationDTO dto) {
        if (reservationRepo.existsById(dto.getId())) {
            reservationRepo.save(modelMapper.map(dto,Reservation.class));
        }else {
            throw new RuntimeException("There is no such a reservation registered under "+dto.getId());
        }
    }

    @Override
    public ReservationDTO searchReservation(String id) {
        if (reservationRepo.existsById(id)) {
            return modelMapper.map(reservationRepo.findById(id),ReservationDTO.class);
        }else {
            throw new RuntimeException("There is no such a reservation registered under "+id);
        }
    }

    @Override
    public List<ReservationDTO> getAllReservation() {
        return modelMapper.map(reservationRepo.findAll(),new TypeToken<List<ReservationDTO>>(){}.getType());
    }

    @Override
    public String getNewId() {
        String lastId = reservationRepo.getLastId();
        if (lastId != null) {
            String id;
            int nextNumber = Integer.parseInt(lastId.split("-")[1]) + 1;

            if (nextNumber < 10) {
                id = "R00-00" + nextNumber;
            } else if (nextNumber < 100) {
                id = "R00-0" + nextNumber;
            } else {
                id = "R00-" + nextNumber;
            }

            return id;

        } else {
            return "R00-001";
        }
    }
}
