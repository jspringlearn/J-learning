package domain;

import java.util.Date;

public class RoadEntity implements RoadDomain {
    /*Starting time of vehicle*/
	private Date beginTime;
	/*Estimated time of vehicle*/
	private Date endTime;
	/*Vehicle information*/
	
	/*Starting place*/
	
	
	/*Place of arriva*/
	
	/*Road condition*/
	boolean isClear;
	
	
	
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

	public boolean isClear() {
		return isClear;
	}

	public void setClear(boolean isClear) {
		this.isClear = isClear;
	}

	public String getRoadInformation() {
		return "This car is driving on the road from "+" to "+"."+"\n"
	               +"The cargo is expected to arrive in "+endTime.toString();
	}

	public double getMoney() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean getGoodsState() {
		// TODO Auto-generated method stub
		return false;
	}

}
