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



	/* Starting time of vehicle */
	@Column(name = "BEGIN_TIME")
	private Date beginTime;
	/* Estimated time of vehicle */
	@Column(name = "END_TIME")
	private Date endTime;
	/*ID of location a*/
	@Column(name="ASITEID")
	private int ASiteID;
	/*ID of location b*/
	@Column(name="BSITEID")
	private int BSiteID;
	/*Distance between two places*/
	@Column(name="DISTANCE")
	private double distance;
	@ManyToOne
	@JoinColumn(name = "GROUP_ID")
	RMap rmap;
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getASiteID() {
		return ASiteID;
	}
	public void setASiteID(int aSiteID) {
		ASiteID = aSiteID;
	}
	public int getBSiteID() {
		return BSiteID;
	}
	public void setBSiteID(int bSiteID) {
		BSiteID = bSiteID;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public RMap getRMap() {
		return rmap;
	}
	public void setRMap(RMap Rmap) {
		this.rmap = Rmap;
	}
	
}
