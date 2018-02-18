package joueur;

	

public class MessageClient {
	
	private boolean etat;
	
	
	public MessageClient(){
		etat=false;
	}
	
	void changementEtat(){
		
		if (etat==true){
			
			etat=false;
		}
		else{
			etat=true;
		}
	}

}
