package com.goutham.LMS.dao;

import com.goutham.LMS.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
