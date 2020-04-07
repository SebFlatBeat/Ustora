package com.Ustora.book.dao;

import com.Ustora.book.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Date;
import java.util.List;

public interface ReservationDao extends JpaRepository<Reservation, Long> {

   List<Reservation> findReservationsByUserBookId ( Long userId);


    /**Reservation findReservationsByBookId(Long bookId);*/
}
