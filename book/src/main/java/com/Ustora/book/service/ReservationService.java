package com.Ustora.book.service;


import com.Ustora.book.dao.ReservationDao;
import com.Ustora.book.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationDao reservationDao;

   public List<Reservation> findReservationsByUserBookId (Long userId){
        return reservationDao.findReservationsByUserBookId(userId);
    }

    public java.util.Date add4Weeks(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, 4);
        return calendar.getTime();
    }


    public java.util.Date add8Weeks(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, 8);
        return calendar.getTime();
    }

    public void save (Reservation reservation){
        reservationDao.save(reservation);
   }
}
