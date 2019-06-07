package com.stu.software.zbase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.stu.software.place.domain.Site;

public class SiteBaseDao extends BaseDao {
	
	public static SiteBaseDao instan=new SiteBaseDao();
	public static SiteBaseDao getintstan() {
		return instan;
	}
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public List findAll(){
		List list=new ArrayList();
		try {
			conn=this.getConn();
			ps=conn.prepareStatement("select * from T_SITE");
			rs=ps.executeQuery();
		
			while(rs.next()){
				Site s=new Site();
				s=new Site();
				s.setSiteId(rs.getInt("SITE_ID"));
				s.setName(rs.getString("SITE_NAME"));
				s.setInfo(rs.getString("SITE_INFO"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, ps, conn);
		}
		return list;
	}
	public int upd(Site s){
		String sql="update T_SITE set SITE_NAME=?,SITE_INFO=? where SITE_ID=?";
		String[] params={
			s.getName(),
			s.getInfo(),
			String.valueOf(s.getSiteId())
		};
		return this.exeUda(params, sql);
	}
	public int del(int id){
		String sql="delete from T_SITE where SITE_ID=?";
		String[] params={
			String.valueOf(id)
		};
		return this.exeUda(params, sql);
	}
	public Site findOne(int SiteId){
		Site s=null;
		try {
			conn=this.getConn();
			ps=conn.prepareStatement("select * from T_SITE where SITE_ID=?");
			ps.setInt(1, SiteId);
			rs=ps.executeQuery();
			while(rs.next()){
				s=new Site();
				s.setSiteId(rs.getInt("SITE_ID"));
				s.setName(rs.getString("SITE_NAME"));
				s.setInfo(rs.getString("SITE_INFO"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, ps, conn);
		}
		
		return s;
	}

}
