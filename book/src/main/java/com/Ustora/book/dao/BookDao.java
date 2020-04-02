package com.Ustora.book.dao;

import com.Ustora.book.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookDao extends PagingAndSortingRepository<Book, Long> {
    @Override
    Page<Book> findAll(Pageable pageable);

    List<Book> findAll();

    @Query("select distinct book.titre from Book book")
    List<String> findDistinctByTitre();

    @Query("select distinct book.auteurPrincipalNom from Book book")
    List<String> findDistinctByAuteurPrincipalNom();

    @Query("select distinct book.auteurPrincipalPrenom from Book book")
    List<String> findDistinctByAuteurPrincipalPrenom();

    @Query("select distinct book.editeur from Book book")
    List<String> findDistinctByEditeur();

    @Query("select distinct book.anneeEdition from Book book")
    List<String> findDistinctByAnneeEdition();

    @Query("select distinct book.section from Book book")
    List<String> findDistinctBySection();

    @Query("select distinct book.isbn from Book book")
    List<String> findDistinctByIsbn();

    @Query("select distinct book from Book book where book.titre=:titre and book in :listBook")
    List<Book> findByTitre(@Param("titre") String titre, @Param("listBook")List<Book> bookList);

    @Query("select distinct book from Book book where book.auteurPrincipalNom=:auteurPrincipalNom and book in :listBook")
    List<Book> findByAuteurPrincipalNom(@Param("auteurPrincipalNom") String auteurPrincipalNom, @Param("listBook")List<Book> bookList);

    @Query("select distinct book from Book book where book.auteurPrincipalPrenom=:auteurPrincipalPrenom and book in :listBook")
    List<Book> findByAuteurPrincipalPrenom(@Param("auteurPrincipalPrenom") String auteurPrincipalPrenom, @Param("listBook")List<Book> bookList);

    @Query("select distinct book from Book book where book.editeur=:editeur and book in :listBook")
    List<Book> findByEditeur(@Param("editeur") String editeur, @Param("listBook")List<Book> bookList);

    @Query("select distinct book from Book book where book.anneeEdition=:anneeEdition and book in :listBook")
    List<Book> findByAnneeEdition(@Param("anneeEdition") String anneeEdition, @Param("listBook")List<Book> bookList);

    @Query("select distinct book from Book book where book.section=:section and book in :listBook")
    List<Book> findBySection(@Param("section") String section, @Param("listBook")List<Book> bookList);

    @Query("select distinct book from Book book where book.isbn=:section and book in :listBook")
    List<Book> findByIsbn(@Param("isbn") String section, @Param("listBook")List<Book> bookList);
}
