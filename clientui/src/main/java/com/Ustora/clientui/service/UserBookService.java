package com.Ustora.clientui.service;

import com.Ustora.clientui.beans.UserBean;
import com.Ustora.clientui.proxies.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserBookService implements UserDetailsService {
    @Autowired
    UserProxy userProxy;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserBean userBook = userProxy.login(userName);
        if (userBook != null){
            return userBook;
        }else{
            throw new UsernameNotFoundException(String.format("Username[%s] not found"));
        }
    }
}
