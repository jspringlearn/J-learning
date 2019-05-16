package zut.com.sofware.xie.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name="road_manage")
public class RoadManageEntity extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5169715391294725213L;

	@Id
	@Column(name = "R_M_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	/*
	 * many RoadEntity to one
	 * */
	@ManyToOne
	@JoinColumn(name="ROAD_ID")
	private RoadEntity road;
	/*staffID*/
	@OneToMany
	private int staffID;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoadEntity getRoad() {
		return road;
	}

	public void setRoad(RoadEntity road) {
		this.road = road;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (null != o) {
			if (o instanceof RoadManageEntity) {
				RoadManageEntity ol = (RoadManageEntity) o;
				if (this.id == ol.id) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		if (this.id == null) {
			this.id = Long.valueOf(0);
		}
		return HashCodeBuilder.reflectionHashCode(this.id);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
