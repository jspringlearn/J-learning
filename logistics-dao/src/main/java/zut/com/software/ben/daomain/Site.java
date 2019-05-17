package zut.com.software.ben.daomain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import zut.com.sofware.ben.domain.BaseEntity;


@Entity
@Table(name="site")
public class Site extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2538649004355201367L;
	
	
	@Id
	@GeneratedValue
	@Column(name="site_id",unique=true,nullable=false)
	private int siteId;
	@Column(name="order_id")
	private String orderId;
	@Column(name="name")
	private String name;
	@Column(name="info")
	private String info;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="group_id")
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
