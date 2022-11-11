package lk.bula.chameen.spring.controller;

import lk.bula.chameen.spring.service.CurrentUserService;
import lk.bula.chameen.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("currentUser")
@CrossOrigin
public class CurrentUserController {

    @Autowired
    CurrentUserService currentUserService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCurrentUser() {
        System.out.println("current awaaa");
        return new ResponseUtil(200, "successfully get current user", currentUserService.getCurrentUser());
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil signOut() {
        currentUserService.signOut();
        return new ResponseUtil(200, "Signed Out", null);
    }
}
