package joueur;

import java.util.ArrayList;

import vue.DrawPanel;
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
			// command.getLabel().repaint();
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
            //command.getLabel().repaint(); //label.repaint();
            
            
            //command.getP().getPos().setPosY( command.getP().getPos().getPosY()-1); // p.getPos().setPosY(p.getPos().getPosY()+1);
           // p.getSocket().envoyereMessage(("Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY()));
            //p.demandeConnexion("localhost",36000,"Pos:X="+p.getPos().getPosX()+"Y="+p.getPos().getPosY());
            command.getP().getEtatconnexion().updatePosition("Pos:X="+command.getP().getPos().getPosX()+"Y="+command.getP().getPos().getPosY());

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
			 	}else{
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
