package com.goutham.LMS.dao;

import com.goutham.LMS.entity.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowBookRepository extends JpaRepository<BorrowBook, Integer> {
}
