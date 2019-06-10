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
    @JoinColumn(name = "STORE_ID")
    Store store;

    @Column(name = "GOODS_NAME")
    String name;

    @Column(name="GOODS_NUMBER")
    String number;
    @Column(name="GOODS_ID")
    long ID;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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
