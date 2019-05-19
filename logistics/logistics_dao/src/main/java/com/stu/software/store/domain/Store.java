package com.stu.software.store.domain;

import com.stu.software.goods.domain.Goods;
import com.stu.software.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * @Author xs
 * @Date 2019/5/18 14:02
 * @Version 1.0
 */

@Entity
@Table(name="T_STORE")
@NamedQueries({ @NamedQuery(name = "Store.getRoot", query = "select s from Store s where s.parent is null") })
public class Store extends BaseTreeEntity<Store> {

    /**
     *
     */
    private static final long serialVersionUID = -8748825454057840907L;

    @Column(name = "NAME")
    String name;

    @OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Goods> goods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
