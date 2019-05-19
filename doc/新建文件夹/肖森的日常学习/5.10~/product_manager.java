package com.stu.logistics.daomanager;

import com.stu.logistics.daomain.Product;
import org.springframework.jdbc.core.JdbcTemplate;

public class product_manager extends Product {

    private JdbcTemplate jdbcTemplate;
    String sql=null;

    public void add(String i,int num,String name,String des)
        {
        sql="insert into test.product(id,number,name,destination) values(?,?,?,?)";
        jdbcTemplate.update(sql);
    }
    public void delete(String id)
    {
        sql="delete from test.product where id=? ";
        jdbcTemplate.update(sql);
    }

    public void update(String id,int num,String na,String des)
    {
        sql="update test.product set id=?,num=?,na=?,des=? ";
        jdbcTemplate.update(sql);
    }
//    public void select(String i)
//    {
//        sql="select *from  test.product where i=?";
//        jdbcTemplate.query(sql ,new AccountRowMapper());
//    }

}



