package client_server;

import java.util.HashMap;
import java.util.Map;


public class ConnectedPlayers {

 private Map<String,Integer> players;
 
 public ConnectedPlayers(){
	 
	 players=new HashMap<String,Integer>();
	 
	 players.put("boka",1);

	 players.put("yao",2);
	 
 }
 
 // ajout d'un joueur dans la partie
 
 public void addPlayer(String id,int info){
	 players.put(id, info);
	 
 }

	public Map<String, Integer> getPlayers() {
		return players;
	}

	public void setPlayers(Map<String, Integer> players) {
		this.players = players;
	}
 
 

}
