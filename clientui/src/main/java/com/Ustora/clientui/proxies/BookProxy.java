package com.Ustora.clientui.proxies;

import com.Ustora.clientui.beans.BookBean;
import com.Ustora.clientui.configurations.FeignConfig;
import com.Ustora.clientui.dto.RestResponsePage;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "zuul-server", contextId="bookProxy", configuration= FeignConfig.class, url = "http://localhost:9004")
@RibbonClient(name = "book")
public interface BookProxy {

    @GetMapping(value = "/book/allBook")
    RestResponsePage <BookBean> allBook(@RequestParam int page);

    @GetMapping(value = "/book/allBookList")
    List<BookBean> allBookList();

    @GetMapping("/book/find/titre")
    List<String> findTitre();

    @GetMapping("/book/find/auteurNom")
    List<String> findAuteurNom();

    @GetMapping("/book/find/auteurPrenom")
    List<String> findAuteurPrenom();

    @GetMapping("/book/find/editeur")
    List<String> findEditeur();

    @GetMapping("/book/find/anneeEdition")
    List<String> findAnneeEdition();

    @GetMapping("/book/find/section")
    List<String> findSection();

    @GetMapping("/book/find/isbn")
     List<String> findIsbn();

    @PostMapping("/book/search/auteurNom/{auteurNom}")
    List<BookBean> searchAuteurNom(@PathVariable("auteurNom") String auteurNom, @RequestBody List<BookBean> searchBook);

    @PostMapping("/book/search/titre/{titre}")
    List<BookBean> searchTitre(@PathVariable("titre") String titre, @RequestBody List<BookBean> searchBook);

    @PostMapping("/book/search/auteurPrenom/{auteurPrenom}")
    List<BookBean> searchAuteurPrenom(@PathVariable("auteurPrenom") String auteurPrenom, @RequestBody List<BookBean> searchBook);

    @PostMapping("/book/search/editeur/{editeur}")
    List<BookBean> searchEditeur(@PathVariable("editeur") String editeur, @RequestBody List<BookBean> searchBook);

    @PostMapping("/book/search/anneeEdition/{anneeEdition}")
    List<BookBean> searchAnneeEdition(@PathVariable("anneeEdition") String anneeEdition, @RequestBody List<BookBean> searchBook);

    @PostMapping("/book/search/section/{section}")
    List<BookBean> searchSection(@PathVariable("section") String section, @RequestBody List<BookBean> searchBook);

    @PostMapping("/book/search/isbn/{isbn}")
    List<BookBean> searchIsbn(@PathVariable("isbn") String isbn, @RequestBody List<BookBean> searchBook);
}
