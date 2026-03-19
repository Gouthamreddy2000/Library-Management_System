package com.goutham.LMS.service;

import com.goutham.LMS.entity.BorrowBook;

public interface BorrowBookService {
    BorrowBook findById(int theId);
    BorrowBook save(BorrowBook theBorrowBook);
    void returnBook(int userId, int bookId);
}
