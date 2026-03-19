package com.goutham.LMS.service;

import com.goutham.LMS.dao.UserRepository;
import com.goutham.LMS.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository theUserRepository){
        userRepository=theUserRepository;
    }
    @Override
    public User save(User theUser) {
        System.out.println(theUser);
        return userRepository.save(theUser);
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> result=userRepository.findByEmail(email);
        User theUser=null;
        if (result.isPresent()) {
            theUser = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + email);
        }

        return theUser;
    }
}
