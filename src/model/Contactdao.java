package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Contactdao {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
        }catch(Exception e){System.out.println(e);}
        return con;
    }

    public static int save(Contact u){
        int status=0;
        try{
            Connection con=getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "insert into contact(email,password,sex,country) values(?,?,?,?)");
            ps.setString(1,u.getEmail());
            ps.setString(2,u.getPassword());
            ps.setString(3,u.getSex());
            ps.setString(4,u.getCountry());
            status=ps.executeUpdate();
        }catch(Exception e){System.out.println(e);}
        return status;
    }

    public static int update(Contact u){
        int status=0;
        try{
            Connection con=getConnection();
            PreparedStatement ps=con.prepareStatement(
                    "update contact set email=?,password=?,sex=?,country=? where id=?");
            ps.setString(3,u.getEmail());
            ps.setString(2,u.getPassword());
            ps.setString(4,u.getSex());
            ps.setString(5,u.getCountry());
            status=ps.executeUpdate();
        }catch(Exception e){System.out.println(e);}
        return status;
    }

    public static int delete(Contact u){
        int status=0;
        try{
            Connection con=getConnection();
            PreparedStatement ps=con.prepareStatement("delete from contact where email=?");
            ps.setString(1,u.getEmail());
            status=ps.executeUpdate();
        }catch(Exception e){System.out.println(e);}

        return status;
    }

    public static List<Contact> getAllRecords(){
        List<Contact> list=new ArrayList<Contact>();

        try{
            Connection con=getConnection();
            PreparedStatement ps=con.prepareStatement("select * from register");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Contact u=new Contact();
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setSex(rs.getString("sex"));
                u.setCountry(rs.getString("country"));
                list.add(u);
            }
        }catch(Exception e){System.out.println(e);}
        return list;
    }

    public static Contact getRecordById(String email){
        Contact u=null;
        try{
            Connection con=getConnection();
            PreparedStatement ps=con.prepareStatement("select * from contact where email=?");
            ps.setString(1,email);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                u=new Contact();
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setSex(rs.getString("sex"));
                u.setCountry(rs.getString("country"));
            }
        }catch(Exception e){System.out.println(e);}
        return u;
    }
}
