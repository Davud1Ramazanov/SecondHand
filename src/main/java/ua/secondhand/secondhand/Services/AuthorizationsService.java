package ua.secondhand.secondhand.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.secondhand.secondhand.Models.Authorizations;
import ua.secondhand.secondhand.Repositories.IAuthorizationsRepository;
import java.util.List;

@Service
public class AuthorizationsService {
    private final IAuthorizationsRepository authRepos;

    @Autowired
    public AuthorizationsService(IAuthorizationsRepository authRepos) {
        this.authRepos = authRepos;
    }

    public List<Authorizations> selectAuth(){
        return authRepos.findAll();
    }

    public Authorizations createAcc(Authorizations authorizations){
        return authRepos.save(authorizations);
    }

    public Authorizations updateAcc(Integer id, Authorizations authorizations){
        Authorizations auth = authRepos.findById(id).orElseThrow(() -> new RuntimeException("Authorizations is error!"));
        auth.setName(authorizations.getName());
        auth.setRole(authorizations.getRole());
        auth.setEmail(authorizations.getEmail());
        auth.setPassword(authorizations.getPassword());

        return authRepos.save(auth);
    }

    public void deleteAcc(Integer id){
        authRepos.deleteById(id);
    }
}
