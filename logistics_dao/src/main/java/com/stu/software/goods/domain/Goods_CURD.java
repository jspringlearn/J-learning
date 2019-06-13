package com.stu.software.goods.domain;

import com.stu.software.admin.dao.UserDao;
import com.stu.software.jdbc.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Goods_CURD extends BaseDao {
	
	public static Goods_CURD instan=new Goods_CURD();
	public static Goods_CURD getintstan() {
		return instan;
	}
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public List findAll(){
		List list=new ArrayList();
		try {
			conn=this.getConn();
			ps=conn.prepareStatement("select * from T_GOODS");
			rs=ps.executeQuery();
		
			while(rs.next()){
				Goods goods=new Goods();
				//z这里还有问题 ，如何把1-->多的关系 ，也就是 store 的id 联系起来
			//	goods.setStore(rs.getObject("GOODS_STORE"));
				goods.setName(rs.getString("GOODS_NAME"));
				goods.setNumber(rs.getString("GOODS_NUMBER"));
				goods.setID(rs.getLong("GOODS_ID"));
				list.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, ps, conn);
		}
		return list;
	}
	public int upd(Goods goods){
		String sql="update T_GOODS GOODS_NAME=?,GOODS_NUMBER=? where GOODS_ID=?";
		String[] params={
				goods.getName(),
				goods.getNumber(),
			String.valueOf(goods.getID())
		};
		return this.exeUda(params, sql);
	}
	public int del(long id){
		String sql="delete from T_GOODS where GOODS_ID=?";
		String[] params={
			String.valueOf(id)
		};
		return this.exeUda(params, sql);
	}


	public Goods findOne(long Id){
		Goods goods=new Goods();
		try {
			conn=this.getConn();
			ps=conn.prepareStatement("select * from T_GOODS where GOODS_ID=?");
			ps.setLong(1, Id);
			rs=ps.executeQuery();
			while(rs.next()){
				goods.setID(rs.getLong("GOODS_ID"));
				goods.setName(rs.getString("GOODS_NAME"));
				goods.setNumber(rs.getString("GOODS_NUMBER"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, ps, conn);
		}



		return goods;
	}
}
