package com.stu.logistics.daomain;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="product")
public class Product  implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4376674977047164142L;

    @Id
    @GeneratedValue()
    @Column(name="id",unique = true,length = 20)
    public String id;
    public int productnumber;
    public String productname;
    public String destination;
	public Product(){}



   // @Column(name="num",unique = true,length = 20)
    public int getProductnumber() {
        return productnumber;
    }

   // @Column(name="name",unique = true,length = 20)
    public String getProductname() {
        return productname;
    }

   // @Column(name="destination",unique = true,length = 20)
    public String getDestination() {
        return destination;
    }


    public String getId() {
        return id;
    }

    public Product(String id, int productnumber, String productname, String destination) {
        this.id = id;
        this.productnumber = productnumber;
        this.productname = productname;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productnumber=" + productnumber +
                ", productname='" + productname + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
//    @ManyToOne
//	@JoinColumn(name = "GROUP_ID")
//	public Product group;



}
