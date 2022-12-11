package com.enelWs.EnelMicroservicesWs.Service;

import com.enelWs.EnelMicroservicesWs.Custom.CustomUserDetails;
import com.enelWs.EnelMicroservicesWs.Entity.User;
import com.enelWs.EnelMicroservicesWs.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User Not Found!");
        return new CustomUserDetails(user);
    }


    public User userPricipalDetails(){
        User user = new User();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            user.setUsername( ((UserDetails)principal).getUsername());
            user.setEmail( ((UserDetails)principal).getUsername());
            user.setRole( ((UserDetails)principal).getUsername());
        } else {
            user = null;
        }

        return user;
    }

    public Boolean isAdmin(){
        User user = userPricipalDetails();
        if(user.getRole().toUpperCase().equals("ADMIN"))
            return true;
        else
            return false;
    }

    public User addUser(User user){
        return userRepository.saveAndFlush(user);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public List<User> deleteUser(User user){
        userRepository.delete(user);
        return userRepository.findAll();
    }

    public List<User> updateUser(User user){
        userRepository.saveAndFlush(user);
        return userRepository.findAll();
    }
    public User resetPassword(User user){
//        String password = new Random().ints(10, 33, 122).collect(StringBuilder::new,
//                        StringBuilder::appendCodePoint, StringBuilder::append)
//                .toString();
//
//        user.setPassword(bCryptPasswordEncoder.encode(password));
        return userRepository.saveAndFlush(user);
    }


}
