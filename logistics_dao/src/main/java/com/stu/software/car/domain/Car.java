package com.stu.software.car.domain;

import javax.persistence.*;

import com.stu.software.domain.BaseEntity;

@Table(name="T_ADMIN_CAR")
@Entity
public class Car extends BaseEntity {

	private static final long serialVersionUID = 1L;
//	    @Id
//	    @Column(name = "ID")
//	    @GeneratedValue(strategy = GenerationType.AUTO)
//	    Long id;
	//BaseEntity里有这个主键ID这个可以不用写
		@Column(name="CAR_NUMBER")
	    String car_number;
	    @Column(name="CAR_VOLUME")
	    String car_volume;
	    @Column(name="CAR_OWNER")
	    String car_owner;
	    @Column(name="CAR_STATUS")
	    String car_status;
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
		
}
