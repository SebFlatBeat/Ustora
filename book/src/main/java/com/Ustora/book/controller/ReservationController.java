package com.Ustora.book.controller;

import com.Ustora.book.beans.UserBean;
import com.Ustora.book.dao.BookDao;
import com.Ustora.book.dao.ReservationDao;
import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.proxies.UserProxy;
import com.Ustora.book.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserProxy userProxy;


    @GetMapping("/reservation")
    public List<Reservation> findReservation(@RequestParam Long userId){
        List<Reservation> reservationList = reservationService.findReservationsByUserBookId(userId);
        return reservationList;
    }

    @PostMapping("/save/reservation")
    public void  saveReservation(@RequestParam Long bookId, @RequestParam Long userId){
        Reservation reservation = new Reservation();
        Date aujourdhui = new Date(Calendar.getInstance().getTime().getTime());
        reservation.setBorrowing(aujourdhui);
        reservation.setEndBorrowing(reservationService.add4Weeks(reservation.getBorrowing()));
        reservation.setExtend(false);
        reservation.setUserBookId(userId);
        Optional<Book> book = bookDao.findById(bookId);
        reservation.setBook(book.get());
        book.get().setNbreExemplaire(book.get().getNbreExemplaire()-1);
        reservationService.save(reservation);

    }
}
