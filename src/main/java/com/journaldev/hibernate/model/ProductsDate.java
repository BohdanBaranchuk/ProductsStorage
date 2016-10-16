package com.journaldev.hibernate.model;

/**
 * Created by bb on 16.10.2016.
 */
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.swing.*;


@Embeddable
public class ProductsDate {

    @Column(name="PURCHASEDATE", length=20, nullable=true)
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    @Column(name="SALEDATE", length=20, nullable=true)
    @Temporal(TemporalType.DATE)
    private Date saleDate;

    @Column(name="TIMESTAMP", length=20, nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
}
