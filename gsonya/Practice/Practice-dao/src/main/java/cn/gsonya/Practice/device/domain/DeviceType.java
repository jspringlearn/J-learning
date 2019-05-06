package cn.gsonya.Practice.device.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.gsonya.Practice.base.domain.BaseTreeEntity;

@Entity
@Table(name="T_DEVICE_TYPE")
public class DeviceType extends BaseTreeEntity<DeviceType> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4966139594974300010L;
	
	@Column(name="TYPE_CODE")
	String typeCode;
}
