package com.Ustora.book.controller;

import com.Ustora.book.dao.BookDao;
import com.Ustora.book.entities.Book;
import com.Ustora.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     *
     * @param page
     * @param size
     * @return bookList
     */
    @GetMapping("/allBook")
    public Page<Book> books(@RequestParam(name="page",defaultValue = "0") int page,
                            @RequestParam(name = "size",defaultValue = "20") int size){
        Sort sort = Sort.by(Sort.Order.asc("auteurPrincipalNom"));
        Page<Book> bookList = bookService.findAll(PageRequest.of(page, size, sort));
        return bookList;
    }

    /**
     *
     * @return books
     */
    @GetMapping("/allBookList")
    public List<Book> allBookList(){
        List<Book> books = bookService.findAll();
        return books;
    }

    /**
     *
     * @return titre
     */
    @GetMapping("/find/titre")
    public List<String> findTitre(){
        List<String> titre = bookService.findDistinctByTitre();
        return titre;
    }

    /**
     *
     * @return auteurNom
     */
    @GetMapping("/find/auteurNom")
    public List<String> findAuteurNom(){
        List<String> auteurNom = bookService.findDistinctByAuteurPrincipalNom();
        return auteurNom;
    }

    /**
     *
     * @return auteurPrenom
     */
    @GetMapping("/find/auteurPrenom")
    public List<String> findAuteurPrenom(){
        List<String> auteurPrenom = bookService.findDistinctByAuteurPrincipalPrenom();
        return auteurPrenom;
    }

    /**
     *
     * @return editeur
     */
    @GetMapping("/find/editeur")
    public List<String> findEditeur(){
        List<String> editeur = bookService.findDistinctByEditeur();
        return editeur;
    }

    /**
     *
     * @return anneeEdition
     */
    @GetMapping("/find/anneeEdition")
    public List<String> findAnneeEdition(){
        List<String> anneeEdition = bookService.findDistinctByAnneeEdition();
        return anneeEdition;
    }

    /**
     *
     * @return section
     */
    @GetMapping("/find/section")
    public List<String> findSection(){
        List<String> section = bookService.findDistinctBySection();
        return section;
    }

    /**
     *
     * @return isbn
     */
    @GetMapping("/find/isbn")
    public List<String> findIsbn(){
        List<String> isbn = bookService.findDistinctByIsbn();
        return isbn;
    }

    /**
     *
     * @param titre
     * @param searchBook
     * @return
     */

    //Est-il obligatoire de faire un return? peut-etre mettre un void
    @PostMapping("/search/titre/{titre}")
    public List<Book> searchTitre(@PathVariable("titre") String titre, @RequestBody List<Book> searchBook){
        return bookService.findByTitre(titre, searchBook);
    }

    @PostMapping("/search/auteurPrincipalNom/{auteurNom}")
    public List<Book> searchAuteurNom(@PathVariable("auteurNom") String auteurNom, @RequestBody List<Book> searchBook){
        return bookService.findByAuteurPrincipalNom(auteurNom, searchBook);
    }

    @PostMapping("/search/auteurPrincipalPrenom/{auteurPrenom}")
    public List<Book> searchAuteurPrenom(@PathVariable("auteurPrenom") String auteurPrenom, @RequestBody List<Book> searchBook){
        return bookService.findByAuteurPrincipalPrenom(auteurPrenom, searchBook);
    }

    @PostMapping("/search/editeur/{editeur}")
    public List<Book> searchEditeur(@PathVariable("editeur") String editeur, @RequestBody List<Book> searchBook){
        return bookService.findByEditeur(editeur, searchBook);
    }

    @PostMapping("/search/anneeEdition/{anneeEdition}")
    public List<Book> searchAnneeEdition(@PathVariable("anneeEdition") String anneeEdition, @RequestBody List<Book> searchBook){
        return bookService.findByAnneeEdition(anneeEdition, searchBook);
    }

    @PostMapping("/search/section/{section}")
    public List<Book> searchSection(@PathVariable("section") String section, @RequestBody List<Book> searchBook){
        return bookService.findBySection(section, searchBook);
    }

    @PostMapping("/search/isbn/{isbn}")
    public List<Book> searchIsbn(@PathVariable("isbn") String isbn, @RequestBody List<Book> searchBook){
        return bookService.findByIsbn(isbn, searchBook);
    }
}
