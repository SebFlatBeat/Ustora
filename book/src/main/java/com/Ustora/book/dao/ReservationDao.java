package com.Ustora.book.dao;

import com.Ustora.book.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


import java.sql.Date;
import java.util.List;

public interface ReservationDao extends JpaRepository<Reservation, Long> {

   List<Reservation> findReservationsByUserBookId ( Long userId);

   Date add4Weeks(Date date);

   Date add8Weeks(Date date);

    /**Reservation findReservationsByBookId(Long bookId);*/
}
