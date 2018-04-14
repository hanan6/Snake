package client_server;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import joueur.Player;
import joueur.PositionJoueur;
import joueur.SnakePart;

import vue.FenetrePricipale;

/**
 * Le Socket client correspont au moyens d'change de donnée entre le client
 * et le server
 * @author etudiant
 *
 */

public class SocketClient  {

	static private Socket s;
	PrintWriter out = null;
    BufferedReader in = null;
    boolean etatConnexion;
    
    
    ObjectInputStream ois;
    ObjectOutputStream oos;
    
    String server_response="";
    
    Player p;
   
	public SocketClient(String serverAdress, int port,Player p) throws UnknownHostException, IOException{
		s= new Socket(serverAdress, port);
		this.p=p;
	}
	
	/**
	 * connexion au serveur
	 * @param serverAdress: Identite de la machaine (de type InetAdress ou String)
	 * @param port: numéro de port sur lequel on souhaite se connecter sur le serveur
	 */
	public void echangeServer(String message){

		try {
			
			out = new PrintWriter(s.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					s.getInputStream())
				);
		     
			etatConnexion=true;
			out.println(message);
			
			server_response = in.readLine();
			
			 if (server_response.equals("allongement")){
					
					SnakePart sp= new SnakePart(0,0,20,20);
					p.getSnakeJoueur().addPart(sp);
										
				}
			 
			 if (server_response.startsWith("score_actuel")){
					
					SnakePart sp= new SnakePart(0,0,20,20);
					p.setScore(Integer.parseInt(server_response.split(":")[1]));
										
				}

		//	out.close();
		//	in.close();
		//	s.close();
						
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * Fonction d'envoyer de message au serveur
	 */
	public void  envoyereMessage(String mes){
		
		if(etatConnexion==true){
			out.println(mes);

		}
		
	}
	
	public void fermetureConnexion() throws IOException{
		System.out.println("Deconnection...");
		etatConnexion=false;
		out.close();
		in.close();
		System.out.println("Deconnecté!!");
		
	}
	
	public String getServerResponse(){
		return server_response;
	}
	
	
	  public static void main(String args[]) {
		  
		  //SocketClient s1= new SocketClient();
	    
	  }
		  
	}






