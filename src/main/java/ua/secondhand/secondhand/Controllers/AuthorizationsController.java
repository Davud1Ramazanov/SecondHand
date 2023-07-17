package ua.secondhand.secondhand.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.secondhand.secondhand.Models.Authorizations;
import ua.secondhand.secondhand.Services.AuthorizationsService;

import java.util.List;

@RestController
@RequestMapping("/Authorizations")
public class AuthorizationsController {
    private final AuthorizationsService authService;

    @Autowired
    public AuthorizationsController(AuthorizationsService authService) {
        this.authService = authService;
    }

    @GetMapping("/FindAuthName")
    public ResponseEntity<Authorizations> findAuthName(){
        Authorizations authInfo = authService.getAuthInfo();
        return new ResponseEntity<>(authInfo, HttpStatus.OK);
    }

    @PostMapping("/FindByUserName")
    public ResponseEntity<Authorizations> findByUserName(@RequestBody Authorizations authorizations){
        Authorizations authorization = authService.findByNameAccount(authorizations.getName());
        return new ResponseEntity(authorization, HttpStatus.OK);
    }

    @PostMapping("/AuthorizationAccountUser")
    public boolean authAcc(@RequestBody Authorizations authorizations) {
        return authService.authAccUser(authorizations.getName(), authorizations.getPassword());
    }

    @PostMapping("/AuthorizationAccountAdmin")
    public boolean authAccAdmin(@RequestBody Authorizations authorizations){
        return authService.authAccAdmin(authorizations.getName(), authorizations.getPassword());
    }

    @PostMapping("/RegistrationAccount")
    public boolean regAcc(@RequestBody Authorizations authorizations) {
        return authService.regAcc(authorizations);
    }

    @GetMapping("/Select")
    public ResponseEntity<List<Authorizations>> getAcc() {
        List<Authorizations> authorizations = authService.selectAuth();
        return new ResponseEntity<>(authorizations, HttpStatus.OK);
    }

    @PostMapping("/Save")
    public ResponseEntity<Authorizations> createAcc(@RequestBody Authorizations authorizations) {
        Authorizations createAuth = authService.createAcc(authorizations);
        return new ResponseEntity<>(createAuth, HttpStatus.OK);
    }

    @PostMapping("/Update/{id}")
    public ResponseEntity<Authorizations> updateAcc(@PathVariable Integer id, @RequestBody Authorizations authorizations) {
        Authorizations updateAuth = authService.updateAcc(id, authorizations);
        return new ResponseEntity<>(updateAuth, HttpStatus.OK);
    }

    @PostMapping("/Delete/{id}")
    public ResponseEntity<Void> deleteAcc(@PathVariable Integer id) {
        authService.deleteAcc(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
