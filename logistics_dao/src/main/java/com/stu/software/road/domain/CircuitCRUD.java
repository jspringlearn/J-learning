package com.stu.software.road.domain;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.stu.software.jdbc.BaseDao;

public class CircuitCRUD extends BaseDao {

	public static CircuitCRUD instan= new CircuitCRUD();
	public static CircuitCRUD getintstan() {
		return instan;
	}
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public int upda(Circuit circuit) {
		String sql="update T_ROAD_CIRCUIT set ENTITY_NAME=?,DISTANCE=?,ELAPTIME=? where ID=?";		
		String[] parm= {
				circuit.getEntityName(),
				String.valueOf(circuit.getDistance()),
				String.valueOf(circuit.getElapTime()),
				String.valueOf(circuit.getId())
		};
		return this.exeUda(parm, sql);
	}
	public Circuit findOne(Long id) {
		conn=this.getConn();
		System.out.println("ID="+id);
		Circuit circuit= new Circuit();
		try {
			ps=conn.prepareStatement("select * from T_ROAD_CIRCUIT where ID=?");
			ps.setLong(1, id);
			rs=ps.executeQuery();
			while (rs.next()) {
				
				circuit.setId(rs.getLong("ID"));
				circuit.setDistance(rs.getDouble("DISTANCE"));
				circuit.setElapTime(rs.getDouble("ELAPTIME"));
				circuit.setaSite(rs.getNString("ASITE"));
				circuit.setbSite(rs.getNString("BSITE"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll(rs, ps, conn);
		}
		return circuit;
	}
}
