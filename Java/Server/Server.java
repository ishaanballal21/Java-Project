/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.*;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author anuj
 */

//----------------------By Jeevan

//---------------------------------------------------------------------------------------
public class Server {
    //static Vector<ClientHandler> ar = new Vector<>(); // changed by jeevan
    
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;
   // DataOutputStream dout=null;
    dbconnector d;
    String clientip=null;
    // constructor with port
    public Server(int port) throws SQLException
    {
        // starts server and waits for a connection
        
       try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");
 
            System.out.println("Waiting for a client ...");
 
            socket = server.accept();
            System.out.println("Client accepted");
 
            // takes input from the client socket
            in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
 
            String line = "";
 
            // reads message from client until "Over" is sent
               while(true)
               {
                    try
                    {
                        line = in.readUTF();
                        StringTokenizer st = new StringTokenizer(line, "#");
                        String query = st.nextToken();
                        String type = st.nextToken();
                        System.out.println(line);
                        d=new dbconnector();
                        
                        if(type.equals("1"))
                        {
                            int temp=d.executewaliquery(query);
                        System.out.println(temp);
                        String ret=Integer.toString(temp);

                        DataOutputStream dout=new DataOutputStream(socket.getOutputStream());
                        dout.writeUTF(ret);
                        }
                        
                        if(type.equals("2"))
                        {
                            d.updatewaliquery(query);
                        }
                        
                    }
                    catch(IOException i)
                    {
                        System.out.println(i);
                    }
               }
                
            
            //System.out.println("Closing connection");
 
            // close connection
           // socket.close();
            //in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
        
    }
    public static void main(String args[]) throws SQLException
    {
        Server server = new Server(5000);
    }
}
