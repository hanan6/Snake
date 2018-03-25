package joueur;

import client_server.KeyCommand;


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
		
		System.out.println("Deplacement vers la gauche ");
		
		if ( command.getC() <=0) {
			 
			 command.setC(command.getdW()); // c = 0;
			 command.getLabel().getSnake().moving(); //label.getSnake().moving();
			 command.getLabel().getSnake().getSetPart().get(0).setPosX(command.getC());  // label.getSnake().getSetPart().get(0).setPosX(c);
			 command.getLabel().repaint(); //label.repaint();
             
			 command.getP().getPos().setPosX(0);  // p.getPos().setPosX(0);
            // p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
            // p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
			 
			 
			 command.getP().getEtatconnexion().updatePosition("Pos:X="+command.getP().getPos().getPosX()+"Y="+command.getP().getPos().getPosY());
           //  p.getEtatconnexion().updatePosition("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
             

         } else {
        	 command.setC( command.getC()-20);
        	 
            // c +=20;
            
        	 command.getLabel().getSnake().moving(); // label.getSnake().moving();
        	 command.getLabel().getSnake().getSetPart().get(0).setPosX(command.getC()); //  label.getSnake().getSetPart().get(0).setPosX(c);         
        	 command.getLabel().repaint(); // label.repaint();
             
        	 command.getP().getPos().setPosY( command.getP().getPos().getPosX()-1); //   p.getPos().setPosX(p.getPos().getPosX()+1);
             //p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
            // p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
        	 command.getP().getEtatconnexion().updatePosition("Pos:X="+command.getP().getPos().getPosX()+"Y="+command.getP().getPos().getPosY());
             //p.getEtatconnexion().updatePosition("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());

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
