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
     
     ConnectedPlayers players;
         
    public ClientDialogThread(Socket s, int nb_message, ConnectedPlayers players) {
      socket = s;
      this.nbre_msg=nb_message;
      
      this.players=players;
      
    }
   
    public void run() {
    	PositionJoueur pos;
      try {
        out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
              socket.getInputStream())
            );   
           
           String line;
            while (true) {
              line = in.readLine();
              System.out.println("recu ="+line);
                
                if (line.equals("bye")) {
                	out.println("close");
                	in.close();
                    out.close();
                    socket.close();
                    break;
                }
                else{
                
	                if (line.startsWith("demandeconnexion")) {
	                	String msg[]= line.split(":");
	                	if(players.getPlayers().containsKey(msg[1])){
	                		
	                		System.out.print("connexion reussi");
	                		this.sendMessage("ok");}
	                }
	                else{
	                	
	                	this.sendMessage("");
	                	
	                }
                
                }
                          

            }
           

      } catch(Exception e) {
        System.err.println(e);
      }
    }
    
    

    
    
   /**
    *  Interpretation des information recues par le serveur
    */
    
    public void interpretationMessages(String received){
    	
    		System.out.println(received); /*( Affiche les informations recues), A modifier/completer */
    	
    	}
    
    /**
     * Envoie message au client
     * @return
     */
    
    public void sendMessage(String msg){
    	
    	 out.println(msg);
    	 
    }

	
    
    
    
  }
   

