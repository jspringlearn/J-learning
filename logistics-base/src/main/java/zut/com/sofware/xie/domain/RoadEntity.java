package zut.com.sofware.xie.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


@Entity
@Table(name="road")
public class RoadEntity extends BaseDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6624909947516594776L;
	@Id
	@Column(name = "ROAD_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roadID;
	/* Starting time of vehicle */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BEGIN_TIME")
	private Date beginTime;
	/* Estimated time of vehicle */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "END_TIME")
	private Date endTime;
	/* Vehicle information */
	@OneToOne
	@Column(name="CAR_ID")
	private int carID;
	/* Starting place */
	@OneToOne
	@Column(name="SSITE_ID")
	private int sSiteID;
	@ManyToOne
	@JoinColumn(name="ORDER_ID")
	private List<Integer> orderID;
	/* Place of arriva */
	@OneToOne
	@Column(name="ESITE_ID")
	private int eSiteID;
	/* Road condition */
	@Column(name="IS_CLEAR")
	boolean isClear;
	/*orderID*/

	
	
	public Long getRoadID() {
		return roadID;
	}

	public List<Integer> getOrderID() {
		return orderID;
	}

	public void setOrderID(List<Integer> orderID) {
		this.orderID = orderID;
	}

	public void setRoadID(Long roadID) {
		this.roadID = roadID;
	}

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

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public int getsSiteID() {
		return sSiteID;
	}

	public void setsSiteID(int sSiteID) {
		this.sSiteID = sSiteID;
	}

	public int geteSiteID() {
		return eSiteID;
	}

	public void seteSiteID(int eSiteID) {
		this.eSiteID = eSiteID;
	}

	public boolean isClear() {
		return isClear;
	}

	public void setClear(boolean isClear) {
		this.isClear = isClear;
	}

	@Override
	public boolean equals(Object o) {
		if (null != o) {
			if (o instanceof RoadEntity) {
				RoadEntity ol = (RoadEntity) o;
				if (this.roadID == ol.roadID) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		if (this.roadID == null) {
			this.roadID = Long.valueOf(0);
		}
		return HashCodeBuilder.reflectionHashCode(this.roadID);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
