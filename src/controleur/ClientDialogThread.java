package controleur;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientDialogThread extends Thread {
    
   private  Socket socket;
    private PrintWriter out = null;
    private   BufferedReader in = null;
      
     private  int nbre_msg;
         
    public ClientDialogThread(Socket s, int nb_message) {
      socket = s;
      this.nbre_msg=nb_message;
    }
   
    public void run() {
      try {
        out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
              socket.getInputStream())
            );   
           
            String line;
            while (true) {
              line = in.readLine();
                //System.out.println("received> "+line);
              System.out.println(nbre_msg+">"+line);
                
                
                out.println("Client connecté");
                if (line.equals("bye"))break;
            }
           
            in.close();
            out.close();
            //socket.close();
           
      } catch(Exception e) {
        System.err.println(e);
      }
    }
  }
   

