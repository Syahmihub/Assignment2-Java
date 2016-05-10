package assignment2.pkg1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
//import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author syahmi
 */



public class Client {
    
    public static void main(String[] args) throws IOException { 
        
        System.setProperty("javax.net.ssl.trustStore", "Syahmi.store");
        
        SSLSocket socket = (SSLSocket) ((SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket("localhost",8080);
        
        BufferedReader sbufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printwriter = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader ibufferedreader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Please enter the server IP address/Hostname : ");
        printwriter.println(ibufferedreader.readLine());
        //String ipAdd = bufreader.readLine();
        
        //InetAddress server_add = InetAddress.getByName(ipAdd);
	//DatagramSocket socket = new DatagramSocket();
        
        System.out.print("Please enter the agreed port number : ");
        printwriter.println(ibufferedreader.readLine());
        
        System.out.print("Enter username:");
        printwriter.println(ibufferedreader.readLine());
        
        String message = null;
        
        while (true) {
            System.out.print("Connection to server is established");
            message = ibufferedreader.readLine();
            printwriter.println(message);
            System.out.println("Server: " + sbufferedreader.readLine());
            if (message.equals("quit")) {
                socket.close();
                break;
            }
        }
       
    }
    
    
}
