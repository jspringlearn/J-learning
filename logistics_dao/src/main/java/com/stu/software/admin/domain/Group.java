package com.stu.software.admin.domain;


import com.stu.software.goods.domain.Goods;
import com.stu.software.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;


/**
 * OneToMany
 * Group -- User
 *
 */
@Entity   //标注用于实体类声明语句之前，指出该Java 类为实体类，将映射到指定的数据库表。
@Table(name = "T_ADMIN_GROUP")   //当实体类与其映射的数据库表名不同名时需要使用 @Table 标注说明，该标注与 @Entity 标注并列使用。
@NamedQueries({ @NamedQuery(name = "Group.getRoot", query = "select g from Group g where g.parent is null") })

public class Group extends BaseTreeEntity<Group> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8748825454057840907L;

	@Column(name = "NAME")
	String name;

	@OneToMany(mappedBy = "store", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Goods> goods;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
