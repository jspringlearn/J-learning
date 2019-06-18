package com.stu.software.car.domain;

import javax.persistence.*;

import com.stu.software.domain.BaseEntity;

@Table(name="T_CAR")
@Entity
public class Car extends BaseEntity {

	private static final long serialVersionUID = 1L;
//	    @Id
//	    @Column(name = "ID")
//	    @GeneratedValue(strategy = GenerationType.AUTO)
//	    Long id;
	//BaseEntity里有这个主键ID这个可以不用写
		@Column(name="CAR_NUMBER")    //车牌号码
	    String car_number;
	    @Column(name="CAR_VOLUME")     //车辆描述（大货车，客车等）
	    String car_volume;
	    @Column(name="CAR_OWNER")     //车主
	    String car_owner;
	    @Column(name="CAR_STATUS")    //车的状态
	    String car_status;
	    @Column(name="CAR_OWNER_TEL")   //车主电话
	    String car_owner_tel;
	    @Column(name="CAR_ROAD")    //车辆运输路线
	    String car_road;
	    /**
	     * @ManyToOne
	     *  @JoinColumn 引入外键  
	     *     */
	    @ManyToOne
	    @JoinColumn(name = "GARAGE_PLACE")
	    Garage garage ;
	    
//		public Long getId() {
//			return id;
//		}
//
//		public void setId(Long id) {
//			this.id = id;
//		}

		public String getCar_number() {
			return car_number;
		}

		public void setCar_number(String car_number) {
			this.car_number = car_number;
		}

		public String getCar_volume() {
			return car_volume;
		}

		public void setCar_volume(String car_volume) {
			this.car_volume = car_volume;
		}

		public String getCar_owner() {
			return car_owner;
		}
		
		public void setCar_owner(String car_owner) {
			this.car_owner = car_owner;
		}

		public String getCar_status() {
			return car_status;
		}

		public void setCar_status(String car_status) {
			this.car_status = car_status;
		}

		public Garage getGarage() {
			return garage;
		}

		public void setGarage(Garage garage) {
			this.garage = garage;
		}

		public void setName(String string) {
			// TODO Auto-generated method stub
			
		}

		public void setGroup(Garage s) {
			// TODO Auto-generated method stub
			
		}

		public void setInfo(String string) {
			// TODO Auto-generated method stub
			
		}

		public String getCar_owner_tel() {
			return car_owner_tel;
		}

		public void setCar_owner_tel(String car_owner_tel) {
			this.car_owner_tel = car_owner_tel;
		}

		public String getCar_road() {
			return car_road;
		}

		public void setCar_road(String car_road) {
			this.car_road = car_road;
		}
		
}
