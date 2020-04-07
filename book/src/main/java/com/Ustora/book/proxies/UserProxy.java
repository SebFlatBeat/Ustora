package com.Ustora.book.proxies;

import com.Ustora.book.beans.UserBean;
import com.Ustora.book.configurations.FeignConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zuul-server", contextId="userProxy", configuration= FeignConfig.class, url = "http://localhost:9004" )
@RibbonClient(name = "user")
@Component
public interface UserProxy {

    @GetMapping(value = "/user/find/{username}")
    UserBean find(@PathVariable String username);

   /** @GetMapping(value = "/user/{id}")
    UserBean getUser(@PathVariable("id") Long id);
   */
}
