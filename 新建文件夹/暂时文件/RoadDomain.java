package domain;

public interface RoadDomain {
	/*Get current road information*/
	String getRoadInformation();
	/*Judging the state of goods*/
	boolean getGoodsState();
	/*Get transportation costs*/
	double getMoney();
}
