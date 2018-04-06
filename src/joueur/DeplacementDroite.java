package joueur;

import java.util.ArrayList;

import vue.DrawPanel;
import client_server.KeyCommand;


public class DeplacementDroite implements Deplacement {

	/*
	 * (non-Javadoc)
	 * @see Deplacement#seDeplacer():Permet d'effectuer un mouvement vers
	 * la droite
	 */
	
	private  KeyCommand command;
	
	public DeplacementDroite(KeyCommand command){
		
		this.command=command;
		
		
		
		
		
	}
	
	public void seDeplacer() {
		
		System.out.println("Deplacement vers la droite ");
		
		
		 if ( command.getC() >= command.getdW()) {
			 
			 command.setC(0); // c = 0;
			 command.getLabel().getSnake().moving(); //label.getSnake().moving();
			 command.getLabel().getSnake().getSetPart().get(0).setPosX(command.getC());  // label.getSnake().getSetPart().get(0).setPosX(c);
			// command.getLabel().repaint(); //label.repaint();
             
			 command.getP().getPos().setPosX(0);  // p.getPos().setPosX(0);
            // p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
            // p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
			 
			 
			 command.getP().getEtatconnexion().updatePosition("Pos:X="+command.getP().getPos().getPosX()+"Y="+command.getP().getPos().getPosY());
           //  p.getEtatconnexion().updatePosition("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
             
			 

         } else {
        	 command.setC( command.getC()+20);
        	 
            // c +=20;
            
        	 command.getLabel().getSnake().moving(); // label.getSnake().moving();
        	 command.getLabel().getSnake().getSetPart().get(0).setPosX(command.getC()); //  label.getSnake().getSetPart().get(0).setPosX(c);         
        	// command.getLabel().repaint(); // label.repaint();
             
        //	 command.getP().getPos().setPosY( command.getP().getPos().getPosX()+1); //   p.getPos().setPosX(p.getPos().getPosX()+1);
             //p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
            // p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
        	 command.getP().getEtatconnexion().updatePosition("Pos:X="+command.getP().getPos().getPosX()+"Y="+command.getP().getPos().getPosY());
             //p.getEtatconnexion().updatePosition("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());

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
						System.out.println(idcordX+"****************"+idcordY);
						
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
