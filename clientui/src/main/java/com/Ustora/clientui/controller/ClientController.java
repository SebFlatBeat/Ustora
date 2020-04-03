package com.Ustora.clientui.controller;

import com.Ustora.clientui.beans.BookBean;
import com.Ustora.clientui.beans.UserBean;
import com.Ustora.clientui.dto.RestResponsePage;
import com.Ustora.clientui.proxies.BookProxy;
import com.Ustora.clientui.proxies.UserProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class ClientController {

    @Autowired
    private UserProxy userProxy;

    @Autowired
    private BookProxy bookProxy;

    @GetMapping(value = {"/","/index"})
    public String index(Model modelAllBook, Model modelPagination, Model modelAllBookList,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "20") int size,
                        @RequestParam Optional<String> titre, Model modelDistinctTitre,
                        @RequestParam Optional<String> auteurPrincipalNom, Model modelDistinctAuteurNom,
                        @RequestParam Optional<String> auteurPrincipalPrenom, Model modelDistinctAuteurPrenom,
                        @RequestParam Optional<String> editeur, Model modelDistinctEditeur,
                        @RequestParam Optional<String> anneeEdition, Model modelDistinctAnneeEdition,
                        @RequestParam Optional<String> section, Model modelDistinctSection,
                        @RequestParam Optional<String> isbn, Model modelDistinctIsbn,
                        Model modelSearchBook, Model modelSearchBookPage, Model modelPaginationSearchBook
                        ) {
        RestResponsePage <BookBean> allBook = bookProxy.allBook(page);
        List<BookBean> allBookList = bookProxy.allBookList();
        modelAllBookList.addAttribute("allBookList",allBookList);
        modelAllBook.addAttribute("allBook",allBook.getContent());
        modelPagination.addAttribute("paginationBook",allBook);


        List<String> titres = bookProxy.findTitre();
        modelDistinctTitre.addAttribute("titres",titres);

        List<String> auteurNoms = bookProxy.findAuteurNom();
        modelDistinctAuteurNom.addAttribute("auteurNoms",auteurNoms);

        List<String> auteurPrenoms = bookProxy.findAuteurPrenom();
        modelDistinctAuteurPrenom.addAttribute("auteurPrenoms", auteurPrenoms);

        List<String> editeurs = bookProxy.findEditeur();
        modelDistinctEditeur.addAttribute("editeurs",editeurs);

        List<String> anneeEditions = bookProxy.findAnneeEdition();
        modelDistinctAnneeEdition.addAttribute("anneeEditions",anneeEditions);

        List<String> sections = bookProxy.findSection();
        modelDistinctSection.addAttribute("sections",sections);

        List<String> isbns = bookProxy.findIsbn();
        modelDistinctIsbn.addAttribute("isbns",isbns);

        List<BookBean> searchBook = bookProxy.allBookList();

        if(titre.isPresent() && !titre.get().isEmpty() && !searchBook.isEmpty()){
            searchBook = bookProxy.searchTitre(titre.get(),searchBook);
        }

        if(auteurPrincipalNom.isPresent() && !auteurPrincipalNom.get().isEmpty()&& !searchBook.isEmpty()){
            searchBook = bookProxy.searchAuteurNom(auteurPrincipalNom.get(),searchBook);
        }
        if(auteurPrincipalPrenom.isPresent() && !auteurPrincipalPrenom.get().isEmpty() && !searchBook.isEmpty()){
            searchBook = bookProxy.searchAuteurPrenom(auteurPrincipalPrenom.get(),searchBook);
        }
        if (editeur.isPresent() && !editeur.get().isEmpty() && !searchBook.isEmpty()){
            searchBook = bookProxy.searchEditeur(editeur.get(),searchBook);
        }
        if(anneeEdition.isPresent() && !anneeEdition.get().isEmpty()  &&  !searchBook.isEmpty()){
            searchBook = bookProxy.searchAnneeEdition(anneeEdition.get(),searchBook);
        }
        if(section.isPresent() && !section.get().isEmpty()  && !searchBook.isEmpty()){
            searchBook = bookProxy.searchSection(section.get(),searchBook);
        }
        if(isbn.isPresent() && !isbn.get().isEmpty()   && !searchBook.isEmpty()){
            searchBook = bookProxy.searchIsbn(isbn.get(),searchBook);
        }
        Sort sort = Sort.by(
                Sort.Order.asc("auteurPrincpalNom")
        );
        Pageable pageable = PageRequest.of(0,20, sort);
        Page<BookBean> searchBookPage = new PageImpl<>(searchBook,pageable,searchBook.size());
        modelSearchBook.addAttribute("searchBook",searchBook);
        modelSearchBookPage.addAttribute("searchBookPage",searchBookPage);
        modelPaginationSearchBook.addAttribute("paginationSearchBook", searchBookPage);
        return "index";
    }

    @GetMapping("/espacePerso")
    public String espacePerso(){

        return "espacePerso";
    }

    @GetMapping("/register")
    public String register(){

        return "register";
    }

    @PostMapping("/registerPost")
    public String registerPost(@ModelAttribute UserBean userBean){
        userProxy.register(userBean);
        return "redirect:/registerSuccess";
    }

}
