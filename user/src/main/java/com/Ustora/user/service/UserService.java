package com.Ustora.user.service;

import com.Ustora.user.dao.UserDao;
import com.Ustora.user.entities.UserBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public Optional<UserBook> findByUsername(String username){
        return userDao.findByUsername(username);
    }
}
