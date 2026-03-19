package com.goutham.LMS.dao;

import com.goutham.LMS.entity.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowBookRepository extends JpaRepository<BorrowBook, Integer> {
    Optional<BorrowBook> findByUserIdAndBookIdAndStatus(
            int user_id,
            int book_id,
            BorrowBook.BorrowStatus status
    );

}
