package com.travelAgency.Kursovaya.service;

import com.travelAgency.Kursovaya.entity.Role;
import com.travelAgency.Kursovaya.entity.UserSystem;
import com.travelAgency.Kursovaya.repository.RoleRepository;
import com.travelAgency.Kursovaya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {
    @PersistenceContext
    EntityManager em;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserSystem findUserById(Long userId) {
        Optional<UserSystem> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new UserSystem());
    }
    public boolean saveUser(UserSystem user, String role){//согласен, роль так делать очень грамостко, но всё же
        UserSystem userFromeBD = userRepository.findByLogin(user.getLogin());
        if(userFromeBD!=null) {
            return false;
        }
        user.setRoles(Collections.singleton(new Role(role)));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
    public boolean deleteUser(Long ID){
        if(userRepository.findById(ID).isPresent()){
            userRepository.deleteById(ID);
            return true;
        }
        return false;
    }
}
