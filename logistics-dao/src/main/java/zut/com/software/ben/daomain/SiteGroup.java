package zut.com.software.ben.daomain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import zut.com.sofware.ben.domain.BaseEntity;


@Entity
@Table(name="sitegroup",catalog="test")
public class SiteGroup extends BaseEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3769793439143945339L;
	
	
	@Id
	@GeneratedValue
	@Column(name="group_id",unique=true)
	private String groupId;
	@Column(name="group_name")
	private String groupName;
	private List<Site> sites;
	
	/*
	     * 一对多关联关系
         * 级联关系：cascade=CascadeType.ALL
	     * 延迟加载：fetch = FetchType.LAZY
	     * 映射：mappedBy = "sitegroup"
	     */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
	public List<Site> getSites() {
		return sites;
	}
	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
	
	
	
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + ",  ]";
	}
	
}
