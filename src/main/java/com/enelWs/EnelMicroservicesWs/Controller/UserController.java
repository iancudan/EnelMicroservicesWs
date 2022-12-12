package com.enelWs.EnelMicroservicesWs.Controller;

import com.enelWs.EnelMicroservicesWs.Entity.User;
import com.enelWs.EnelMicroservicesWs.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @PostMapping("/addUser")
    public User addUser(User user){
        User newUser = new User();
        if(user.getEmail().contains("@enel.com"))
            newUser = customUserDetailsService.addUser(user);

        return newUser;
    }

    @PostMapping("/updateUser")
    public List<User> updateUser(User user){
        return customUserDetailsService.updateUser(user);
    }

    @PostMapping("/resetPassword")
    public User resetPassword(User user){
        return customUserDetailsService.resetPassword(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return customUserDetailsService.findAll();
    }

    @PostMapping("/deleteUser")
    public List<User> deleteUser(User user){
        return customUserDetailsService.deleteUser(user);
    }

}
