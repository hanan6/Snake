package client_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import joueur.PositionJoueur;

public class ClientDialogThread extends Thread {
    
	private  Socket socket;
    private PrintWriter out = null;
    private   BufferedReader in = null;
    private boolean etatConnexion;
    
    ObjectOutputStream oos;
    ObjectInputStream ois;
      
     private  int nbre_msg;
         
    public ClientDialogThread(Socket s, int nb_message) {
      socket = s;
      this.nbre_msg=nb_message;
    }
   
    public void run() {
    	PositionJoueur pos;
      try {
       /* out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
              socket.getInputStream())
            );   
           
            String line;
            while (true) {
              line = in.readLine();
                //System.out.println("received> "+line);
            //  System.out.println(nbre_msg+">"+line);
                
                
                out.println("Client connecté");
                if (line.equals("bye")) {
                	out.println("close");
                	in.close();
                    out.close();
                     socket.close();
                     break;
                }
                
                System.out.println("received> "+line);
            }
           
           // in.close();
            //out.close();
            //socket.close();*/
    	  
    	  
    	  oos = new ObjectOutputStream(socket.getOutputStream());
    	  ois = new ObjectInputStream(socket.getInputStream());
    	  
    	  while ((pos = (PositionJoueur) ois.readObject()) != null) {
    	     // comp.printCompanyObject();
    		  
    		  Object obj = ois.readObject();
              pos = (PositionJoueur) obj;
    		  
    		  pos.affichagePosition();

    	      //oos.writeObject("bye bye");
    	     // break;
    	    }
           
      } catch(Exception e) {
        System.err.println(e);
      }
    }
  }
   

