package lk.bula.chameen.spring.controller;

import lk.bula.chameen.spring.dto.AdminDTO;
import lk.bula.chameen.spring.service.AdminService;
import lk.bula.chameen.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil(200, "Ok", adminService.getAllAdmins());
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(@RequestBody AdminDTO adminDTO) {
        adminService.addAdmin(adminDTO);
        return new ResponseUtil(201, "Successfully added", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAdmin(@RequestBody AdminDTO adminDTO) {
        adminService.updateAdmin(adminDTO);
        return new ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteAdmin(String id) {
        adminService.deleteAdmin(id);
        return new ResponseUtil(200, "Deleted", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil adminSearch(@PathVariable String id) {
        return new ResponseUtil(200, "Ok", adminService.searchAdmin(id));
    }

}
