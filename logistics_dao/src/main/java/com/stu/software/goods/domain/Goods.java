package com.stu.software.goods.domain;

import com.stu.software.domain.BaseEntity;

import javax.persistence.*;

/**
 * @Author xs
 * @Date 2019/5/18 13:50
 * @Version 1.0
 * one to many
 * goods->store
 */
@Entity
@Table(name="T_GOODS")
public class Goods extends BaseEntity {


    /**
     *
     */
    private static final long serialVersionUID = 2956980785739215106L;

    @ManyToOne
    @JoinColumn(name = "store")
    Store store;

    @Column(name = "name")
    String name;

    @Column(name="number")
    String number;
    @Column(name="weight")
    double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
