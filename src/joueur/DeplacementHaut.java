package joueur;

import client_server.KeyCommand;


public class DeplacementHaut implements Deplacement {

	/*
	 * (non-Javadoc)
	 * @see Deplacement#seDeplacer():Permet d'effectuer un mouvement vers
	 * le haut
	 */
	
	private  KeyCommand command;
	
	public DeplacementHaut(KeyCommand command){
		
		this.command=command;
		
	}
	
	
	public void seDeplacer() {
		
		System.out.println("Deplacement vers le  haut ");
		
		if (command.getY() <=0 ){ // command.getdH()) {
			 //y = 0; 
			 command.setY(command.getdH());
			 command.getLabel().getSnake().moving(); 	 //label.getSnake().moving();
			 command.getLabel().getSnake().getSetPart().get(0).setPosY(command.getY()); //label.getSnake().getSetPart().get(0).setPosY(y);
			 command.getLabel().repaint();
            //label.repaint();
			 
			 command.getP().getPos().setPosY(0);
            
          //  p.getPos().setPosY(0);
			 //p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
           // p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
			 command.getP().getEtatconnexion().updatePosition("Pos:X="+command.getP().getPos().getPosX()+"Y="+command.getP().getPos().getPosY());
			 //p.getEtatconnexion().updatePosition("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());

        } else {	                   
           // y +=20;
            command.setY( command.getY()-20);

            command.getLabel().getSnake().moving(); 	//label.getSnake().moving();
            command.getLabel().getSnake().getSetPart().get(0).setPosY(command.getY());// label.getSnake().getSetPart().get(0).setPosY(y);         
            command.getLabel().repaint(); //label.repaint();
            
            
            command.getP().getPos().setPosY( command.getP().getPos().getPosY()-1); // p.getPos().setPosY(p.getPos().getPosY()+1);
           // p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
            //p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
            command.getP().getEtatconnexion().updatePosition("Pos:X="+command.getP().getPos().getPosX()+"Y="+command.getP().getPos().getPosY());

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
