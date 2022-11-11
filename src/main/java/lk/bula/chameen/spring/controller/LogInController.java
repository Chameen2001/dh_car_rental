package lk.bula.chameen.spring.controller;

import lk.bula.chameen.spring.dto.LogInDetailDTO;
import lk.bula.chameen.spring.dto.UserDTO;
import lk.bula.chameen.spring.service.LoginService;
import lk.bula.chameen.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("login")
public class LogInController {

    @Autowired
    LoginService loginService;

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil login(@RequestBody UserDTO dto) {
        System.out.println(dto.getEmail());
        LogInDetailDTO user = loginService.getUser(dto);
        return new ResponseUtil(200, "successfully logged in", user);
    }

}
