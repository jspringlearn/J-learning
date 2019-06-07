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

}
