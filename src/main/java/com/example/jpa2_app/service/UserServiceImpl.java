package com.example.jpa2_app.service;

import com.example.jpa2_app.entities.Role;
import com.example.jpa2_app.entities.User;
import com.example.jpa2_app.repositories.RoleRepository;
import com.example.jpa2_app.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

//@Component //instancier au demarrage
@Service
@Transactional
@AllArgsConstructor //3eme solution
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

   /* public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }*/

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role); //id generer parBD
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
      //charger a partir BD user et role
        User user=findUserByUserName(userName);
        Role role=findRoleByRoleName(roleName);
        //ajouter
        if(user.getRoles()!=null) {
            user.getRoles().add(role); //je dois faire  arraylist dans classe user sinon va etre null
            // userRepository.save(user); cest pas neccesaire car la methode est transactionnel quand il ajoute et update tout il fait commit
            role.getUsers().add(user);
        }

    }

    @Override
    public User authentificate(String userName, String password) {
        User user =userRepository.findByUserName(userName);
        if (user==null)throw new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad credentials");
    }
}
