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
	
}
