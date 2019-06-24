package com.stu.software.road.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.stu.software.domain.BaseEntity;



@Table(name = "T_ROAD_CIRCUIT")
@Entity
public class Circuit extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 714545038097292623L;

	/*Two places Distance*/
	@Column(name="DISTANCE")
	private double distance;
	/*Elapsed time*/
	@Column(name="ELAPTIME")
	private double elapTime;
	/*Names of the two places*/
	@Column(name="ASITE")
	private String aSite;
	@Column(name="BSITE")
	private String bSite;
	/*Subordinate line*/
	/**
	 * route  
	 */
	@Column(name="ROUTE_ONE")
	private String route_one;
	@Column(name="DISTANCE_ONE")
	private double distance_one;
	@Column(name="ROUTE_TWO")
	private String route_two;
	@Column(name="DISTANCE_TWO")
	private double distance_two;
	@Column(name="ROUTE_THREE")
	private String route_three;
	@Column(name="DISTANCE_THREE")
	private double distance_three;
	@ManyToOne
	@JoinColumn(name = "GROUP_ID")
	RMap rmap;
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getElapTime() {
		return elapTime;
	}
	public void setElapTime(double elapTime) {
		this.elapTime = elapTime;
	}
	public String getaSite() {
		return aSite;
	}
	public void setaSite(String aSite) {
		this.aSite = aSite;
	}
	public String getbSite() {
		return bSite;
	}
	public void setbSite(String bSite) {
		this.bSite = bSite;
	}
	public RMap getRMap() {
		return rmap;
	}
	public void setRMap(RMap Rmap) {
		this.rmap = Rmap;
	}
	public String getRoute_one() {
		return route_one;
	}
	public void setRoute_one(String route_one) {
		this.route_one = route_one;
	}
	public double getDistance_one() {
		return distance_one;
	}
	public void setDistance_one(double distance_one) {
		this.distance_one = distance_one;
	}
	public String getRoute_two() {
		return route_two;
	}
	public void setRoute_two(String route_two) {
		this.route_two = route_two;
	}
	public double getDistance_two() {
		return distance_two;
	}
	public void setDistance_two(double distance_two) {
		this.distance_two = distance_two;
	}
	public String getRoute_three() {
		return route_three;
	}
	public void setRoute_three(String route_three) {
		this.route_three = route_three;
	}
	public double getDistance_three() {
		return distance_three;
	}
	public void setDistance_three(double distance_three) {
		this.distance_three = distance_three;
	}
	
}
