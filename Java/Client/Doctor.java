
import java.io.DataOutputStream;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anuj
 */
public class Doctor {
    DataOutputStream dout;
    String username;
    public Doctor(String username) throws SQLException{
        this.username=username;
      dbconnector d=new dbconnector(dout);
      String username1="'"+username+"'";
      String query="select reg_id from doctors where username="+username1;
      int id=d.getDoctorReg_id(query);
      
      DoctorFrame DF = new DoctorFrame(id,dout);
      
      DF.setVisible(true);
    }
}
