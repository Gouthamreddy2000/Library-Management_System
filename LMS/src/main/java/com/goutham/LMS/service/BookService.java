package com.goutham.LMS.service;

import com.goutham.LMS.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book save(Book theBook);

    Book findById(int theId);

    void deleteById(int theId);

}
