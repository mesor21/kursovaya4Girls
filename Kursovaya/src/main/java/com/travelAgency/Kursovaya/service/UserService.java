package com.travelAgency.Kursovaya.service;

import com.travelAgency.Kursovaya.entity.Role;
import com.travelAgency.Kursovaya.entity.UserSystem;
import com.travelAgency.Kursovaya.repository.RoleRepository;
import com.travelAgency.Kursovaya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    public UserSystem findUserById(Long userId) {
        Optional<UserSystem> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new UserSystem());
    }

    public UserSystem findUserByLogin(String login){
        return userRepository.findByLogin(login);
    }

    public boolean saveUser(UserSystem user){//согласен, роль так делать очень грамостко, но всё же
        UserSystem userFromeBD = userRepository.findByLogin(user.getLogin());
        if(userFromeBD!=null) {
            return false;
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
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
    public Role findRole(String roleName){
        return roleRepository.findByRole(roleName);
    }

    public UserSystem findByLogin(String login){
        return userRepository.findByLogin(login);
    }
    public void ListAllUsers(){
        int len= userRepository.findAll().size();
        for(int i = 0; i<len; i++){
            System.out.println(userRepository.findAll().get(i).getLogin()+" "+userRepository.findAll().get(i).getPassword());
        }
    }
    public void DeleteAllUsers(Boolean uShure){
        if(uShure){
            int len= userRepository.findAll().size();
            for(int i=0; i<len-1; i++){
                UserSystem x=userRepository.findAll().get(i);
                userRepository.deleteById(x.getId());
            }
        }
    }
    public void ListAllRole(){
        int len= roleRepository.findAll().size();
        for(int i = 0; i<len; i++){
            System.out.println(roleRepository.findAll().get(i).getRole());
        }

    }
}
