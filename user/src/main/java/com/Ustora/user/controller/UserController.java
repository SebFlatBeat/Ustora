package com.Ustora.user.controller;

import com.Ustora.user.entities.UserBook;
import com.Ustora.user.entities.UserRole;
import com.Ustora.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all-account")
    public List<UserBook> userBookList (){
        List<UserBook> userBooks = userService.findAll();

        return userBooks;
    }

    @GetMapping("/{username}/login")
    public Optional<UserBook> login (@PathVariable String username){
       Optional<UserBook> userBook = userService.findByUsername(username);
        return userBook;
    }

    @PostMapping(value = "/registerPost")
    public UserBook register(@RequestBody UserBook userBook) {
        userBook.grantAuthority(UserRole.USER);
        userService.save(userBook);
        return userBook;
    }

    @GetMapping("/find/{username}")
    public Optional <UserBook> findCurrentUser(@PathVariable String username){
        Optional<UserBook> userBook =userService.findByUsername(username);
        return userBook;
    }
    @GetMapping("/find/id")
    public Optional<UserBook> findById (Long id) {
        Optional<UserBook> userBook = userService.findById(id);
        return userBook;
    }
}
