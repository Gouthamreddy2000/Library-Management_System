package com.goutham.LMS.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="borrowed_books")
public class BorrowBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user_id")
    private int userId;

    @Column(name="book_id")
    private int bookId;
    @Column(name="borrowed_date")
    private LocalDateTime borrowed_date;
    @Column(name="due_date")
    private LocalDateTime due_date;
    @Column(name="returned_date")
    private LocalDateTime returned_date;

    public enum BorrowStatus {
        BORROWED,
        RETURNED,
        OVERDUE
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BorrowStatus status;

    public BorrowBook(){

    }

    public BorrowBook(int id, int userId, int bookId, LocalDateTime borrowed_date, LocalDateTime due_date, LocalDateTime returned_date, BorrowStatus status) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowed_date = borrowed_date;
        this.due_date = due_date;
        this.returned_date = returned_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getBorrowed_date() {
        return borrowed_date;
    }

    public void setBorrowed_date(LocalDateTime borrowed_date) {
        this.borrowed_date = borrowed_date;
    }

    public LocalDateTime getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDateTime due_date) {
        this.due_date = due_date;
    }

    public LocalDateTime getReturned_date() {
        return returned_date;
    }

    public void setReturned_date(LocalDateTime returned_date) {
        this.returned_date = returned_date;
    }

    public BorrowStatus getStatus() {
        return status;
    }

    public void setStatus(BorrowStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BorrowBook{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", borrowed_date=" + borrowed_date +
                ", due_date=" + due_date +
                ", returned_date=" + returned_date +
                ", status=" + status +
                '}';
    }
}
