package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Basedao;
import entity.Student;

public class StudentDao extends Basedao {
	public static StudentDao instances=new StudentDao();
	public static StudentDao getInstances() {
		return instances;
	}
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	public int add(Student s){
		String sql="insert into class172(grade,major,class,cpeople,number,name,sex) values(?,?,?,?,?,?,?)";
		String[] params={
			s.getGrade(),
			s.getMajor(),
			s.getCla(),
			s.getCpeople(),
			s.getNumber(),
			s.getName(),
			s.getSex()
		};
		return this.exeUda(params, sql);
	}

	public int upd(Student s){
		String sql="update class172 set grade=?,major=?,class=?,cpeople=?,number=?,name=?,sex=? where number=?";
		String[] params={
				s.getGrade(),
				s.getMajor(),
				s.getCla(),
				s.getCpeople(),
				s.getNumber(),
				s.getName(),
				s.getSex()
		};
		return this.exeUda(params, sql);
	}

	public int del(String number){
		String sql="delete from class172 where number=?";
		String[] params={
			number
		};
		return this.exeUda(params, sql);
	}

	public Student findOne(String number){
		Student s=null;
		try {
			conn=this.getConn();
			ps=conn.prepareStatement("select * from class172 where number=?");
			ps.setString(1, number);
			rs=ps.executeQuery();
			while(rs.next()){
				s=new Student();
				s.setId(rs.getString("id"));
				s.setName(rs.getString("name"));
				//grade,major,class,cpeople,number,name,sex
				s.setGrade(rs.getString("grade"));
				s.setMajor(rs.getString("major"));
				s.setCla(rs.getString("class"));
				s.setCpeople(rs.getString("cpeople"));
				s.setNumber(rs.getString("number"));
				s.setSex(rs.getString("sex"));
//				s.setAge(rs.getInt("age"));
//				s.setAddress(rs.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(rs, ps, conn);
		}
		return s;
	}
	
	public List findAll(){
		List list=new ArrayList();
		try {
			conn=this.getConn();
			ps=conn.prepareStatement("select * from class172");
			rs=ps.executeQuery();
		
			while(rs.next()){
				Student s=new Student();
				s=new Student();
				s.setId(rs.getString("id"));
				s.setName(rs.getString("name"));
				//grade,major,class,cpeople,number,name,sex
				s.setGrade(rs.getString("grade"));
				s.setMajor(rs.getString("major"));
				s.setCla(rs.getString("class"));
				s.setCpeople(rs.getString("cpeople"));
				s.setNumber(rs.getString("number"));
				s.setSex(rs.getString("sex"));
//				s.setAge(rs.getInt("age"));
//				s.setAddress(rs.getString("address"));
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

