package com.Ustora.book.dao;

import com.Ustora.book.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookDao extends PagingAndSortingRepository<Book, Long> {
    @Override
    Page<Book> findAll(Pageable pageable);
}
