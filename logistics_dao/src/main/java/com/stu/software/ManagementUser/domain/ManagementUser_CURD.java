package com.stu.software.ManagementUser.domain;

import com.stu.software.jdbc.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManagementUser_CURD extends BaseDao {


    public static ManagementUser_CURD instan=new ManagementUser_CURD();
    public static ManagementUser_CURD getintstan() {
        return instan;
    }
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public List findAll(){
        List list=new ArrayList();
        try {
            conn=this.getConn();
            ps=conn.prepareStatement("select * from T_Management");
            rs=ps.executeQuery();

            while(rs.next()){
                ManagementUser managementUser=new ManagementUser();
                //z这里还有问题 ，如何把1-->多的关系 ，也就是 store 的id 联系起来
                //	goods.setStore(rs.getObject("GOODS_STORE"));
                managementUser.setMName(rs.getString("Management_MName"));
                managementUser.setMPhone(rs.getString("Management_Phone"));
                list.add(managementUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(rs, ps, conn);
        }
        return list;
    }
    public int upd(ManagementUser managementUser){
        String sql="update T_Management set Management_MName=?,Management_MPhone=? where Management_ID=?";
        String[] params={
                managementUser.getMName(),
                managementUser.getMPhone(),
                String.valueOf(managementUser.getManagementID())
        };
        return this.exeUda(params, sql);
    }
    public int del(long id){
        String sql="delete from T_Management where Management_ID=?";
        String[] params={
                String.valueOf(id)
        };
        return this.exeUda(params, sql);
    }


    public ManagementUser findOne(long Id){
        ManagementUser managementUser=new ManagementUser();
        try {
            conn=this.getConn();
            ps=conn.prepareStatement("select * from T_Management where Management_ID=?");
            ps.setLong(1, Id);
            rs=ps.executeQuery();
            while(rs.next()){
                managementUser.setManagementID(rs.getInt("Management_ID"));
                managementUser.setMName(rs.getString("Management_MName"));
                managementUser.setMPhone(rs.getString("Management_MPhone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(rs, ps, conn);
        }

        return managementUser;
    }


}
