package Rat;

import java.io.*;
import java.net.*;
import javax.swing.*;


public class Ratatouille 
{
    public static void main(String[] args) throws IOException{
        try{
            String ServerAddress = JOptionPane.showInputDialog("Enter IP Address of a machine that is\nrunning the service on port 13000:");
            Socket s = new Socket(ServerAddress, 13000);
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));

            String location = "";
            String play;
            String lastplay = new String();
            Rat r = new Rat();
            while (!(location.equals("ooooooooo")) && !(location.equals("wwwwwwwww"))){
                location = input.readLine();
                if(!(location.equals("ooooooooo"))){
                    play = r.move(location, lastplay).toLowerCase();
                    out.println(play);
                    lastplay = r.getLastplay(play);
                    RatLogFile.lg("Rat sends location: " + play);
                    if(location.equals("rrrrrrrrr")){
                        play = r.move(location, lastplay).toLowerCase();
                        out.println(play);
                        RatLogFile.lg("Rat sent illegal move.");
                    }
                }
            }
                if(location.equals("ooooooooo")){
                    System.out.println("The rat completed the maze!!!");
                    RatLogFile.lg("The rat has escaped the maze.");
                }else if(location.equals("wwwwwwwww")){
                    RatLogFile.lg("The rat has failed to complete the maze.");
                    System.out.println("The rat has failed to complete the maze.");
                }
            
            System.exit(0);
        }catch(Exception e) {
            RatLogFile.lg("Client failed to connect to server");
        }
    }
}
