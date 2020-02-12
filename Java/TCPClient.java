/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programasocket;

/**
 *
 * @author bruno
 */
import java.io.*;
import java.net.*;

class TCPClient {

    public static void main(String args[]) throws IOException {
       String sentence = "";
       Socket clientSocket = new Socket("192.168.88.250", 8080);
       while(!sentence.equalsIgnoreCase("s")){
           
       
        String modifiedSentence;
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            
            
            
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); 
            
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            sentence = inFromUser.readLine();
            
            outToServer.writeBytes(sentence + "\n");
            
            modifiedSentence = inFromServer.readLine();
            
            System.out.println("FROM SERVER: " + modifiedSentence);
            if(sentence.equalsIgnoreCase("s")){
                clientSocket.close();
                break;
            }
            }
       clientSocket.close();
    }
}
