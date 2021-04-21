package com.webetapi.api.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="DATE_DE_SORTIE")
    private String date_de_sortie;

    @Column(name="RATING")
    private String rating;

    @Column(name="NOM")
    private String nom;

    @Column(name="COUNTRY_CODE")
    private Integer country_code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate_de_sortie() {
        return date_de_sortie;
    }

    public void setDate_de_sortie(String date_de_sortie) {
        this.date_de_sortie = date_de_sortie;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCountry_code() {
        return country_code;
    }

    public void setCountry_code(Integer country_code) {
        this.country_code = country_code;
    }
}
