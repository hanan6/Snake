package client_server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



/**
 * Cette classe correspond au server de Socket qui permet de gerer la connextion des joeurs/Snake
 * @author etudiant
 *
 */

class MultiThreadSocketServer {
	static ServerSocket server;
	private static  DataBase db;
	
	private static int num_mess=0;
	private static  ArrayList<Socket> ensembleclient= new ArrayList<Socket>() ;
	private static ConnectedPlayers players= new ConnectedPlayers();
	private static int[][] repere=new int[11][11]; 
	private static Map<String, String[]> anciennePosition;
	private static Map<String,Integer> points;  // nombre de points des joueurs
	private static int[] nourriture = new int[2]; // coordonnée de la nourriture
	
	public void affichageliGneRepere(int idline){
		
		int p= repere[0].length;
		for (int i=0; i <p;i++){
			System.out.print("|"+repere[idline][i]+"|");	
		}
	}
	
	public void majRepere(int x, int y){
		
		if ( x<repere.length && y<repere[0].length){
			repere[x][y]=1;
		}
	}
	
	public void affichageRepere(){
		
		int n = repere.length;		
		for (int i=0; i <n;i++){
			System.out.println();
			affichageliGneRepere(i);	
		}
	}
	
	// Envoie des informations au client
	
	public void sendPositions(){
		String msg="[Positions]";
		 Iterator iterator = anciennePosition.entrySet().iterator();
	       int id=0;

	        while (iterator.hasNext()) {
	        	if(id!=0){
	        		msg+="Snake";
	        	}
	        		
			          Map.Entry mapentry = (Map.Entry) iterator.next();
			          msg+= mapentry.getKey()+ (String) mapentry.getValue();
	        	id++;
	        } 
		
	}
	
	
	/**
	 * ajout de la Nourriture dans une position aleatoire
	 */
	public static  void ajoutNourriture(){
		
		int x = (int) (Math.random() * ( 10 ));
		int y= (int )  (Math.random() * ( 10 ));
		
		boolean ok=false;
		while(ok==false){
			if (repere[x][y]==0){
				ok=true;
			}
			else{
				x = (int) (Math.random() * ( 10 ));
				y= (int )  (Math.random() * ( 10 ));
			}
		}
		
		repere[x][y]=99;
		
		nourriture[0]=y;
		nourriture[1]=x;
		
	}
	
	
	
  public static void main(String args[]) {
	  
	anciennePosition= new HashMap<String,String[]>();
	int x = (int) (Math.random() * ( 10 ));
	int y= (int )  (Math.random() * ( 10 ));
	
	boolean ok=false;
	while(ok==false){
		if (repere[y][x]==0){
			ok=true;
		}
		else{
			x = (int) (Math.random() * ( 10 ));
			y= (int )  (Math.random() * ( 10 ));
		}
	}
	
	repere[y][x]=99;
	
	nourriture[0]=x;
	nourriture[1]=y;
	db = new DataBase();
	points= new HashMap<String,Integer>();
   
    try {
       server = new ServerSocket(36000);
 
      while (true) {
        Socket client = server.accept();
        num_mess++;    
        Thread t =  new Thread(new ClientDialogThread(client,num_mess,players, repere,anciennePosition, nourriture, db, points));
        t.start();        
      }
     
    // server.close();
    
    } catch(Exception e) {
      System.err.println(e);
    }
  }
}
