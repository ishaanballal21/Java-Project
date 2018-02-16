
import java.io.DataOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anuj
 */
public class Hospital {
   // public static void main(String args[]){
    DataOutputStream out1;
    public Hospital(DataOutputStream out){
       this.out1=out;
      HospitalFrame HF = new HospitalFrame(out1);
      HF.setVisible(true);
    }
}
