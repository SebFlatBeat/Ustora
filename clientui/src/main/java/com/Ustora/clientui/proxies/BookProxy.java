package com.Ustora.clientui.proxies;

import com.Ustora.clientui.beans.BookBean;
import com.Ustora.clientui.configurations.FeignConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "zuul-server", contextId="bookProxy", configuration= FeignConfig.class, url = "http://localhost:9004")
@RibbonClient(name = "book")
public interface BookProxy {

    @GetMapping(value = "/book/allBook")
    List<BookBean> allBook();

}
