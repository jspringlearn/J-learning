package com.stu.logistics.daomain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Component
@Table(name="variety")
public class Variety extends BaseTreeEntity<Variety> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "variety_name", unique = true, length = 20)


    private String varietyname;

    public HashSet products = new HashSet();

    public void setVarietyname(String varietyname) {
        this.varietyname = varietyname;
    }

    public void setProducts(HashSet products) {
        this.products = products;
    }



}











