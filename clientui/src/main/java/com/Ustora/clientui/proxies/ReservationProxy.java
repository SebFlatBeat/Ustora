package com.Ustora.clientui.proxies;

import com.Ustora.clientui.beans.ReservationBean;
import com.Ustora.clientui.configurations.FeignConfig;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "zuul-server", contextId="reservationProxy", configuration= FeignConfig.class, url = "http://localhost:9004")
@RibbonClient(name = "book")
@Component
public interface ReservationProxy {

    @GetMapping( value = "/book/reservation")
    List<ReservationBean> reservationList (@RequestParam Long userId);

    @PostMapping(value = "/book/save/reservation")
    ReservationBean newReservation(@RequestParam Long bookId, @RequestParam Long userId);

}
