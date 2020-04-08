package com.Ustora.book.dao;

import com.Ustora.book.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationDao extends JpaRepository<Reservation, Long> {

   List<Reservation> findReservationsByUserBookId ( Long userId);

   Optional<Reservation> findById(Long id);

  Reservation save(Reservation reservation);

    void delete(Reservation reservation);

}
