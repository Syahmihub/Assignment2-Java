package assignment2.pkg1;

/**
 *
 * @author syahmi
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

public class Handler extends Thread {
    SSLSocket socket;

    Handler(SSLSocket socket) {
        this.socket = socket;
    }
    
    public void run() {
        try {
            PrintWriter printwriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String sessionuser = bufferedreader.readLine();
            System.out.println("User '"+ sessionuser + "' is now connected to the server.");
            while (true) {
                String message = bufferedreader.readLine();
                printwriter.println("Message delivered");
                System.out.println(sessionuser + ":" + message);
                if (message.equals("quit")) {
                    System.out.println("Session '" + sessionuser + "' closed.");
                    socket.close();
                    break;
                }
            
            }
        } catch (IOException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
