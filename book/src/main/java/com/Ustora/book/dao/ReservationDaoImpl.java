package com.Ustora.book.dao;

import com.Ustora.book.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationDaoImpl implements ReservationDao{

    @Autowired
    ReservationDao reservationDao;


    public Date add4Weeks(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, 4);
        return calendar.getTime();
    }


    public Date add8Weeks(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_MONTH, 8);
        return calendar.getTime();
    }

    @Override
    public List<Reservation> findReservationsByUserBookId(Long userBookId) {
        return null;
    }

    @Override
    public java.sql.Date add4Weeks(java.sql.Date date) {
        return null;
    }

    @Override
    public java.sql.Date add8Weeks(java.sql.Date date) {
        return null;
    }

    @Override
    public List<Reservation> findAll() {
        return null;
    }

    @Override
    public List<Reservation> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Reservation> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Reservation> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Reservation reservation) {

    }

    @Override
    public void deleteAll(Iterable<? extends Reservation> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Reservation> S save(S s) {
        return null;
    }

    @Override
    public <S extends Reservation> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Reservation> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Reservation> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Reservation> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Reservation getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Reservation> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Reservation> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Reservation> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Reservation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Reservation> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Reservation> boolean exists(Example<S> example) {
        return false;
    }
}
