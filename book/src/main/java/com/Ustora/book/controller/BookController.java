package com.Ustora.book.controller;

import com.Ustora.book.dao.BookDao;
import com.Ustora.book.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private EntityLinks links;

    @GetMapping("/allBook")
    public Page<Book> books(@RequestParam(name="page",defaultValue = "0") int page,
                            @RequestParam(name = "size",defaultValue = "20") int size){
        Sort sort = Sort.by(Sort.Order.asc("auteurPrincipalNom"));
        Page<Book> bookList = bookDao.findAll(PageRequest.of(page, size, sort));
        return bookList;
    }
}
