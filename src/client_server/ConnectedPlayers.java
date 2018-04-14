package client_server;

import java.util.HashMap;
import java.util.Map;


public class ConnectedPlayers {

 private Map<String,Integer> players;
 
 public ConnectedPlayers(){
	 
	 players=new HashMap<String,Integer>();

 }
 
 	/**
	 * ajout d'un elment dans la partie
	 */
	 public void addPlayer(String id,int info){
		 players.put(id, info);
		 
	 }

	public Map<String, Integer> getPlayers() {
		return players;
	}

	
	
	public void setPlayers(Map<String, Integer> players) {
		this.players = players;
	}
 
	
	/**
	 * Suppression d'un element de la partie
	 */
	public void removePlayer(String id_player){
		players.remove(id_player);
	}
 

}
