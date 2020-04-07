package com.Ustora.book.entities;

import org.hibernate.annotations.Cascade;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Reservation implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private Long userBookId;
    private Date borrowing;
    private Date endBorriwing;
    private boolean extend;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Book book;

    public Reservation(){
    }

    /**
     *
     * @param userBookId
     * @param borrowing
     * @param endBorriwing
     * @param extend
     */
    public Reservation(Long userBookId, Date borrowing,Date endBorriwing, boolean extend) {

        this.userBookId = userBookId;
        this.borrowing = borrowing;
        this.endBorriwing = endBorriwing;
        this.extend = extend;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(Date borrowing) {
        this.borrowing = borrowing;
    }

    public Date getEndBorriwing() {
        return endBorriwing;
    }

    public void setEndBorriwing(Date endBorriwing) {
        this.endBorriwing = endBorriwing;
    }

    public boolean isExtend() {
        return extend;
    }

    public void setExtend(boolean extend) {
        this.extend = extend;
    }

    public Long getUserBookId() {
        return userBookId;
    }

    public void setUserBookId(Long userBookId) {
        this.userBookId = userBookId;
    }


    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "Reservation  [id=" + id +
                ", userBookId=" + userBookId +
                ", borrowing=" + borrowing +
                ", extend=" + extend + "]";
    }
}
