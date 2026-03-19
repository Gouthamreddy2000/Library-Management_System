package com.goutham.LMS.service;

import com.goutham.LMS.entity.User;

public interface UserService {
    User save(User theUser);
    User findByEmail(String email);
}
