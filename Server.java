package assignment2.pkg1;

/**
 *
 * @author syahmi
 */

import java.io.IOException;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class Server {

    public static void main(String[] args) throws IOException { 
        System.out.println("Server is waiting to be connected");
        
        System.setProperty("javax.net.ssl.keyStore", "Syahmi.store");
        System.setProperty("javax.net.ssl.keyStorePassword", "password");
        
        SSLServerSocket SS = (SSLServerSocket) ((SSLServerSocketFactory)SSLServerSocketFactory.getDefault()).createServerSocket(8080);
        System.out.println("Server ready for connection...");
        
        SS.setEnabledProtocols(new String[] {"TLSv1", "TLSv1.1", "TLSv1.2"});
        
        while (true) new Handler((SSLSocket) SS.accept()).start();
    }
}
