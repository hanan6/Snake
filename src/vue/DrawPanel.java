package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

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
	 
	 public DrawPanel(Snake s){

		 snake=s;
		 
	 }


    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       // System.out.print("taille="+snake.getSetPart().size());
        for (int i=0;i<snake.getSetPart().size();i++){
        	SnakePart spi=snake.getSetPart().get(i);
        	//System.out.println("pos X="+spi.getPosX());
        	g.setColor(Color.BLUE);
        	g.fillRect(spi.getPosX(), spi.getPosY(), spi.getDimX(), spi.getDimY());
        	
       }
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
}
