package com.journaldev.hibernate.model;

import org.hibernate.engine.jdbc.BlobProxy;

import javax.persistence.*;
import java.sql.Clob;

/**
 * Created by bb on 16.10.2016.
 */
@Entity
@Table(name = "Images")
public class ImageWrapper_alt {

    @Id
    private int id;

    @Column(name="name", length=40, nullable=true)
    private String name;

    @Column(name="image",  nullable=false)
    private Clob data;

    @Column(name="Product",nullable = false)
    @ManyToOne
    private Products product;

    public String getName()
    {return name;}

    public void setName(String name1)
    {this.name = name1;}

    public Clob getData()
    {return data;}

    public void setData(Clob data1)
    {
        BlobProxy.generateProxy(new byte[]{1,2,3});
        this.data = data1;}
}