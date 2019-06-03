package zut.com.sofware.ben;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import zut.com.sofware.ben.Site;

@Entity
@Table(name="T_GROUP",catalog="test")
public class Group {
	
	private String groupId;
	private String groupName;
	private List<Site> sites;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "T_Group")
	public List<Site> getSites() {
		return sites;
	}
	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
	
	
	@Id
	@GeneratedValue
	@Column(name="group_id",unique=true,length=20)
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	
	@Column(name="group_name")
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + ", sites=" + sites + "]";
	}
	
}