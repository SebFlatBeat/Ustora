package com.Ustora.book.entities;

import com.Ustora.book.beans.UserBean;
import com.Ustora.book.proxies.UserProxy;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String borrower;
    private String bookReservation;
    private Date borrowing;
    private boolean accepted;

    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Book book;

public Reservation(){
}

    public Reservation(String borrower, String bookReservation, Date borrowing, boolean accepted) {
        this.borrower = borrower;
        this.bookReservation = bookReservation;
        this.borrowing = borrowing;
        this.accepted = accepted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }
    
    public String getBookReservation() {
        return bookReservation;
    }

    public void setBookReservation(String bookReservation) {
        this.bookReservation = bookReservation;
    }

    public Date getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(Date borrowing) {
        this.borrowing = borrowing;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
