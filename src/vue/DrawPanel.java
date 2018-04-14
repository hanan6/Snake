package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import joueur.Miams;
import joueur.Snake;
import joueur.SnakePart;


public class DrawPanel extends JPanel {
	
	 private static final int D_W = 500;
	 private static final int D_H = 200;
	 private int x = 0;
	 private int y = 0;
	 
	 private int tx = 0;
	 private int ty = 0;
	 
	 private Color col;
	 
	 private Snake snake;
	 
	 private Miams food=null;
	 


	private ArrayList <Snake> snakes=new ArrayList<Snake>();
	 String id_player;
	 String pwd_player;
	 
	 public String getPwd_player() {
		return pwd_player;
	}


	public void setPwd_player(String pwd_player) {
		this.pwd_player = pwd_player;
	}


	public DrawPanel(String id_player){
		 this.id_player=id_player;
		 
		 
	 }


    public String getId_player() {
		return id_player;
	}


	public void setId_player(String id_player) {
		this.id_player = id_player;
	}


	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(5,5,220,220);
		
	     for(int k=0;k<snakes.size();k++){
	        	Snake sk_i=snakes.get(k);
	        		
		        for (int i=0;i<sk_i.getSetPart().size();i++){
		        	SnakePart spi=sk_i.getSetPart().get(i);

		        	g.setColor(Color.BLUE);
		        	g.fillRect(spi.getPosX(), spi.getPosY(), spi.getDimX(), spi.getDimY());
		        	
		       }
		        
		        
        }
	     
	    // dessin de la nourriture;
	     
	     if (food!=null){
	    	 g.setColor(Color.RED);
	         g.fillRect(food.getPosX(), food.getPosY(), 20, 20);
	    	 
	     }
	     
    }
    
    
    

    public ArrayList<Snake> getSnakes() {
		return snakes;
	}


	public void setSnakes(ArrayList<Snake> snakes) {
		this.snakes = snakes;
	}


	public int getX() {
		return x;
	}





	public void setX(int x) {
		this.x = x;
	}





	public int getY() {
		return y;
	}





	public void setY(int y) {
		this.y = y;
	}





	public static int getdW() {
		return D_W;
	}



	public static int getdH() {
		return D_H;
	}





	public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }


	public int getTx() {
		return tx;
	}


	public void setTx(int tx) {
		this.tx = tx;
	}


	public int getTy() {
		return ty;
	}


	public void setTy(int ty) {
		this.ty = ty;
	}


	public Color getCol() {
		return col;
	}


	public void setCol(Color col) {
		this.col = col;
	}


	public Snake getSnake() {
		return snake;
	}


	public void setSnake(Snake snake) {
		this.snake = snake;
	}
	
	 public Miams getFood() {
			return food;
	}


	public void setFood(Miams food) {
		this.food = food;
	}
	
	public void deleteFood(){
		
		food=null;
	}
}
