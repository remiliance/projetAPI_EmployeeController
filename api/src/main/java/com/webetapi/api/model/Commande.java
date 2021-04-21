package com.webetapi.api.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.CascadeType.REMOVE;


@Entity
@Table(name = "Commande")
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private Long PersonID;

    @OneToOne
    @JoinColumn(name = "MovieID", referencedColumnName = "id")
    private Movie movie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonID() {
        return PersonID;
    }

    public void setPersonID(Long personID) {
        PersonID = personID;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
