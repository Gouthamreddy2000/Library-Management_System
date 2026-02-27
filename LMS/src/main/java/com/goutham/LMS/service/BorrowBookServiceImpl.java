package com.goutham.LMS.service;

import com.goutham.LMS.dao.BorrowBookRepository;
import com.goutham.LMS.entity.Book;
import com.goutham.LMS.entity.BorrowBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowBookServiceImpl implements BorrowBookService{
    private BorrowBookRepository borrowBookRepository;

    public BorrowBookServiceImpl(BorrowBookRepository theBorrowBookRepository){
        borrowBookRepository=theBorrowBookRepository;
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
}
