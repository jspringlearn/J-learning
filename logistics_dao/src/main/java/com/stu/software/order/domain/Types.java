package com.stu.software.order.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.stu.software.domain.BaseTreeEntity;


@Entity
@Table(name="T_TYPES")
@NamedQueries({ @NamedQuery(name = "Types.getRoot", query = "select s from Store s where s.parent is null") })
public class Types extends BaseTreeEntity<Types> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Column(name = "TYPES_NAME")///////
    String name;
	@Column(name = "TYPES_ID")////////
    String TypesID;
   

	

	public String getTypesID() {
		return TypesID;
	}

	public void setTypesID(String typesID) {
		TypesID = typesID;
	}

	@OneToMany(mappedBy = "types", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    Set<Order> order;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

}
