package com.webetapi.api.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="DATE_DE_SORTIE")
    private String date_de_sortie;

    @Column(name="RATING")
    private String rating;

    @Column(name="NOM")
    private String nom;

    @Column(name="COUNTRY_CODE")
    private Integer country_code;

}
