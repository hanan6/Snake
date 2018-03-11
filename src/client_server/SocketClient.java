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

import joueur.PositionJoueur;

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
   
	public SocketClient(){
		
			
	}
	
	/**
	 * connexion au serveur
	 * @param serverAdress: Identite de la machaine (de type InetAdress ou String)
	 * @param port: numéro de port sur lequel on souhaite se connecter sur le serveur
	 */
	public void connexion(String serverAdress, int port, String message){

		System.out.println("Demande de connexion");	
		try {
			s= new Socket(serverAdress, port);
			
			out = new PrintWriter(s.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					s.getInputStream())
				);
			
			//ois = new ObjectInputStream(s.getInputStream());
			//oos = new ObjectOutputStream(s.getOutputStream());
		     
			etatConnexion=true;
			out.println(message);
			
			server_response = in.readLine();
			
			System.out.println("message du serveur>"+server_response);
			
			//System.out.println("etat de connexion (message du serveur)>: " + in.readLine());
			
			/*while(etatConnexion){
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Mon message:");
				String str = sc.nextLine();
				//out.println(str);
				//envoyereMessage(str);
				
				//MessageClient message= 
				
				if(in.readLine().equals("close")){
					//System.out.println("Deconnection...");
					etatConnexion=false;
					out.close();
					in.close();
					//System.out.println("Deconnecté!!");
					
					fermetureConnexion();
				}
				
			} */
			
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






