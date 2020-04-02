package com.Ustora.user.controller;

import com.Ustora.user.dao.UserDao;
import com.Ustora.user.entities.UserBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/all-account")
    public List<UserBook> userBookList (){
        List<UserBook> userBooks = userDao.findAll();

        return userBooks;
    }

    @GetMapping("/{username}/login")
    public Optional<UserBook> login (@PathVariable String username){
       Optional<UserBook> userBook = userDao.findByUsername(username);
        return userBook;
    }

    @PostMapping(value = "/registerPost")
    public UserBook register(@RequestBody UserBook userBook) {
        userDao.save(userBook);
        return userBook;
    }


}
