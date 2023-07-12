package ua.secondhand.secondhand.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.secondhand.secondhand.Models.Roles;
import ua.secondhand.secondhand.Repositories.IRolesRepository;

import javax.management.relation.Role;
import java.util.List;

@Service
public class RolesService {
    private final IRolesRepository rolesRepos;

    @Autowired
    public RolesService(IRolesRepository rolesRepos) {
        this.rolesRepos = rolesRepos;
    }

    public List<Roles> selectRole(){
        return rolesRepos.findAll();
    }

    public Roles createRole(Roles roles){
        return rolesRepos.save(roles);
    }

    public Roles updateRole(Roles roles, Integer id){
        Roles role = rolesRepos.findById(id).orElseThrow(() -> new RuntimeException("Roles update error!"));
        role.setName(roles.getName());

        return rolesRepos.save(role);
    }

    public void deleteRole(Integer id){
        rolesRepos.deleteById(id);
    }
}
