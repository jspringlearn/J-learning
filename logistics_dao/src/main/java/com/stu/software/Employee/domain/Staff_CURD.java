package com.stu.software.Employee.domain;

import com.stu.software.jdbc.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author gsonya
 * @title
 * @Package com.stu.software.Employee.domain
 * @date 2019/6/18 10:32
 */
public class Staff_CURD extends BaseDao {
    public static Staff_CURD instan=new Staff_CURD();
    public static Staff_CURD getintstan() {
        return instan;
    }
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public int upd(Staff staff){
                String sql="update T_ADMIN_STAFF set STAFF_NUM=?,STAFF_NAME=?,STAFF_SEX=?,STAFF_AGE=?,STAFF_TEL=? where ID=?";
        String[] params={

                staff.getStaff_num(),
                staff.getStaff_name(),
                staff.getStaff_sex(),
                staff.getStaff_age(),
                staff.getStaff_tel(),
                String.valueOf(staff.getId())
        };
        return this.exeUda(params, sql);
    }
}
