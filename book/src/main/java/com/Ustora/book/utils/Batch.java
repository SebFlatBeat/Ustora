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

    @Scheduled(cron = "0 0 8 * * *" )
    public void sendingLateMail() {

        mail.sendMessage();
    }}
