package com.stu.software.road.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.stu.software.domain.BaseTreeEntity;

@Table(name = "T_ROAD_MAP")
@Entity
@NamedQueries({ @NamedQuery(name = "RMap.getRoot", query = "select g from Group g where g.parent is null") })
public class RMap extends BaseTreeEntity<RMap> {

   /**
	 * 
	 */
	private static final long serialVersionUID = 3128420179154834776L;
	/**/
	@Column(name ="C_NAME")
	private String CircuitName;
	@OneToMany(mappedBy = "rmap", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private Set<Circuit> circuit;
	public String getCircuitName() {
		return CircuitName;
	}
	public void setCircuitName(String circuitName) {
		CircuitName = circuitName;
	}
	
}
