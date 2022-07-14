package lk.bula.chameen.spring.controller;

import lk.bula.chameen.spring.dto.CustomerDTO;
import lk.bula.chameen.spring.service.CustomerService;
import lk.bula.chameen.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveCustomer(@ModelAttribute CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
    }
}
