package lk.bula.chameen.spring.service.impl;

import lk.bula.chameen.spring.dto.RentalDTO;
import lk.bula.chameen.spring.entity.Rental;
import lk.bula.chameen.spring.repo.RentalRepo;
import lk.bula.chameen.spring.service.RentalService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RentalServiceImpl implements RentalService {
    @Autowired
    RentalRepo repo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void addRental(RentalDTO dto) {
        if (!repo.existsById(dto.getId())) {
            repo.save(modelMapper.map(dto, Rental.class));
        } else {
            throw new RuntimeException("This rental is already exists");
        }

    }

    @Override
    public void deleteRental(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("There is not such a rental like " + id);
        }
    }

    @Override
    public void updateRental(RentalDTO dto) {
        if (repo.existsById(dto.getId())) {
            repo.save(modelMapper.map(dto, Rental.class));
        } else {
            throw new RuntimeException("There is not such a rental like " + dto.getId());
        }
    }

    @Override
    public RentalDTO searchRental(String id) {
        if (repo.existsById(id)) {
            return modelMapper.map(repo.findById(id), RentalDTO.class);
        } else {
            throw new RuntimeException("There is not such a rental like " + id);
        }
    }

    @Override
    public List<RentalDTO> getAllRental() {
        return modelMapper.map(repo.findAll(), new TypeToken<List<RentalDTO>>() {
        }.getType());
    }

    @Override
    public String getNewId() {
        return null;
    }
}
