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

    @GetMapping(value = {"/","/index","/page/{page}"})
    public String index(Model modelAllBook, Model modelPagination, Model modelAllBookList,
                        @PathVariable(required = false) Integer page,
                        @RequestParam(name = "size", defaultValue = "20") int size,
                        @RequestParam Optional<String> titre, Model modelDistinctTitre,
                        @RequestParam Optional<String> auteurNom, Model modelDistinctAuteurNom,
                        @RequestParam Optional<String> auteurPrenom, Model modelDistinctAuteurPrenom,
                        @RequestParam Optional<String> editeur, Model modelDistinctEditeur,
                        @RequestParam Optional<String> anneeEdition, Model modelDistinctAnneeEdition,
                        @RequestParam Optional<String> section, Model modelDistinctSection,
                        @RequestParam Optional<String> isbn, Model modelDistinctIsbn,
                        Model modelSearchBook
                        ) {
        if(page==null){
            page=0;
        }
        RestResponsePage <BookBean> allBook = bookProxy.allBook(page);
        List<BookBean> allBookList = bookProxy.allBookList();
        modelAllBook.addAttribute("allBook",allBook.getContent());
        modelPagination.addAttribute("paginationBook",allBook);
        modelAllBookList.addAttribute("allBookList", allBookList);

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

        if(titre.isPresent() && !searchBook.isEmpty()){
            searchBook = bookProxy.searchTitre(titre.get(),searchBook);
        }

        if(auteurNom.isPresent() && !searchBook.isEmpty()){
            searchBook = bookProxy.searchAuteurNom(auteurNom.get(),searchBook);
        }
        if(auteurPrenom.isPresent() && !searchBook.isEmpty()){
            searchBook = bookProxy.searchAuteurPrenom(auteurPrenom.get(),searchBook);
        }
        if (editeur.isPresent() && !searchBook.isEmpty()){
            searchBook = bookProxy.searchEditeur(editeur.get(),searchBook);
        }
        if(anneeEdition.isPresent()&& !searchBook.isEmpty()){
            searchBook = bookProxy.searchAnneeEdition(anneeEdition.get(),searchBook);
        }
        if(section.isPresent()&& !searchBook.isEmpty()){
            searchBook = bookProxy.searchSection(section.get(),searchBook);
        }
        if(isbn.isPresent()&& !searchBook.isEmpty()){
            searchBook = bookProxy.searchIsbn(isbn.get(),searchBook);
        }
        modelSearchBook.addAttribute("searchBook",searchBook);
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
