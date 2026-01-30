package com.goutham.LMS.service;

import com.goutham.LMS.dao.UserRepository;
import com.goutham.LMS.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
