package com.webetapi.api.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "employees")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private String mail;

    //@JsonIgnore
    //information que nous ne souhaitons pas exposer
    private String password;

    @OneToOne(/*orphanRemoval = true,*/ cascade = CascadeType.PERSIST) // Persist va garder l'adresse en base
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

//La table Commande est comme une table de jointure pour récupérer la liste des produits
    @OneToMany(cascade = CascadeType.PERSIST) // => PERSIST supprime tous les records enfants liés
    @JoinTable(name = "Commande",
        joinColumns =
                { @JoinColumn(name = "PersonID", referencedColumnName = "id") },
        inverseJoinColumns =
                { @JoinColumn(name = "MovieID", referencedColumnName = "id") })
    private List<Movie> movielist;


    // bidrection avec Company et Employee

    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="employee_id", referencedColumnName = "id")
    private List<Company> companies;

// on peut aussi voir la table commande comme une table "normale" et ainsi vouloir récuprer les commandes de l'employee

    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name="PersonID", referencedColumnName = "id")
    private List <Commande> commandes;

    public Long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Movie> getMovielist() {
        return movielist;
    }

    public void setMovielist(List<Movie> movielist) {
        this.movielist = movielist;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}