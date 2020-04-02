package com.Ustora.book.proxies;

import com.Ustora.book.configurations.FeignConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "zuul-server", contextId="userProxy", configuration= FeignConfig.class, url = "http://localhost:9004" )
@RibbonClient(name = "user")
public interface UserProxy {

   /** @GetMapping(value = "/user/compte/{id}/moncompte")
    UserBean getUser(@PathVariable("id") Long id);*/
}
