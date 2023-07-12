package ua.secondhand.secondhand.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.secondhand.secondhand.Models.Authorizations;
import ua.secondhand.secondhand.Services.AuthorizationsService;

import java.util.*;

@RestController
@RequestMapping("/Authorizations")
public class AuthorizationsController {
    private final AuthorizationsService authService;

    @Autowired
    public AuthorizationsController(AuthorizationsService authService) {
        this.authService = authService;
    }

    @GetMapping("/Select")
    public ResponseEntity<List<Authorizations>> getAcc(){
        List<Authorizations> authorizations = authService.selectAuth();
        return new ResponseEntity<>(authorizations, HttpStatus.OK);
    }

    @PostMapping("/Save")
    public ResponseEntity<Authorizations> createAcc(@RequestBody Authorizations authorizations){
        Authorizations createAuth = authService.createAcc(authorizations);
        return new ResponseEntity<>(createAuth, HttpStatus.OK);
    }

    @PostMapping("/Update/{id}")
    public ResponseEntity<Authorizations> updateAcc(@PathVariable Integer id,@RequestBody Authorizations authorizations){
        Authorizations updateAuth = authService.updateAcc(id, authorizations);
        return new ResponseEntity<>(updateAuth, HttpStatus.OK);
    }

    @PostMapping("/Delete/{id}")
    public ResponseEntity<Authorizations> deleteAcc(@PathVariable Integer id){
        authService.deleteAcc(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
