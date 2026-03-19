package com.goutham.LMS.service;

import com.goutham.LMS.dao.BookRepository;
import com.goutham.LMS.dao.BorrowBookRepository;
import com.goutham.LMS.entity.Book;
import com.goutham.LMS.entity.BorrowBook;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BorrowBookServiceImpl implements BorrowBookService{
    private BorrowBookRepository borrowBookRepository;
    private BookService bookService;
    private BookRepository bookRepository;

    public BorrowBookServiceImpl(BorrowBookRepository theBorrowBookRepository, BookService theBookService, BookRepository theBookRepository){
        borrowBookRepository=theBorrowBookRepository;
        bookService=theBookService;
        bookRepository=theBookRepository;
    }
    @Override
    public BorrowBook findById(int theId) {
        Optional<BorrowBook> result= borrowBookRepository.findById(theId);
        BorrowBook theBorrowBook = null;

        if (result.isPresent()) {
            theBorrowBook = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theBorrowBook;
    }

    @Override
    public BorrowBook save(BorrowBook theBorrowBook) {
        return borrowBookRepository.save(theBorrowBook);
    }

    @Override
    @Transactional
    public void returnBook(int userId, int bookId) {
        BorrowBook borrowBook = borrowBookRepository
                .findByUserIdAndBookIdAndStatus(
                        userId,
                        bookId,
                        BorrowBook.BorrowStatus.BORROWED
                )
                .orElseThrow(() -> new RuntimeException("No borrowed record found"));

        borrowBook.setStatus(BorrowBook.BorrowStatus.RETURNED);
        borrowBook.setReturned_date(LocalDateTime.now());

        Book book = bookService.findById(bookId);

        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);
        borrowBookRepository.save(borrowBook);
    }

}
