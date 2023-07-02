package com.diyshopping.util;

import java.sql.*;
import  com.diyshopping.Table.User;
import  com.diyshopping.Table.T1;
public class test100 {
    /*
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    */
    public static void main(String[] args) {
        /*Connection conn=null;
        Statement statme=null;
        try {
//            连接创建，选择数据库
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shoptest?useUnicode=true&characterEncoding=UTF8","root","1472580369");
//            创建查询窗口
            statme = conn.createStatement();
//            写sql
            String sql = "insert into user(username,password,phone) values('管理者2','12345','1863115648')";
         //   String sql = "delete from user where id=9";
//          语句执行
            int i = statme.executeUpdate(sql);
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
                              statme.close();
                              }
                          catch (SQLException e)
                            {
                             e.printStackTrace();
                              }
                }

*/
        Userupdate.getEnd("select * from user where role=?", new RowMap<User>() {
            @Override
            public User rowMapping(ResultSet rs) {
                User user = new User();
                try {
                    int id = rs.getInt("id");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    int active = rs.getInt("active");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    int role = rs.getInt("role");
                    user.setId(id);
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setRole(role);
                    user.setPhone(phone);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return user;
            }
        },1);

        //TI
        Userupdate.getEnd("select * from t1", new RowMap<T1>() {
            @Override
            public T1 rowMapping(ResultSet rs) {
                T1 t =new T1();
                try {
                    t.setName(rs.getString("name"));
                    t.setAge(rs.getInt("age"));
                    t.setDept(rs.getString("dept"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return t;
            }
        });


    }

}
