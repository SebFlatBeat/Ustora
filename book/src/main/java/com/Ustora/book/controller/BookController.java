package com.Ustora.book.controller;

import com.Ustora.book.dao.BookDao;
import com.Ustora.book.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Sort;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {

    @Autowired
    private BookDao bookDao;

    @GetMapping("/allBook")
    public Page<Book> books(@RequestParam(name="page",defaultValue = "0") int page,
                            @RequestParam(name = "size",defaultValue = "20") int size){
        Sort sort = Sort.by(Sort.Order.asc("auteurPrincipalNom"));
        Page<Book> bookList = bookDao.findAll(PageRequest.of(page, size, sort));
        return bookList;
    }

    @GetMapping("/allBookList")
    public List<Book> allBookList(){
        List<Book> books = bookDao.findAll();
        return books;
    }

    @GetMapping("/find/titre")
    public List<String> findTitre(){
        List<String> titre = bookDao.findDistinctByTitre();
        return titre;
    }

    @GetMapping("/find/auteurNom")
    public List<String> findAuteurNom(){
        List<String> auteurNom = bookDao.findDistinctByAuteurPrincipalNom();
        return auteurNom;
    }

    @GetMapping("/find/auteurPrenom")
    public List<String> findAuteurPrenom(){
        List<String> auteurPrenom = bookDao.findDistinctByAuteurPrincipalPrenom();
        return auteurPrenom;
    }

    @GetMapping("/find/editeur")
    public List<String> findEditeur(){
        List<String> editeur = bookDao.findDistinctByEditeur();
        return editeur;
    }

    @GetMapping("/find/anneeEdition")
    public List<String> findAnneeEdition(){
        List<String> anneeEdition = bookDao.findDistinctByAnneeEdition();
        return anneeEdition;
    }

    @GetMapping("/find/section")
    public List<String> findSection(){
        List<String> section = bookDao.findDistinctBySection();
        return section;
    }

    @GetMapping("/find/isbn")
    public List<String> findIsbn(){
        List<String> isbn = bookDao.findDistinctByIsbn();
        return isbn;
    }

    @PostMapping("/search/titre/{titre}")
    public List<Book> searchTitre(@PathVariable("titre") String titre, @RequestBody List<Book> searchBook){
        return bookDao.findByTitre(titre, searchBook);
    }

}
