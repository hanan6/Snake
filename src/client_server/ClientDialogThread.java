package client_server;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;

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
    
    DataBase db;
         
    public  ClientDialogThread(Socket s, int nb_message, ConnectedPlayers players,
    						 int[][] repere,Map<String, String[]> ex_position, int[] nourriture, DataBase db) {
   
    	id_player=null;
    	this.ex_position=ex_position;
    	socket = s;
    	this.nbre_msg=nb_message;
      
    	this.players=players;
      
    	this.repereJeu=repere;
    	this.nourriture= nourriture;
      
    	if  (this.nourriture==null){
    		
    	}
      
    	this.db=db;
    }
    
    
   
    public  String getId_player() {
		return id_player;
	}
    
    

	public void setId_player(String id_player) {
		this.id_player = id_player;
	}
	
	
	

	public  void run() {
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
	                	id_player=msg[1];
                		
	                	
	                	System.out.print(id_player.length());
                		String pwd_player=msg[2];
                		System.out.print(pwd_player);
                		// Class.forName( "org.postgresql.Driver" );
                		//boolean  okok=db.executerTests(id_player,pwd_player);
                		
                		//System.out.print("bool = "+okok);
                		if (db.executerTests("1","bipbip")==true){	
	            			String[]  ex_pos= {""};	
	       
	                		ex_position.put(msg[1],ex_pos);
	                		
	                		players.addPlayer(msg[1],Integer.parseInt(msg[1]));
	                		
	                		System.out.print("connexion reussi");
	                		this.sendMessage("okconnexion");
	                		
	                		
	                	}
                		else{
                			this.sendMessage("echec connexion");
                		}
	                		
	                }
	                
	                ////
	                else{
	                	
		                if (line.startsWith("demandedeconnexion")) {
		                	String msg[]= line.split(":");
		                	if(players.getPlayers().containsKey(msg[1])){
		                		String[]  ex_pos= {""};
		                		this.sendMessage("okdeconnexion");
		                		
		                	}
		                }
		                	
		                	else{
			                	
			                	if(line.startsWith("updpos")){ 
		 	                		
			                		// mise à zero des anciences positions
			                		if (ex_position.get(id_player).length>1 ){
			                			int k = ex_position.get(id_player).length;
			                			
			                			for(int i=1;i<k;i++){
				                			String[] icord=ex_position.get(id_player)[i].split(",");
				                			int idcordX=(Integer.parseInt(icord[0]))/20;
				                			int idcordY=(Integer.parseInt(icord[1]))/20;
				                			
				                			majRepere(idcordY,idcordX,0);

				                		}
			                			
			                			
			                		}

			                		// mis à jour de la position ( recuperation de l'ensemble des coordonées )
			                		String[] positions=line.split("=");
			                		String[] ensemblecord=positions[1].split("P");
			                		//anciene_position=positions[1].split("P");
			                		ex_position.put(id_player/*"boka"*/, positions[1].split("P")); // Mise à jour de la position
			                		int n = ensemblecord.length;
			                		for(int i=1;i<n;i++){
			                			String[] icord=ensemblecord[i].split(",");
			                			int idcordX=(Integer.parseInt(icord[0]))/20;
			                			int idcordY=(Integer.parseInt(icord[1]))/20;
			                			
			                			if (i==1 &&  repereJeu[idcordY][idcordX]==99){

			                				this.sendMessage("allongement");
			                				// affichageRepere();
			                				 ajoutNourriture();
			    	                		
			                			}
			                			
			                			gestionColision(idcordX, idcordY,i);
			                			
			                			 majRepere(idcordY,idcordX,players.getPlayers().get(id_player));
			                			 

			                		}

		               			   affichageRepere();
		               			   	sendPositions();

			                		this.sendMessage("");
	
			                }else{
			                	
		                		this.sendMessage("");
		                	}

	                }

                }

            }

            }   

      } catch(Exception e) {
        System.err.println(e);
      }
    }
    
	
	
	/**
	 * Affichgage d'une ligne de la Matrice 
	 * @param idline
	 */
	public void affichageliGneRepere(int idline){
			
			int p= repereJeu[0].length;
			
			for (int i=0; i <p;i++){
			
				System.out.print("|"+repereJeu[idline][i]+"|");
				
			}
	}
	
	

  /**
   * Mise à jour du repere	la case x, y du repère
   * 
   * @param x
   * @param y
   * @param val
   */
		
		public synchronized void majRepere(int x, int y, int val){
		//	synchronized(repereJeu){
				if ( x<repereJeu.length && y<repereJeu[0].length){
					repereJeu[x][y]=val;
				}
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
        while (iterator.hasNext()) {
        msg+="Snake";
        		
		Map.Entry mapentry = (Map.Entry) iterator.next();
		String[] stri=(String[]) mapentry.getValue();
		msg+=recuP(stri);
        	id++;
        } 
        
        
       //Ajout de la food das le message
        if(repereJeu[nourriture[1]][nourriture[0]]==99){
        	msg+="Food"+nourriture[0]+","+nourriture[1];
        }
        
	    out.println(msg);
	}
	
	
	// recuperation des position
	
	public String recuP(String[] s){
		String res="P";
		int n = s.length;
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
    
    /**
     * Ajout de la nourriture dans une positions Aleatoire du repere
     */
	public    void ajoutNourriture(){
		
		
		synchronized (this){
				
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

	
	
	/**
	 *  Gestion de la detection de colision en fonction de la position 
	 *  de la tete du snake dans le Repere
	 * @param cordX
	 * @param cordY
	 * @param i
	 */
	
	public void gestionColision(int cordX,int cordY, int i){
		
		int id= players.getPlayers().get(id_player);
		
		if (i==1 && repereJeu[cordY][cordX]!=id && repereJeu[cordY][cordX]!=99 && repereJeu[cordY][cordX]!=0){
			System.out.println("============");
			System.out.println("BOOM BOM BOM");
			System.out.println("BOOM BOM BOM");
			System.out.println("============");
    		
		}
		
		
	}
	
	
	
    
    
    
  }
   

