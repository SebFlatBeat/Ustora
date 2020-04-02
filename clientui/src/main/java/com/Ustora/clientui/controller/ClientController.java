package com.Ustora.clientui.controller;

import com.Ustora.clientui.beans.BookBean;
import com.Ustora.clientui.beans.UserBean;
import com.Ustora.clientui.proxies.BookProxy;
import com.Ustora.clientui.proxies.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ClientController {

    @Autowired
    private UserProxy userProxy;

    @Autowired
    private BookProxy bookProxy;

    @GetMapping(value = {"/","/index"})
    public String index(Model modelAllBook) {
        List <BookBean> allBook = bookProxy.allBook();
        modelAllBook.addAttribute("allBook",allBook);
        return "index";
    }

    @GetMapping("/espacePerso")
    public String espacePerso(){

        return "espacePerso";
    }

    @GetMapping("/register")
    public String register(){

        return "register";
    }

    @PostMapping("/registerPost")
    public String registerPost(@ModelAttribute UserBean userBean){
        userProxy.register(userBean);
        return "redirect:/registerSuccess";
    }

}
