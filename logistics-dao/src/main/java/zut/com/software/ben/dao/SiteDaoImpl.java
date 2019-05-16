package zut.com.software.ben.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import zut.com.software.ben.daomain.Site;
import zut.com.sofware.ben.dao.BaseJDBCDao;

public class SiteDaoImpl extends BaseJDBCDao implements SiteDao {

	public static SiteDaoImpl sitedaoimpl=new SiteDaoImpl();
	public static SiteDaoImpl getSiteDaoImpl() {
		return sitedaoimpl;
	}
	
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	
	//添加Site
	@Override
	public void addSite(Site site) {
		String sql="insert into site(site_id,name,info,group_id) "
				+ "values(?,?,?,?)";
		String[] params= {null,
				site.getName(),
				site.getInfo(),
				String.valueOf(site.getGroup())};
		int flag=0;
		flag=this.exeUpd(sql, params);
		if(flag!=0) {
			System.out.println("添加成功!");
		}else {
			System.out.println("添加失败!");
		}
	

	}
    //删除Site
	@Override
	public void deleteSite(String name) {
		String sql="delete from site where name=?";
		String[] params= {name};
		int flag=0;
		flag=this.exeUpd(sql, params);
		if(flag!=0) {
			System.out.println("删除成功!");
		}else {
			System.out.println("删除失败!");
		}

	}
	//修改信息
	public void upd(Site site) {
		String sql="update site set name=?,info=?,group_id=? where name=?";
		String[] params= {
				site.getName(),
				site.getInfo(),
				String.valueOf(site.getGroup())};
		int flag=0;
		flag=this.exeUpd(sql, params);
		if(flag!=0) {
			System.out.println("添加成功!");
		}else {
			System.out.println("添加失败!");
		}
	}
	//单个查找
	public Site findone(String name){
		Site site=null;
		
		try {
			conn=this.getConn();
			ps=conn.prepareStatement("select * from site where name=?");
			ps.setString(1, name);
			rs=ps.executeQuery();
			site=new Site();
			site.setSiteId(rs.getInt("site_id"));
			site.setName(rs.getString("name"));
			site.setInfo(rs.getString("info"));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll(rs, ps, conn);
		}
		return site;
	}
	//遍历
	public List findAll() {
		List list=new ArrayList();
		
		
		return list;
	}

}
