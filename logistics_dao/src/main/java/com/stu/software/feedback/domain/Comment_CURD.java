package com.stu.software.feedback.domain;

import com.stu.software.jdbc.BaseDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Comment_CURD extends BaseDao {


    public static Comment_CURD instan=new Comment_CURD();
    public static Comment_CURD getintstan() {
        return instan;
    }
    Connection conn=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public List findAll(){
        List list=new ArrayList();
        try {
            conn=this.getConn();
            ps=conn.prepareStatement("select * from T_COMMENT");
            rs=ps.executeQuery();

            while(rs.next()){
                Comment comment=new Comment();
                //z这里还有问题 ，如何把1-->多的关系 ，也就是 store 的id 联系起来
                //	goods.setStore(rs.getObject("GOODS_STORE"));
                comment.setCommentID(rs.getString("COMMENT_ID"));
                comment.setCommentContent(rs.getString("COMMENT_CONTENT"));
                comment.setCommentTime(rs.getString("COMMENT_TIME"));
                list.add(comment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(rs, ps, conn);
        }
        return list;
    }
    public int upd(Comment comment){
        String sql="update T_COMMENT set COMMENT_CONTENT=?,COMMENT_TIME=? where COMMENT_ID=?";
        String[] params={
                comment.getCommentContent(),
                comment.getCommentTime(),
                String.valueOf(comment.getCommentID())
        };
        return this.exeUda(params, sql);
    }
    public int del(String id){
        String sql="delete from T_COMMENT where COMMENT_ID=?";
        String[] params={
                String.valueOf(id)
        };
        return this.exeUda(params, sql);
    }


    public Comment findOne(String Id){
        Comment comment=new Comment();
        try {
            conn=this.getConn();
            ps=conn.prepareStatement("select * from T_COMMENT where COMMENT_ID=?");
            ps.setString(1, Id);
            rs=ps.executeQuery();
            while(rs.next()){
                comment.setCommentID(rs.getString("COMMENT_ID"));
                comment.setCommentContent(rs.getString("COMMENT_CONTENT"));
                comment.setCommentTime(rs.getString("COMMENT_TIME"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(rs, ps, conn);
        }

        return comment;
    }


}
