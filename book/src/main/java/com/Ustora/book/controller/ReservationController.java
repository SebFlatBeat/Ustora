package com.Ustora.book.controller;

import com.Ustora.book.beans.UserBean;
import com.Ustora.book.dao.BookDao;
import com.Ustora.book.dao.ReservationDao;
import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.proxies.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserProxy userProxy;


    @GetMapping("/reservation")
    public List<Reservation> findReservation(@RequestParam Long userId){
        List<Reservation> reservationList = reservationDao.findReservationsByUserBookId(userId);
        return reservationList;
    }

    @PostMapping("/save/reservation")
    public void  saveReservation(@RequestBody Reservation reservation){
        Date aujourdhui = new Date(Calendar.getInstance().getTime().getTime());
        UserBean currentUser = userProxy.find(SecurityContextHolder.getContext().getAuthentication().getName());
        reservation.setBorrowing(aujourdhui);
        reservation.setEndBorriwing(reservationDao.add4Weeks(reservation.getBorrowing()));
        reservation.setExtend(false);
        reservation.setUserBookId((currentUser.getId()));
        Optional<Book> book = bookDao.findById(reservation.getBook().getId());
        book.get().setNbreExemplaire(book.get().getNbreExemplaire()-1);
        reservationDao.save(reservation);
    }
}
