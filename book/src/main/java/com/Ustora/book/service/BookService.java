package com.Ustora.book.service;

import com.Ustora.book.dao.BookDao;
import com.Ustora.book.entities.Book;
import com.Ustora.book.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    public List<String> findDistinctByTitre() {
        return bookDao.findDistinctByTitre();
    }

    public List<String> findDistinctByAuteurPrincipalNom() {
        return bookDao.findDistinctByAuteurPrincipalNom();
    }

    public List<String> findDistinctByAuteurPrincipalPrenom() {
        return bookDao.findDistinctByAuteurPrincipalPrenom();
    }

    public List<String> findDistinctByEditeur() {
        return bookDao.findDistinctByEditeur();
    }

    public List<String> findDistinctByAnneeEdition() {
        return bookDao.findDistinctByAnneeEdition();
    }

    public List<String> findDistinctBySection() {
        return bookDao.findDistinctBySection();
    }

    public List<String> findDistinctByIsbn() {
        return bookDao.findDistinctByIsbn();
    }

    public List<Book> findByTitre(@Param("titre") String titre, @Param("listBook") List<Book> bookList) {
        return bookDao.findByTitre(titre, bookList);
    }

    public List<Book> findByAuteurPrincipalNom(@Param("auteurPrincipalNom") String auteurPrincipalNom, @Param("listBook") List<Book> bookList) {
        return bookDao.findByAuteurPrincipalNom(auteurPrincipalNom, bookList);
    }

    public List<Book> findByAuteurPrincipalPrenom(@Param("auteurPrincipalPrenom") String auteurPrincipalPrenom, @Param("listBook") List<Book> bookList) {
        return bookDao.findByAuteurPrincipalPrenom(auteurPrincipalPrenom, bookList);
    }

    public List<Book> findByEditeur(@Param("editeur") String editeur, @Param("listBook") List<Book> bookList) {
        return bookDao.findByEditeur(editeur, bookList);
    }

    public List<Book> findByAnneeEdition(@Param("anneeEdition") String anneeEdition, @Param("listBook") List<Book> bookList) {
        return bookDao.findByAnneeEdition(anneeEdition, bookList);
    }

    public List<Book> findBySection(@Param("section") String section, @Param("listBook") List<Book> bookList) {
        return bookDao.findBySection(section, bookList);
    }

    public List<Book> findByIsbn(@Param("isbn") String isbn, @Param("listBook") List<Book> bookList) {
        return bookDao.findByIsbn(isbn, bookList);
    }

    public Page<Book> findAll(Pageable pageable) {
        return bookDao.findAll(pageable);
    }

    public  List<Book> findAll(){
        return bookDao.findAll();
    }

    public Optional<Book> findById (Long bookId){
        return bookDao.findById(bookId);
    }

    public void save (Book book){
        bookDao.save(book);
    }
}
