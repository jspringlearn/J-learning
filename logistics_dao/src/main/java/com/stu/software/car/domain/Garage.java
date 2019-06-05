package com.stu.software.car.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.stu.software.domain.BaseTreeEntity;

@Table(name = "T_ADIMIN_GARAGE")
@Entity
@NamedQueries({ @NamedQuery(name = "Garage.getRoot", query = "select g from Garage g where g.parent is null") })

public class Garage extends BaseTreeEntity<Garage> {

	private static final long serialVersionUID = 1L;

//	@Id
//	@Column(name = "ID")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	Long id;
	@Column(name = "GARAGE_PLACE")
	String garage_place;
	@Column(name = "GARAGE_V")
	String garage_v;
	@OneToMany(mappedBy="garage",cascade=CascadeType.REMOVE,fetch=FetchType.EAGER)
	Set<Car> cars;
	
	
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
	public String getGarage_place() {
		return garage_place;
	}
	public void setGarage_place(String garage_place) {
		this.garage_place = garage_place;
	}
	public String getGarage_v() {
		return garage_v;
	}
	public void setGarage_v(String garage_v) {
		this.garage_v = garage_v;
	}
	public Set<Car> getCars() {
		return cars;
	}
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}
	public void setGarageName(String string) {
		// TODO Auto-generated method stub
		
	}

}











