package com.Ustora.book.controller;

import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import com.Ustora.book.proxies.UserProxy;
import com.Ustora.book.service.BookService;
import com.Ustora.book.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private BookService bookService;

    @Autowired
    private UserProxy userProxy;


    @GetMapping("/reservation")
    public List<Reservation> findReservation(@RequestParam Long userId){
        List<Reservation> reservationList = reservationService.findReservationsByUserBookId(userId);
        return reservationList;
    }

    @PostMapping(value = "/save/reservation")
    public Reservation saveReservation(@RequestParam Long bookId, @RequestParam Long userId){
       List<Reservation> userReservationList = reservationService.findReservationsByUserBookId(userId);
        Reservation reservation = new Reservation();
        userReservationList = userReservationList.stream().filter(reservation1 -> reservation1.getBook().getId().equals(bookId)).collect(Collectors.toList());
        if (userReservationList != null &&  userReservationList.size()>0){
            return null;
        }else {
            Date aujourdhui = new Date(Calendar.getInstance().getTime().getTime());
            reservation.setBorrowing(aujourdhui);
            reservation.setEndBorrowing(reservationService.add4Weeks(reservation.getBorrowing()));
            reservation.setExtend(false);
            reservation.setUserBookId(userId);
            Optional<Book> book = bookService.findById(bookId);
            reservation.setBook(book.get());
            book.get().setNbreExemplaire(book.get().getNbreExemplaire() - 1);
            reservationService.save(reservation);
        }
        return reservation;
    }

    @PostMapping(value = "/delete/reservation")
    public void  deleteReservation (@RequestParam Long id){
        Optional<Reservation> reservation = reservationService.findById(id);
        Optional<Book> book = bookService.findById(reservation.get().getBook().getId());
        book.get().setNbreExemplaire(book.get().getNbreExemplaire() + 1);
        bookService.save(book.get());
        reservationService.delete(reservation.get());
    }

    @PostMapping(value = "/extend/reservation")
    public Optional<Reservation> updateReservation (@RequestParam Long id){
        Optional<Reservation> reservation = reservationService.findById(id);
        reservation.get().setEndBorrowing(reservationService.add8Weeks(reservation.get().getBorrowing()));
        reservation.get().setExtend(true);
        reservationService.save(reservation.get());
        return reservation;
    }
}
