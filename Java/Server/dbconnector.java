/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author anuj
 */
public class dbconnector {
    Statement stmt;
    Connection con;
    public dbconnector(){
        
                    
 try{  
            
 System.out.println("creating connection");
Class.forName("com.mysql.jdbc.Driver");  
 con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/Server","root","ishballi21"); 
System.out.println("connection created");
 stmt=con.createStatement(); 
System.out.println("statement obj created");

System.out.println("query executed");
//con.close();  
}catch(Exception e){ System.out.println(e);} 
    } 
    
    public void updatewaliquery(String q) throws SQLException
            {

                stmt.executeUpdate(q);
            }
    
    public int executewaliquery(String q) throws SQLException
    {
        //System.out.println("in here");
        ResultSet rs=stmt.executeQuery(q);
        if (!rs.next() ) {
          //  System.out.println("in here2");
            return 5;
        } 
        else
            return 1;
        
        
    }
}
