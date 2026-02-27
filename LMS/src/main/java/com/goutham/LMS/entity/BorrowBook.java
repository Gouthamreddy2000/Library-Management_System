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
    private int user_id;

    @Column(name="book_id")
    private int book_id;
    @Column(name="borrowed_date")
    private LocalDateTime borrowed_date;
    @Column(name="due_date")
    private LocalDateTime due_date;
    @Column(name="returned_date")
    private LocalDateTime returned_date;

    private BorrowBook(){

    }

    public BorrowBook(int id, int user_id, int book_id, LocalDateTime borrowed_date, LocalDateTime due_date, LocalDateTime returned_date) {
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.borrowed_date = borrowed_date;
        this.due_date = due_date;
        this.returned_date = returned_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
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

    @Override
    public String toString() {
        return "BorrowBook{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", book_id=" + book_id +
                ", borrowed_date=" + borrowed_date +
                ", due_date=" + due_date +
                ", returned_date=" + returned_date +
                '}';
    }
}
