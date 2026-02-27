package com.goutham.LMS.service;

import com.goutham.LMS.dao.BookRepository;
import com.goutham.LMS.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository theBookRepository){
        bookRepository=theBookRepository;
    }
    @Override
    public List<Book> findAll() {

        return bookRepository.findAll();
    }

    @Override
    public Book save(Book theBook) {
        return bookRepository.save(theBook);
    }

    @Override
    public Book findById(int theId) {
        Optional<Book> result=bookRepository.findById(theId);
        Book theBook = null;

        if (result.isPresent()) {
            theBook = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theBook;

    }

    @Override
    public void deleteById(int theId) {
      bookRepository.deleteById(theId);
    }

    @Override
    public List<Book> search(String keyword) {
        return bookRepository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCaseOrIsbnContainingIgnoreCase(keyword,keyword,keyword);

    }
}
