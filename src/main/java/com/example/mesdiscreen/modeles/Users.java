package com.example.mesdiscreen.modeles;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idusers")
    private Integer idusers;

    @Column(name = "statut")
    @NotBlank
    private String statut;

    @Column(name = "nom")
    @NotBlank
    private String nom;

    @Column(name = "prenom")
    @NotBlank
    private String prenom;

    @Column(name = "mail")
    @NotBlank
    private String mail;

    @Column(name = "role")
    @NotBlank
    private String role;

    public Users() {
    }

    public Users(Integer idusers, @NotBlank String statut, @NotBlank String nom, @NotBlank String prenom, @NotBlank String mail, @NotBlank String role) {
        this.idusers = idusers;
        this.statut = statut;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.role = role;
    }

    public Integer getIdusers() {
        return idusers;
    }

    public void setIdusers(Integer idusers) {
        this.idusers = idusers;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
