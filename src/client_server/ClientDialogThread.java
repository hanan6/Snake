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
    
    Map<String,Integer> points;

         
    public  ClientDialogThread(Socket s, int nb_message, ConnectedPlayers players,
    						 int[][] repere,Map<String, String[]> ex_position, int[] nourriture,
    						 DataBase db,Map<String,Integer> points ) {
    	
    	this.points=points;
   
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
              //System.out.println("recu ="+line);
                
                if (line.equals("bye")) {
                	out.println("close");
                	in.close();
                    out.close();
                    socket.close();
                    break;
                }
                else{
                
	                if (line.startsWith("demandeconnexion")) {
	                	autorisationConnexion(line);
	                		
	                }

	                else{
	                	
		                if (line.startsWith("demandedeconnexion")) {
		                	 deconnexionJoueur(line);
		                }
		                	
	                	else{
		                	
		                	if(line.startsWith("updpos")){ 	
		                		updatePosition(line);	
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
    

	/**
	 *  Envoie des informations sur la partie au client
	 */
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
	
	
	/**
	 *  recuperation des position
	 */
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
    * Affichage des messages recus par le serveur
    */
    
    public void printClientMessages(String received){
    	
    		System.out.println(received); 
    	
    	}
    
    
    
    /**
     * Envoie message au client
     */ 
    public void sendMessage(String msg){
    	 out.println(msg);
    }
    
    
    
    
    /**
     * Ajout de la nourriture dans une position aleatoire du repere
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
	
	
	/**
	 * Gestion de la demande de connexion du joeur
	 * @param message
	 */
	public void  autorisationConnexion(String message){
		String msg[]= message.split(":");
    	id_player=msg[1];
		String pwd_player=msg[2];
		if (db.verificationPlayerId(id_player,pwd_player)==true){	
			String[]  ex_pos= {""};	
    		ex_position.put(msg[1],ex_pos);
    		points.put(id_player,db.getNb_point_joeur());
    		players.addPlayer(msg[1],Integer.parseInt(msg[1]));
    		this.sendMessage("okconnexion");

    	}
		else{
			this.sendMessage("echec connexion");
		}

	}
	
	
	/**
	 * Gestion de deconnexion du joueur
	 */
	public void deconnexionJoueur(String message){
		synchronized(players){
			synchronized(points){
				synchronized(ex_position){
			
			    	String msg[]= message.split(":");
			    	if(players.getPlayers().containsKey(msg[1])){
			    		
			    		String[]  ex_pos= {""};
			    		this.sendMessage("okdeconnexion");
			    		
			    		players.removePlayer(id_player);
			    		points.remove(id_player);
			    		ex_position.remove(id_player);
			    		suppressionJoueurRepere(Integer.parseInt(id_player));
			 	
			    	}
				}
			}
			
		}
		
	}
	
	
	/**
	 * mise à jour de la position du joueur au niveau du serveur
	 */
	
	public void updatePosition(String line){
		{ 
     		
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

    		// mise à jour de la position ( recuperation de l'ensemble des coordonées )
    		String[] positions=line.split("=");
    		String[] ensemblecord=positions[1].split("P");
    		ex_position.put(id_player, positions[1].split("P"));
    		int n = ensemblecord.length;
    		for(int i=1;i<n;i++){
    			String[] icord=ensemblecord[i].split(",");
    			int idcordX=(Integer.parseInt(icord[0]))/20;
    			int idcordY=(Integer.parseInt(icord[1]))/20;
    			
    			if (i==1 &&  repereJeu[idcordY][idcordX]==99){

    				this.sendMessage("allongement");
    				int point_actuel=points.get(id_player);
    				points.put(id_player, point_actuel+1);   				
    				ajoutNourriture();
            		
    			}
    			
    			gestionColision(idcordX, idcordY,i);
    			majRepere(idcordY,idcordX,players.getPlayers().get(id_player));
    			
    		}

    		affichageRepere();
    		System.out.println();
    		sendPositions();

    		this.sendMessage("");
		}
	}
	
	
	/**
	 * Envoi du nouveau score au client
	 */
	
	public void sendScore(int score){
		this.sendMessage("score_actuel:"+points.get(id_player));
		
	}
	
	
	
	/**
	 * Supression de du joueur dans la matrice repere
	 */
	
	public void suppressionJoueurRepere(int id_joueur){
		
		/* on parcours le repere ete on met à zero toutes les cases correspodantes à 
		 * l'Id du joueur
		 */
		synchronized(repereJeu){
			int n= repereJeu.length;
			int p=repereJeu[0].length;
			for(int i=0;i<n;i++){
				
				for(int j=0;j<p;j++){
					if (repereJeu[i][j]== id_joueur){
						repereJeu[i][j]=0;
					}
				}
			}
			
		}
		
	}
	
	
	/**
	 * 
	 * Reduction de la taille du snake et perte de point
	 * 	s'il mange un object "poison"
	 */
	
	public void pertePointTaille(){
		
		this.sendMessage("reduction_taille");
		
		
	}
	
	
	
    
    
    
  }
   

