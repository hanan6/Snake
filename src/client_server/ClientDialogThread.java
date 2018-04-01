package client_server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import joueur.PositionJoueur;

public class ClientDialogThread implements Runnable /*extends Thread*/ {
    
	private  Socket socket;
    private PrintWriter out = null;
    private   BufferedReader in = null;
    private boolean etatConnexion;
    
    ObjectOutputStream oos;
    ObjectInputStream ois;
      
     private  int nbre_msg;
     
     ConnectedPlayers players;
     
     int[][] repereJeu;
     
     String[] anciene_position={""}; 
     Map<String, String[]> ex_position;
     
     String id_player;
     
     int[] nourriture;
         
    public  ClientDialogThread(Socket s, int nb_message, ConnectedPlayers players,
    						 int[][] repere,Map<String, String[]> ex_position, int[] nourriture) {
    	id_player=null;
      this.ex_position=ex_position;
      socket = s;
      this.nbre_msg=nb_message;
      
      this.players=players;
      
      this.repereJeu=repere;
      
      
      this.nourriture= nourriture;
      
      if  (this.nourriture==null){
    	  ajoutNourriture();
      }
      
    }
   
    public  String getId_player() {
		return id_player;
	}

	public void setId_player(String id_player) {
		this.id_player = id_player;
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
	                		String[]  ex_pos= {""};
	                		
	                		id_player=msg[1];
	               
	                		ex_position.put(msg[1],ex_pos);
	                		
	                		//System.out.print("connexion reussi");
	                		this.sendMessage("ok");}
	                }
	                else{
	                	
	                	if(line.startsWith("updpos")){ 
 	                		
	                		// mise à zero des anciences positions
	                		if (ex_position.get(id_player/*"boka"*/).length>1 ){
	                			int k = ex_position.get(id_player/*"boka"*/).length;
	                			
	                			for(int i=1;i<k;i++){
		                			String[] icord=ex_position.get(id_player/*"boka"*/)[i].split(",");
		                			int idcordX=(Integer.parseInt(icord[0]))/20;
		                			int idcordY=(Integer.parseInt(icord[1]))/20;
		                			
		                			majRepere(idcordY,idcordX,0);

		                		}
	                			
	                			sendPositions();
	                		}
	                		

	                		
	                		// mis à jour de la position ( recuperation de l'ensemble des coordonées )
	                		String[] positions=line.split("=");
	                		String[] ensemblecord=positions[1].split("P");
	                	//	anciene_position=positions[1].split("P");
	                		ex_position.put(id_player/*"boka"*/, positions[1].split("P")); // Mise à jour de la position
	                		int n = ensemblecord.length;
	                		//System.out.println("+++++ "+ensemblecord[1]);
	                		for(int i=1;i<n;i++){
	                			String[] icord=ensemblecord[i].split(",");
	                			int idcordX=(Integer.parseInt(icord[0]))/20;
	                			int idcordY=(Integer.parseInt(icord[1]))/20;
	                			
	                			if (i==1 &&  repereJeu[idcordY][idcordX]==99){
	                				//nourriture=null;
	                				//repereJeu[idcordY][idcordX]==99
	                				
	                				//break;
	                				this.sendMessage("allongement");
	                				// affichageRepere();
	                				 ajoutNourriture();
	    	                		
	                			}
	                			
	                			 majRepere(idcordY,idcordX,players.getPlayers().get(id_player));
	                			 

	                		}
	                		

               			   affichageRepere();
               			   
	                		
	                		this.sendMessage("");
	                		
	                	}
	                	else{
	                	
	                		this.sendMessage("");
	                	}
	                	
	                }
                
                }
                          

            }
           

      } catch(Exception e) {
        System.err.println(e);
      }
    }
    
public void affichageliGneRepere(int idline){
		
		int p= repereJeu[0].length;
		
		for (int i=0; i <p;i++){
		
			System.out.print("|"+repereJeu[idline][i]+"|");
			
		}
	}
	
	public void majRepere(int x, int y, int val){
	//	synchronized(repereJeu){
			if ( x<repereJeu.length && y<repereJeu[0].length){
				repereJeu[x][y]=val;
			}
		//}
	}
	
	public void affichageRepere(){
		
		int n = repereJeu.length;		
		for (int i=0; i <n;i++){
		
			System.out.println();
			affichageliGneRepere(i);	
		}
	}
    

	// Envoie des informations au client
	
	public void sendPositions(){
		String msg="E";
		Iterator iterator = ex_position.entrySet().iterator();
		int id=0;
     //   System.out.print("Taille ===="+qualificatifs.size());
        while (iterator.hasNext()) {
       /* if(id!=0){
        	msg+="Snake";
        }*/
        msg+="Snake";
        		
		Map.Entry mapentry = (Map.Entry) iterator.next();
		String[] stri=(String[]) mapentry.getValue();
		msg+=/* mapentry.getKey()+">>"+*/recuP(stri);
        	id++;
        } 
        
        
       //Ajout de la food
        if(/*nourriture!=null* &&*/ repereJeu[nourriture[1]][nourriture[0]]==99){
        	msg+="Food"+nourriture[0]+","+nourriture[1];
        }
        
	    out.println(msg);
	}
	
	
	// recuperation des position
	
	public String recuP(String[] s){
		String res="P";
		int n = s.length;
		//System.out.println("+++++ "+ensemblecord[1]);
		for(int i=1;i<n;i++){
			String[] icord=s[i].split(",");
			int idcordX=(Integer.parseInt(icord[0]));
			int idcordY=(Integer.parseInt(icord[1]));
			res+=idcordX+","+idcordY+"P";

		}
		
		
		return res;
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
    
    
	public  void ajoutNourriture(){
		
		nourriture= new int[2];
		int x = (int) (Math.random() * ( 10 ));
		int y= (int )  (Math.random() * ( 10 ));
		nourriture[0]=x;
		nourriture[1]=y;
		
		boolean ok=false;
		while(ok==false){
			if (repereJeu[nourriture[1]][nourriture[0]]==0){
				ok=true;
			}
			else{
				x = (int) (Math.random() * ( 10 ));
				y= (int )  (Math.random() * ( 10 ));
			}
		}
		
		
		nourriture[0]=x;
		nourriture[1]=y;
		
		repereJeu[nourriture[1]][nourriture[0]]=99;
		
	}

	
    
    
    
  }
   

