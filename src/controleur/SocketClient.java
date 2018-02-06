package controleur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Le Socket client correspont au moyens d'change de donnée entre le client
 * et le server
 * @author etudiant
 *
 */

public class SocketClient {
	
	static private Socket s;
	PrintWriter out = null;
    BufferedReader in = null;
    
    boolean etatConnexion;
	
	public SocketClient(){
		
	}
	
	/**
	 *  connexion au serveur
	 * @param serverAdress : Identite de la machaine (de type InetAdress ou String)
	 * @param port : numéro de port sur lequel on souhaite se connecter sur le serveur
	 */
	public void connexion(String serverAdress, int port){

		System.out.println("Demande de connexion");	
		try {
			s= new Socket(serverAdress, port);
			
			out = new PrintWriter(s.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(
					s.getInputStream())
				);
		      
			
			etatConnexion=true;
			
			out.println("");
			System.out.println("etat de connexion (message du serveur)>: " + in.readLine());
			
			while(etatConnexion){
				
		
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Mon message:");
				String str = sc.nextLine();
				out.println(str);
				
				if(in.readLine().equals("close")){
					System.out.println("Deconnection...");
					etatConnexion=false;
					
					out.close();
					in.close();
					
					System.out.println("Deconnecté!!");
				}
				
				
		   
			}
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	  public static void main(String args[]) {
		  
		  SocketClient s1= new SocketClient();
		  s1.connexion("localhost", 36000); // Machine Local connecté sur le port :36000
	    
	  }
		  
	}