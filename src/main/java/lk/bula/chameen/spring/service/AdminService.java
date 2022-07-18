package lk.bula.chameen.spring.service;

import lk.bula.chameen.spring.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    void addAdmin(AdminDTO dto);

    void deleteAdmin(String id);

    void updateAdmin(AdminDTO dto);

    AdminDTO searchAdmin(String id);

    List<AdminDTO> getAllAdmins();

    String getNewId();
}
