package domain;

import java.util.List;

public class RoadManageEntity {

	/*Transport number*/
	private int transportNumber=0;
	/*Total transport*/
	private int totalTransport=0;
	/*Transport bus*/
	private List<RoadEntity> bus;
	
	public void setTransportNumber(int transportNumber) {
		this.transportNumber = transportNumber;
	}
	public int getTransportNumber() {
		return transportNumber;
	}
	public int getTotalTransport() {
		return totalTransport;
	}
	public RoadEntity getBus(int index) {
		return bus.get(index);
	}
	public void setBus(RoadEntity bus) {
		this.totalTransport++;
		this.bus.add(bus); 
	}
	
}
