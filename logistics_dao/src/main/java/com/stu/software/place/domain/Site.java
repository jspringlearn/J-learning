package com.stu.software.place.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.stu.software.domain.BaseEntity;

@Entity
@Table(name="T_SITE")
public class Site extends BaseEntity{

	/**
	 * SITE_ID 地点编号
	 * ORDER_NUMBER 订单号
	 * SITE_NAME 地点名
	 * SITE_INFO 地点信息
	 */
	private static final long serialVersionUID = -6157659361489374064L;
	@Column(name="SITE_ID")
	private int siteId;
	@Column(name="ORDER_NUMBER")
	private String orderId;
	@Column(name="SITE_NAME")
	private String name;
	@Column(name="SITE_INFO")
	private String info;
	
	@ManyToOne
	@JoinColumn(name="GROUP_ID")
	private SiteGroup group;
	
	
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public SiteGroup getGroup() {
		return group;
	}
	public void setGroup(SiteGroup group) {
		this.group = group;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Site [siteId=" + siteId + ", name=" + name + ", info=" + info + ", group=" + group + "]";
	}

}
