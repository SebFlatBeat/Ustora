package com.Ustora.book.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;


@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Size( max = 250, min = 3, message = "Le nom du livre doit contenir entre 3 et 50 charactères." )
    @NotEmpty( message = "Veuillez saisir le nom de livre" )
    private String titre;

    @Size( max = 100)
    private String auteurPrincipalNom;

    @Size( max = 100)
    private String auteurPrincipalPrenom;

    @NotNull
    private String isbn;
    @NotNull
    private String editeur;
    @NotNull
    private String anneeEdition;
    @NotNull
    private String section;

    private int nbreExemplaire;


    public Book() {

    }

    /**
     *
     * @param id
     * @param titre
     * @param auteurPrincipalNom
     * @param auteurPrincipalPrenom
     * @param isbn
     * @param editeur
     * @param anneeEdition
     * @param section
     * @param nbreExemplaire
     */
    public Book(Long id,
                @Size( max = 100, min = 3, message = "Le nom du livre doit contenir entre 3 et 50 charactères." )
                @NotEmpty( message = "Veuillez saisir le nom de livre" )
                        String titre,
                @Size( max = 100, min = 3)
                        String auteurPrincipalNom,
                @Size( max = 100, min = 3)
                        String auteurPrincipalPrenom,
                @NotNull
                        String isbn,
                @NotNull
                        String editeur,
                @NotNull
                        Date anneeEdition,
                @NotNull
                        String section,
                int nbreExemplaire){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteurPrincipalNom() {
        return auteurPrincipalNom;
    }

    public void setAuteurPrincipalNom(String auteurNom) {
        this.auteurPrincipalNom = auteurPrincipalNom;
    }

    public String getAuteurPrincipalPrenom() {
        return auteurPrincipalPrenom;
    }

    public void setAuteurPrincipalPrenom(String auteurPrincipalPrenom) {
        this.auteurPrincipalPrenom = auteurPrincipalPrenom;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getAnneeEdition() {
        return anneeEdition;
    }

    public void setAnneeEdition(String anneeEdition) {
        this.anneeEdition = anneeEdition;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getNbreExemplaire() {
        return nbreExemplaire;
    }

    public void setNbreExemplaire(int nbreExemplaire) {
        this.nbreExemplaire = nbreExemplaire;
    }

    @Override
    public String toString() {
        return "Book [id=" + id +
                ", titre=" + titre +
                ", auteurPrincipalNom=" + auteurPrincipalNom +
                ", auteurPrincipalPrenom=" + auteurPrincipalPrenom +
                ", isbn=" + isbn +
                ", editeur=" + editeur +
                ", anneeEdition=" + anneeEdition +
                ", section=" + section +
                ", nbreExemplaire=" + nbreExemplaire + "]";
    }
}
