package joueur;

import java.util.ArrayList;

import vue.DrawPanel;


public class DeplacementGauche implements Deplacement {

	/*
	 * (non-Javadoc)
	 * @see Deplacement#seDeplacer():Permet d'effectuer un mouvement vers
	 * la gauche
	 */
	
	private  KeyCommand command;
	
	public DeplacementGauche(KeyCommand command){
		
		this.command=command;
		
	}
	
	
	public void seDeplacer() {
		
		if(command.getP().getEtatconnexion()==command.getP().getEtatconnected()){
		
			System.out.println("Deplacement vers la gauche ");
			
			if ( command.getC() <=0) {
				 
				 command.setC(command.getdW()); 
				 command.getLabel().getSnake().moving(); 
				 command.getLabel().getSnake().getSetPart().get(0).setPosX(command.getC());  
	             
				 command.getP().getPos().setPosX(0);  
	
				 command.getP().getEtatconnexion().updatePosition("Pos:X="+command.getP().getPos().getPosX()+"Y="+command.getP().getPos().getPosY());
	
	         } else {
	        	 command.setC( command.getC()-20);
	
	        	 command.getLabel().getSnake().moving(); 
	        	 command.getLabel().getSnake().getSetPart().get(0).setPosX(command.getC());
	             
	        	 command.getP().getEtatconnexion().updatePosition("Pos:X="+command.getP().getPos().getPosX()+"Y="+command.getP().getPos().getPosY());
	            
	
	         }
		}
		
		 if (command.getP().getSocket().getServerResponse().startsWith("E")){
			 	
			 	
			 	String infoSnake=command.getP().getSocket().getServerResponse().split("Food")[0];
			 	
			 	DrawPanel d= command.getLabel();
			 	String positions= infoSnake.split("E")[1];
			 	String[] snaks=positions.split("Snake");
			 	ArrayList<Snake> snakes= new ArrayList<Snake> ();
			 	for (int k=1;k<snaks.length;k++){
			 		
			 		String[] s=snaks[k].split("P");
			 		
				 	Snake sk= new Snake();
				 	for(int i=1;i<s.length;i++){
						String[] icord=s[i].split(",");
						int idcordX=(Integer.parseInt(icord[0]));
						int idcordY=(Integer.parseInt(icord[1]));
						
						SnakePart sP= new SnakePart(idcordX,idcordY,20,20);						
						sk.addPartFixed(sP);
					}
				 	snakes.add(sk);
			 	}
			 	
			 	if (command.getP().getSocket().getServerResponse().split("Food").length>1){
			 		String infofood=command.getP().getSocket().getServerResponse().split("Food")[1];
				 	
				 	String[] pos_food=infofood.split(",");
					int food_x=(Integer.parseInt(pos_food[0]))*20;
					int food_y=(Integer.parseInt(pos_food[1]))*20;
					
					Miams food= new Miams(food_x, food_y);
					d.setFood(food);
			 	}
			 	else{
			 		d.deleteFood();
			 	}
			 	
			 	d.setSnakes(snakes);
				d.repaint();

			}
		 
	 

	}

	public void changementPositionDroit() {
		// TODO Auto-generated method stub
		
	}

	public void changementPositionGauche() {
		// TODO Auto-generated method stub
		
	}

	public void changementPositionHaut() {
		// TODO Auto-generated method stub
		
	}

	public void changementPositionBas() {
		// TODO Auto-generated method stub
		
	}

}
