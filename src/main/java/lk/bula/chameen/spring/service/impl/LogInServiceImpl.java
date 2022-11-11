package lk.bula.chameen.spring.service.impl;

import lk.bula.chameen.spring.dto.*;
import lk.bula.chameen.spring.repo.AdminRepo;
import lk.bula.chameen.spring.repo.CustomerRepo;
import lk.bula.chameen.spring.repo.DriverRepo;
import lk.bula.chameen.spring.service.CurrentUserService;
import lk.bula.chameen.spring.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LogInServiceImpl implements LoginService {
    @Autowired
    CurrentUserService currentUserService;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public LogInDetailDTO getUser(UserDTO userDTO) {
        System.out.println(userDTO.getEmail());
        LogInDetailDTO logInDetailDTO = new LogInDetailDTO();
        if (!customerRepo.existsCustomerByEmail(userDTO.getEmail())) {
            if (!adminRepo.existsAdminByEmail(userDTO.getEmail())) {
                if (!driverRepo.existsByEmail(userDTO.getEmail())) {
                    throw new RuntimeException("There is not an account related to this email");
                } else {
                    if (driverRepo.existsDriverByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword())) {
                        DriverDTO dto = mapper.map(driverRepo.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword()), DriverDTO.class);
                        logInDetailDTO.setData(dto);
                        logInDetailDTO.setRole("Driver");
                        currentUserService.add(new CurrentUserDTO(0, dto.getEmail(), "Driver", null));
                    } else {
                        throw new RuntimeException("Incorrect Password");
                    }
                }
            } else {
                if (adminRepo.existsAdminByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword())) {
                    AdminDTO dto = mapper.map(adminRepo.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword()), AdminDTO.class);
                    logInDetailDTO.setData(dto);
                    logInDetailDTO.setRole("Admin");
                    currentUserService.add(new CurrentUserDTO(0, dto.getEmail(), "Admin", null));
                } else {
                    throw new RuntimeException("Incorrect Password");
                }
            }
        } else {
            if (customerRepo.existsCustomerByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword())) {
                CustomerDTO dto = mapper.map(customerRepo.findByEmailAndPassword(userDTO.getEmail(), userDTO.getPassword()), CustomerDTO.class);
                logInDetailDTO.setData(dto);
                logInDetailDTO.setRole("Customer");
                currentUserService.add(new CurrentUserDTO(0, dto.getEmail(), "Customer", null));
            } else {
                throw new RuntimeException("Incorrect Password");
            }
        }
        return logInDetailDTO;
    }
}
