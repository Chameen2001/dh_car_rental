package lk.bula.chameen.spring.service.impl;

import lk.bula.chameen.spring.dto.AdminDTO;
import lk.bula.chameen.spring.entity.Admin;
import lk.bula.chameen.spring.repo.AdminRepo;
import lk.bula.chameen.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void addAdmin(AdminDTO dto) {
        if (!adminRepo.existsById(dto.getId())) {
            adminRepo.save(modelMapper.map(dto, Admin.class));
        } else {
            throw new RuntimeException("This admin is already exists");
        }
    }

    @Override
    public void deleteAdmin(String id) {
        if (adminRepo.existsById(id)) {
            adminRepo.deleteById(id);
        } else {
            throw new RuntimeException("There is no admin like " + id);
        }
    }

    @Override
    public void updateAdmin(AdminDTO dto) {
        if (adminRepo.existsById(dto.getId())) {
            adminRepo.save(modelMapper.map(dto, Admin.class));
        } else {
            throw new RuntimeException("There is not a admin like " + dto.getId());
        }
    }

    @Override
    public AdminDTO searchAdmin(String id) {
        if (adminRepo.existsById(id)) {
            System.out.println(adminRepo.findById(id).get());
            return modelMapper.map(adminRepo.findById(id).get(), AdminDTO.class);
        } else {
            throw new RuntimeException("No admin For " + id + " ..!");
        }
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        return modelMapper.map(adminRepo.findAll(), new TypeToken<List<AdminDTO>>() {

        }.getType());
    }

    @Override
    public String getNewId() {
        return null;
    }
}
