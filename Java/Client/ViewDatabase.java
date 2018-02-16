/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anuj
 */import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ViewDatabase {
    DefaultTableModel model;
    
    public ViewDatabase(){
        
    
}

 void make(){
     JFrame jf=new JFrame();
      jf.setTitle("Database Viewer");
       JButton jb=new JButton("Back");
        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("reg_id");
        model.addColumn("sos");
        model.addColumn("organ");
        model.addColumn("DOB");
        model.addColumn("DOA");
       
       jb.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             jf.dispose();
             throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         }
     });
            String column[]={"Name","reg_id","sos","organ","DOB","DOA"};        
            JTable jt1=new JTable(model);   
            //jt.setBounds(30,40,200,300);         
            JScrollPane sp=new JScrollPane(jt1);   
            jf.add(sp);         
            jf.add(jb);
       
        jf.setBounds(100,10,1000,500);
        jf.setLayout(new FlowLayout(FlowLayout.CENTER));
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
              Class.forName("com.mysql.jdbc.Driver");
                Connection con = null;
                //con.setAutoCommit(true);
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","ishballi21");
            Statement stat=con.createStatement();
            String name,organ,dob,doa;
            int reg_id,sos;
            ResultSet rs=stat.executeQuery("select * from patient");
            while(rs.next())
            {
                String name1=rs.getString(1);
                int reg_id1=rs.getInt(2);
                int sos1=rs.getInt(3);
                String organ1=rs.getString(4);
                String dob1=rs.getString(5);
                String doa1=rs.getString(6);
                model.addRow(new Object[]{name1,reg_id1,sos1,organ1,dob1,doa1});
            }
        }catch(Exception e){
               
        }
    }
 
 void make2(ResultSet rs)
 {
     JFrame jf=new JFrame();
      
       
         model = new DefaultTableModel();
        
        model.addColumn("reg_id");
        model.addColumn("Name");
        //model.addColumn("sos");
        model.addColumn("organ");
        
       
       
            String column[]={"reg_id","name","organ"};        
            JTable jt1=new JTable(model);   
            //jt.setBounds(30,40,200,300);         
            JScrollPane sp=new JScrollPane(jt1);   
            jf.add(sp);         
       
        jf.setBounds(100,10,1000,500);
        jf.setLayout(new FlowLayout(FlowLayout.CENTER));
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     try {
              Class.forName("com.mysql.jdbc.Driver");
                Connection con = null;
                //con.setAutoCommit(true);
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdl","root","ishballi21");
            Statement stat=con.createStatement();
            String name,organ;
            int reg_id;
            //ResultSet rs=stat.executeQuery("select * from patient");
            while(rs.next()){
                int reg_id1=rs.getInt(1);
                String name1=rs.getString(2);
                String organ1=rs.getString(3);
                model.addRow(new Object[]{reg_id1,name1,organ1});
            }
        }catch(Exception e){
               
        }
 }
}
