package com.Ustora.book.dao;

import com.Ustora.book.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationDao extends JpaRepository<Reservation, Long> {

   /** List<Reservation> findReservationsByOwner(String username);

    Reservation findReservationsByBookId(Long bookId);*/
}