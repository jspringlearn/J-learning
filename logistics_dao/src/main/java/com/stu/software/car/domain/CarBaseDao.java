package com.stu.software.car.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.stu.software.jdbc.BaseDao;

public class CarBaseDao extends BaseDao {
	
	public static CarBaseDao instan = new CarBaseDao();
	public static CarBaseDao getintstan(){
		return instan;
	}
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//MODIFY.
	public List findAll()
	{
		List list = new ArrayList();
		try {
			conn = this.getConn();
			ps = conn.prepareStatement("select * from T_CAR");
			rs = ps.executeQuery();
			
			while(rs.next()){
				Car c = new Car();
				c = new Car();
				c.setCar_number(rs.getString("CAR_NUMBER"));
				c.setCar_owner(rs.getString("CAR_OWNER"));
				c.setCar_volume(rs.getString("CAR_BOLUME"));
				c.setCar_status(rs.getString("CAR_STATUS"));
				c.setCar_owner_tel(rs.getString("CAR_OWNER_TEL"));
				c.setCar_road(rs.getString("CAR_ROAD"));
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(rs, ps, conn);
		}
		return list;
	}
	public int update(Car c)    //更新
	{
		//String sql="update T_CAR set car_number=?,car_volume=?,car_owner?,car_status?,car_owner_tel?,car_road?"+" where id?";
		String sql="update T_CAR set car_volume=?,car_owner=?,car_status=?,car_owner_tel=?,car_road=? where CAR_NUMBER=?";
		String[] params= {
				c.getCar_volume(),
				c.getCar_owner(),
				c.getCar_status(),
				c.getCar_owner_tel(),
				c.getCar_road(),
				String.valueOf(c.getCar_number())
		};
		return this.exeUda(params, sql);
	}
	
	
	public int delete(String CAR_NUMBER)        //删除
	{
		String sql="delete from T_CAR where CAR_NUMBER=?";
		String[] params= {
				String.valueOf(CAR_NUMBER)
		};
		return this.exeUda(params, sql);
	}
	
	
	public Car search(String CAR_NUMBER) {
		Car c=null;
		try {
			conn=this.getConn();
			ps=conn.prepareStatement("select * from T_CAR where CAR_NUMBER=?");
			ps.setString(1, CAR_NUMBER);
			rs=ps.executeQuery();
			while(rs.next())
			{
				c=new Car();
				c.setCar_number(rs.getString("CAR_NUMBER"));
				c.setCar_owner(rs.getString("CAR_OWNER"));
				c.setCar_owner_tel(rs.getString("CAR_OWNER_TEL"));
				c.setCar_road(rs.getString("CAR_ROAD"));
				c.setCar_status(rs.getString("CAR_STATUS"));
				c.setCar_volume(rs.getString("CAR_VOLUME"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			this.closeAll(rs,ps,conn);
		}
		return c;
	}
}














