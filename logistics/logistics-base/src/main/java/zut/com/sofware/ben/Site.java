package zut.com.sofware.ben;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="T_SITE", catalog="test")
public class Site {
	private String siteId;
	private String name;
	private String info;
	private Group group;
	/**
	 * 逐渐
	 * 自动增长
	 * 唯一，长度为20
	 * @return
	 */
	@Id
	@GeneratedValue
	@Column(name="site_id" ,unique=true,nullable=false,length=20)
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="info")
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	/*
	 * 多对一
	 * 引用外键：group_id
	 */
	@ManyToOne
	@JoinColumn(name="group_id")
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	
	@Override
	public String toString() {
		return "Site [siteId=" + siteId + ", name=" + name + ", info=" + info + ", group=" + group + "]";
	}

}
