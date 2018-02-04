package controleur;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Cette classe correspond au server de Socket qui permet de gerer la connextion des joeurs/Snake
 * @author etudiant
 *
 */

class MultiThreadSocketServer {
	static ServerSocket server;
	
	
	private static int num_mess=0;
	private static  ArrayList<Socket> ensembleclient= new ArrayList<Socket>() ;
	
  public static void main(String args[]) {
         
    try {
       server = new ServerSocket(36000);
 
      while (true) {
        Socket client = server.accept();
        num_mess++;    
        ClientDialogThread t = new ClientDialogThread(client,num_mess);
        t.start();
        
      }
     
    // server.close();
    
    } catch(Exception e) {
      System.err.println(e);
    }
  }
}
