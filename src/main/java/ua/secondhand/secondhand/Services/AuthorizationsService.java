package ua.secondhand.secondhand.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.secondhand.secondhand.Models.Authorizations;
import ua.secondhand.secondhand.Repositories.IAuthorizationsRepository;
import ua.secondhand.secondhand.Models.Roles;

import java.util.List;

@Service
public class AuthorizationsService {
    private final IAuthorizationsRepository authRepos;

    @Autowired
    public AuthorizationsService(IAuthorizationsRepository authRepos) {
        this.authRepos = authRepos;
    }

    public Authorizations findByNameAccount(String name){
        Authorizations authorization =  authRepos.findByName(name);
        if(authorization != null){
            return authorization;
        }
        return null;
    }

    public boolean authAccUser(String name, String password) {
        Authorizations authorizations = authRepos.findByName(name);
        if (authorizations == null || authorizations.getRole().getId().equals(1)) {
            return false;
        }
        return authorizations.getPassword().equals(password);
    }

    public boolean authAccAdmin(String name, String password) {
        Authorizations authorizations = authRepos.findByName(name);
        if (authorizations == null || authorizations.getRole().getId().equals(2)) {
            return false;
        }
        return authorizations.getPassword().equals(password);
    }

    public boolean regAcc(Authorizations authorizations) {
        Authorizations authorization = authRepos.findByName(authorizations.getName());
        if (authorization != null) {
            return false;
        }
        authRepos.save(authorizations);
        return true;
    }

    public List<Authorizations> selectAuth() {
        return authRepos.findAll();
    }

    public Authorizations createAcc(Authorizations authorizations) {
        return authRepos.save(authorizations);
    }

    public Authorizations updateAcc(Integer id, Authorizations authorizations) {
        Authorizations auth = authRepos.findById(id)
                .orElseThrow(() -> new RuntimeException("Authorizations is not found!"));
        auth.setName(authorizations.getName());
        auth.setRole(authorizations.getRole());
        auth.setEmail(authorizations.getEmail());
        auth.setPassword(authorizations.getPassword());

        return authRepos.save(auth);
    }

    public void deleteAcc(Integer id) {
        authRepos.deleteById(id);
    }
}
