
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anuj
 */
public class dbconnector {
    Statement stmt;
    Connection con;
    DataOutputStream out1;
    public dbconnector(DataOutputStream out){
        this.out1=out;
        
                    
 try{  
            
        System.out.println("creating connection");
       Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection(  
       "jdbc:mysql://localhost:3306/sdl","root","ishballi21"); 
       System.out.println("connection created");
        stmt=con.createStatement(); 
       System.out.println("statement obj created");

       System.out.println("query executed");
       //con.close();  
       }catch(Exception e){ System.out.println(e);} 

    }
    
    public void addpatient(String name,int reg_id,int pri,String organ,String dob,String doa) throws IOException{
        String name1="'"+name+"'";
        String organ1="'"+organ+"'";
        String query = "insert into patient values (" + name1 + "," + reg_id + "," + pri + ","+organ1+",'1996-10-10','1996-10-10'"+",'p')";
        System.out.println(query+"");
        try{
        stmt.executeUpdate(query);}
        catch(Exception e){}
        
        String query1="insert into patient values (" + name1 + "," + reg_id + "," + pri + ",organ1,'1996-10-10','1996-10-10' )#2";
        out1.writeUTF(query1);
        //Client client = new Client("localhost",5000);
        //client.replace(query);
    }
    
    public void reportdeath(String name,String dob,String doa,int reg_id,String k,String h,String e,String l)
    {
        String name1="'"+name+"'";
        String k1="'"+k+"'";
        String h1="'"+h+"'";
        String e1="'"+e+"'";
        String l1="'"+l+"'";
        //String dob1="'"+dob+"'";
        String query = "insert into death values (" + name1 + ",'1996-10-10','1996-10-10'," + reg_id + "," + k1 +"," + h1 +"," + e1 +"," + l1 +" )";
        try{
        stmt.executeUpdate(query);}
        catch(Exception pp){}
    }
    
    /**
     *
     * @param query
     * @return
     * @throws SQLException
     */
    public int count1(String query) throws SQLException
    {
        ResultSet rs=stmt.executeQuery(query);
        int c=0;
        while(rs.next())
         c=rs.getInt(1);
        
        return c;
    }
    
    public ResultSet allot(String query) throws SQLException
    {
        ResultSet rs=stmt.executeQuery(query);
        return rs;
    }
    
    public ResultSet getmessage(String query) throws SQLException
    {
        ResultSet rs=stmt.executeQuery(query);
        return rs;
    }
    public int getDoctorReg_id(String query) throws SQLException{
        int id=0;
        ResultSet rs=stmt.executeQuery(query);
        while(rs.next())
            id=rs.getInt(1);
        return id;
    }
    
    public void insertinto(String query) throws SQLException
    {
        stmt.executeUpdate(query);
        
    }
    
    public void setstatus(String query) throws SQLException{
        stmt.executeUpdate(query);
    }
    
    public ResultSet imtired(String query) throws SQLException
    {
        ResultSet rs=stmt.executeQuery(query);
        return rs;
    }
}
