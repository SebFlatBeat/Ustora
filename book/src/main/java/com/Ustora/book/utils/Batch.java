package com.Ustora.book.utils;

import com.Ustora.book.beans.UserBean;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.proxies.UserProxy;
import com.Ustora.book.service.ReservationService;
import com.sun.xml.internal.ws.spi.db.DatabindingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class Batch {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    UserProxy userProxy;

    @Autowired
    private Mail mail;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Scheduled(cron = "0 0 8 * * *")
    public void sendingLateMail() {
        logger.info("Démarrage du bacth");
        List<Reservation> reservationList = reservationService.findByEndBorrowingAfter();
        logger.warn("Liste d'utilisateur pour rappel par mail");
        for (Reservation reservation :reservationList) {
            Optional<UserBean> userBeanLate = userProxy.findById(reservation.getUserBookId());
            mail.sendMessage(userBeanLate.get().getEmail());
            logger.warn("mail envoyé");
        }
        logger.info("Fin du traitement Batch");
    }
}
