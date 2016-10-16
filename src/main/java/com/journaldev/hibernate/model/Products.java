package com.journaldev.hibernate.model;

//import java.awt.*;
import com.journaldev.hibernate.ProjectEnums.Available;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.swing.*;

/**
 * Created by bb on 13.10.2016.
 */

@Entity
@Table(name = "Products",uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class Products {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="TYPE", length=20, nullable=true)
    private String type;

    @Column(name="NAME", length=20, nullable=true)
    private String name;

    @Column(name="SIZE", length=20, nullable=true)
    private String size;

    @Column(name="COLOR", length=20, nullable=true)
    private String color;

    @Enumerated(EnumType.STRING)
    @Column(name="Available")
    private Available available;
    //private boolean sold;

    @Column(name="PURCHASEDATE", length=20, nullable=true)
    private Date purchaseDate;

    @Column(name="SALEDATE", length=20, nullable=true)
    private Date saleDate;

    //@Column(name="Images", length=20, nullable=true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "products", cascade = {CascadeType.ALL})
    private List<ImageWrapper> images;



}
