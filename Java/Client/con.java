
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anuj
 */
class con {
    public con()
    {
        try{  
            
 System.out.println("creating connection");
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/sdl","root","ishballi21"); 
/*System.out.println("connection created");
Statement stmt=con.createStatement(); 
System.out.println("statement obj created");
stmt.executeUpdate("INSERT INTO patient VALUES ('Anuj','1','1','kidney','1996-10-10','1996-10-10')");  
/*while(rs.next())  
System.out.println("creating connection");
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));*/
System.out.println("query executed");
//con.close();  
}catch(Exception e){ System.out.println(e);} 
    }
}
