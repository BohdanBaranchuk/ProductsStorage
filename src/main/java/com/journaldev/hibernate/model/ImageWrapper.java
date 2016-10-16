package com.journaldev.hibernate.model;

/**
 * Created by bb on 13.10.2016.
 */
import java.awt.*;
import java.util.Date;

import javax.persistence.*;
import javax.swing.*;

@Entity
@Table(name = "Images", uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class ImageWrapper {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
    private int id;

    @Column(name="name", length=40, nullable=true)
    private String name;

    @Lob
    @Column(name="image",  nullable=false)
    private byte[] data;

   /* @Column(name="Product",nullable = false)
    @ManyToOne
    private Products product;
*/
    public String getName()
    {return name;}

    public void setName(String name1)
    {this.name = name1;}

    public byte[] getData()
    {return data;}

    public void setData(byte[] data1)
    {this.data = data1;}
}
