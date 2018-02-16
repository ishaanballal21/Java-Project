 
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anuj
 */
public class Client {
     Socket socket            = null;
      DataInputStream  input   = null;
     DataOutputStream out     = null;
    // constructor to put ip address and port
  public int func1() throws IOException{
       // System.out.println("func1 called");
         InputStream is = socket.getInputStream();
         input=new DataInputStream(socket.getInputStream());  
            String str=(String)input.readUTF();  
            System.out.println(str);
            int temp=Integer.parseInt(str);
            System.out.println(temp);
            return temp;
    }
   
    public Client(String address, int port) throws IOException {
          // establish a connection
        try{
            socket = new Socket(address, port);
            System.out.println("Connected");

            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u){
            System.out.println(u);
        }
    }
    
    public void writequery(String query){
            try{
                //line = input.readLine();
                System.out.println("writing query to server");
                out.writeUTF(query);               
            }
            catch(IOException i){
                System.out.println(i);
            }
    }
}
