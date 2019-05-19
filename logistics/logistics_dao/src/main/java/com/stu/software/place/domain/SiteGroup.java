package com.stu.software.place.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.stu.software.domain.BaseTreeEntity;
@Entity
@Table(name="T_SITEGROUP")
@NamedQueries({ @NamedQuery(name = "SiteGroup.getRoot", query="select s from SiteGroup s where s.parent is null") })
public class SiteGroup extends BaseTreeEntity<SiteGroup> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1747387466611154608L;

	@Column(name="GROUP_ID")
	private String groupId;
	@Column(name="GROUP_NAME")
	private String groupName;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "group")
	private List<Site> sites;
	
	/*
	     * 一对多关联关系
         * 级联关系：cascade=CascadeType.ALL
	     * 延迟加载：fetch = FetchType.LAZY
	     * 映射：mappedBy = "sitegroup"
	     */
	
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
