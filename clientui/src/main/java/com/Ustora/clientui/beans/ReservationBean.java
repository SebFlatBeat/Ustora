package com.Ustora.clientui.beans;

import java.sql.Date;

public class ReservationBean {

    private Long bookId;
    private Long userId;
    private Date borrowing;
    private boolean extend;

    public ReservationBean() {
    }

    public ReservationBean(Long bookId, Long userId, Date borrowing, boolean extend) {
        this.bookId = bookId;
        this.userId = userId;
        this.borrowing = borrowing;
        this.extend = extend;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getBorrowing() {
        return borrowing;
    }

    public void setBorrowing(Date borrowing) {
        this.borrowing = borrowing;
    }

    public boolean isExtend() {
        return extend;
    }

    public void setExtend(boolean extend) {
        this.extend = extend;
    }
}
