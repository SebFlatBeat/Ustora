package com.Ustora.clientui.security;


import com.Ustora.clientui.beans.UserBean;
import com.Ustora.clientui.proxies.UserProxy;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class SecurityController {
    @Autowired
    UserProxy userProxy;

    /**
     *
     * @return redirect:/index"
     */
    @GetMapping("/login?logout")
    public String logout() {

        return "redirect:/";
    }

    /**
     *
     * @return login
     */
    @GetMapping("/login")
    public String login() {

        return "login";
    }

}
