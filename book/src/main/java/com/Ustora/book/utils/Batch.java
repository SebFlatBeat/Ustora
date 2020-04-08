package com.Ustora.book.utils;

import com.Ustora.book.beans.UserBean;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.proxies.UserProxy;
import com.Ustora.book.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Batch {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    UserProxy userProxy;

    @Autowired
    private Mail mail;

    @Scheduled(cron = "*//**60 * * * * *")
    public void sendingLateMail(UserBean userBean) {

        mail.sendMessage(userProxy.find(userBean.getEmail()));
    }}
