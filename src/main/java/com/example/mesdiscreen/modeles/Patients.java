package com.example.mesdiscreen.modeles;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * Modele patient
 */

@Entity
@Table(name = "patients")
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpatients")
    private Integer idpatients;

    @Column(name = "prenom")
    @NotBlank
    private String prenom;

    @Column(name = "nom")
    @NotBlank
    private String nom;

    @Column(name = "datenaissance")
    @NotBlank
    private LocalDate datenaissance;

    @Column(name = "genre")
    @NotBlank
    private String genre;

    @Column(name = "adresse")
    @NotBlank
    private String adresse;

    @Column(name = "telephone")
    @NotBlank
    private String telephone;


    public Patients() {
    }

    public Patients(Integer idpatients, @NotBlank String prenom, @NotBlank String nom, @NotBlank LocalDate datenaissance, @NotBlank String genre, @NotBlank String adresse, @NotBlank String telephone) {
        this.idpatients = idpatients;
        this.prenom = prenom;
        this.nom = nom;
        this.datenaissance = datenaissance;
        this.genre = genre;
        this.adresse = adresse;
        this.telephone = telephone;
    }



    public Integer getIdpatients() {
        return idpatients;
    }

    public void setIdpatients(Integer idpatients) {
        this.idpatients = idpatients;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(LocalDate datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
