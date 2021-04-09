package com.webetapi.api.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="OrderID")
    private Long id;

    private Long Order_Num;

    @ManyToOne
    @JoinColumn(name="PersonID")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="MovieID")
    private Movie movie;
}
