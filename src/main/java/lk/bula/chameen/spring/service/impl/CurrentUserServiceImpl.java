package lk.bula.chameen.spring.service.impl;

import lk.bula.chameen.spring.dto.AdminDTO;
import lk.bula.chameen.spring.dto.CurrentUserDTO;
import lk.bula.chameen.spring.dto.CustomerDTO;
import lk.bula.chameen.spring.dto.DriverDTO;
import lk.bula.chameen.spring.entity.CurrentUser;
import lk.bula.chameen.spring.repo.AdminRepo;
import lk.bula.chameen.spring.repo.CurrentUserRepo;
import lk.bula.chameen.spring.repo.CustomerRepo;
import lk.bula.chameen.spring.repo.DriverRepo;
import lk.bula.chameen.spring.service.CurrentUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class CurrentUserServiceImpl implements CurrentUserService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    CurrentUserRepo currentUserRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CurrentUserDTO getCurrentUser() {

        List<CurrentUserDTO> map = modelMapper.map(currentUserRepo.findAll(), new TypeToken<List<CurrentUserDTO>>() {
        }.getType());


        if (map.size() == 0) {
            return null;
        } else {
            CurrentUserDTO currentUserDTO = map.get(0);
            if (currentUserDTO.getRole().equals("Customer")) {
                currentUserDTO.setData(modelMapper.map(customerRepo.findByEmail(currentUserDTO.getEmail()), CustomerDTO.class));
            } else if (currentUserDTO.getRole().equals("Admin")) {
                currentUserDTO.setData(modelMapper.map(adminRepo.findByEmail(currentUserDTO.getEmail()), AdminDTO.class));
            } else {
                currentUserDTO.setData(modelMapper.map(driverRepo.findByEmail(currentUserDTO.getEmail()), DriverDTO.class));
            }
            return currentUserDTO;
        }


    }

    @Override
    public void add(CurrentUserDTO dto) {
        currentUserRepo.save(modelMapper.map(dto, CurrentUser.class));
    }

    @Override
    public void signOut() {
        currentUserRepo.deleteAll();
    }
}
