package ua.secondhand.secondhand.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.secondhand.secondhand.Models.Roles;
import ua.secondhand.secondhand.Services.RolesService;

import java.util.List;

@RestController
@RequestMapping("/Roles")
public class RolesController {
    public final RolesService rolesService;

    @Autowired
    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping("/Select")
    public ResponseEntity<List<Roles>> selectRole(){
        List<Roles> roles = rolesService.selectRole();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @PostMapping("/Save")
    public ResponseEntity<Roles> createRole(@RequestBody Roles roles){
        Roles role = rolesService.createRole(roles);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PostMapping("/Update/{id}")
    public ResponseEntity<Roles> updateRole(@PathVariable Integer id, @RequestBody Roles roles){
        Roles role = rolesService.updateRole(roles, id);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PostMapping("/Delete/{id}")
    public void deleteRole(@PathVariable Integer id){
        rolesService.deleteRole(id);
    }
}
