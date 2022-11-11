package lk.bula.chameen.spring.service;

import lk.bula.chameen.spring.dto.CurrentUserDTO;

public interface CurrentUserService {
    CurrentUserDTO getCurrentUser();

    void add(CurrentUserDTO customer);

    void signOut();
}
