package com.diyshopping.util;

import java.sql.*;

public class Userupdate {
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void update(String sql,Object ...obj) {
        Connection conn=null;
        Statement statme=null;
        PreparedStatement pstmt = null;
        try {
//            连接创建，选择数据库
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shoptest?useUnicode=true&characterEncoding=UTF8","root","1472580369");
//            创建查询窗口
            pstmt= conn.prepareStatement(sql);
//            循环obj进行赋值
            for(int i=0;i<obj.length;i++){
                pstmt.setObject(i+1,obj[i]);
            }
            //   String sql = "delete from user where id=9";
//          语句执行
            int i = pstmt.executeUpdate();
//            返回值
            System.out.println(i);


        }
        catch (SQLException  e) {
            e.printStackTrace();
        }
        finally {
//            关闭
            try {
                conn.close();
                pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }


    }




    //查询数据库


   /* public static void get(String sql) {
        Connection conn=null;
     //   Statement statme=null;
        PreparedStatement pstmt = null;
        try {
//            连接创建，选择数据库
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shoptest?useUnicode=true&characterEncoding=UTF8","root","1472580369");
//            创建查询窗口
            pstmt= conn.prepareStatement(sql);
//            循环obj进行赋值

            //   String sql = "delete from user where id=9";
//          语句执行
            ResultSet rs = pstmt.executeQuery();
//            返回值
     //       System.out.println(i);


            while(rs.next())
            {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                int role = rs.getInt("role");
                Date createtime = rs.getDate("create_time");
                User user = new User();

                user.setId(id);
                user.setUsername(username);
                user.setPassword(password);
                user.setRole(role);
                user.setPhone(phone);
                user.setCreatetime(createtime);
                System.out.println(user);

            }
        }
        catch (SQLException  e) {
            e.printStackTrace();
        }
        finally {
//            关闭
            try {
                conn.close();
                pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }


    }
*/
   public static <T> void getEnd(String sql, RowMap<T> rowMap, Object... obj){
        Connection conn=null;
        //   Statement statme=null;
        PreparedStatement pstmt = null;
        try {
//            连接创建，选择数据库
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shoptest?useUnicode=true&characterEncoding=UTF8","root","1472580369");
//            创建查询窗口
            pstmt= conn.prepareStatement(sql);
//            循环obj进行赋值
            for(int i=0;i<obj.length;i++){
                pstmt.setObject(i+1,obj[i]);
            }
            //   String sql = "delete from user where id=9";
//          语句执行
            ResultSet rs = pstmt.executeQuery();
//            返回值
            //       System.out.println(i);


            while(rs.next())
            {
                T t=rowMap.rowMapping(rs);
                System.out.println(t);

            }
        }
        catch (SQLException  e) {
            e.printStackTrace();
        }
        finally {
//            关闭
            try {
                conn.close();
                pstmt.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }


    }

}
