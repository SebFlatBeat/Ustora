package com.Ustora.book.controller;

import com.Ustora.book.dao.BookDao;
import com.Ustora.book.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookDao bookDao;

    @GetMapping("/allBook")
    public List <Book> allBook() {
        List<Book> bookList = bookDao.findAll();
        return bookList;
    }
}
