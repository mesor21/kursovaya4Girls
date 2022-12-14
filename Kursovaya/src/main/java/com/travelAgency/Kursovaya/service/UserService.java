package com.travelAgency.Kursovaya.service;

import com.travelAgency.Kursovaya.entity.UserSystem;
import com.travelAgency.Kursovaya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService{
    @Autowired
    UserRepository userRepository;

    public UserSystem findUserById(Long userId) {
        Optional<UserSystem> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new UserSystem());
    }

    public UserSystem findUserByLogin(String login){
        return userRepository.findByUsername(login);
    }

    public boolean saveUser(UserSystem user){//согласен, роль так делать очень грамостко, но всё же
        UserSystem userFromeBD = userRepository.findByUsername(user.getLogin());

        if(userFromeBD!=null) {
            return false;
        }
        userRepository.save(user);
        return true;
    }
    public boolean deleteUser(Long ID){
        if(userRepository.findById(ID).isPresent()){
          /*Role roleClass = userService.findRole(role);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if(!userService.saveUser(new UserSystem(roleClass, fullName, login, bCryptPasswordEncoder.encode(password)))){
            return "redirect:/signup";
        }
        System.out.println("New user: "+fullName+"; login: "+login+" "+roleClass.getRole());*/  userRepository.deleteById(ID);
            return true;
        }
        return false;
    }

    public UserSystem findByLogin(String login){
        return userRepository.findByUsername(login);
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
            for(int i = 0; i<len; i++){
                userRepository.deleteById(userRepository.findAll().get(i).getId());
            }
        }
    }
    public void deleteByLogin(String login){
        UserSystem userSystem = userRepository.findByUsername(login);
        userRepository.deleteById(userSystem.getId());
    }
    public List<UserSystem> getAllUsers(){
        return userRepository.findAll();
    }

}
