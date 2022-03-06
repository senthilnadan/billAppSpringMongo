package com.vscube.billApp.Service.controller;

import com.vscube.billApp.Service.exception.VSCubeException;
import com.vscube.billApp.Service.repos.UserRepository;
import com.vscube.billApp.core.EmptyJsonBody;
import com.vscube.billApp.domain.book.Author;
import com.vscube.billApp.domain.book.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("app")
public class UserRestController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("users/{emailId}")
    public User getUSerByEmailId(@PathVariable(required = true, name = "emailId") String emailId){
        Optional<User> userOptional = userRepository.findByEmail(emailId);
        if(userOptional.isPresent()){
            return userOptional.get();
        }else{
            throw new VSCubeException(" User Not Found ");
        }
    }

    @PostMapping("users")
    public User registerUser(@RequestBody  User user){
        Optional<User> userOptional =  userRepository.findByEmail(user.getEmail());
        if (userOptional.isPresent()) throw new VSCubeException("User Already Exisits");
        user.setId(0l);
        User insertedUser = userRepository.insert(user);
        return insertedUser;
    }
}
