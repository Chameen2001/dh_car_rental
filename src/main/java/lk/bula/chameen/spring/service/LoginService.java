package lk.bula.chameen.spring.service;

import lk.bula.chameen.spring.dto.LogInDetailDTO;
import lk.bula.chameen.spring.dto.UserDTO;

public interface LoginService {
    LogInDetailDTO getUser(UserDTO userDTO);
}
