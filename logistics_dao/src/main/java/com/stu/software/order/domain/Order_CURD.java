package com.stu.software.order.domain;

import com.stu.software.jdbc.BaseDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Order_CURD extends BaseDao {


    public static Order_CURD instan=new Order_CURD();
    public static Order_CURD getintstan() {
        return instan;
    }
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public List findAll(){
        List list=new ArrayList();
        try {
            conn=this.getConn();
            ps=conn.prepareStatement("select * from T_ORDER");
            rs=ps.executeQuery();

            while(rs.next()){
            	Order order=new Order();
                //z这里还有问题 ，如何把1-->多的关系 ，也就是 store 的id 联系起来
                //	goods.setStore(rs.getObject("GOODS_STORE"));
            	order.setOrderID(rs.getString("ORDER_ID"));
            	order.setOrderName(rs.getString("ORDER_NAME"));
            	order.setOrderPrice(rs.getString("PRICE"));
            	order.setOrderTime(rs.getString("ORDER_TIME"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(rs, ps, conn);
        }
        return list;
    }
    public int upd(Order order){
        String sql="update T_ORDER set ORDER_NAME=?,PRICE=?,ORDER_TIME=? where ORDER_ID=?";
        String[] params={
        		order.getOrderName(),
        		order.getOrderPrice(),
        		order.getOrderTime(),
                String.valueOf(order.getOrderID())
        };
        return this.exeUda(params, sql);
    }
    public int del(String id){
        String sql="delete from T_ORDER where ORDER_ID=?";
        String[] params={
                String.valueOf(id)
        };
        return this.exeUda(params, sql);
    }


    public Order findOne(String Id){
    	Order order=new Order();
        try {
            conn=this.getConn();
            ps=conn.prepareStatement("select * from T_ORDER where ORDER_ID=?");
            ps.setString(1, Id);
            rs=ps.executeQuery();
            while(rs.next()){
                order.setOrderID(rs.getString("ORDER_ID"));
                order.setOrderName(rs.getString("ORDER_NAME"));
                order.setOrderPrice(rs.getString("PRICE"));
                order.setOrderTime(rs.getString("ORDER_TIME"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(rs, ps, conn);
        }

        return order;
    }


}