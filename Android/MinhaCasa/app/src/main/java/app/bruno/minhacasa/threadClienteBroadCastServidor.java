package app.bruno.minhacasa;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import app.bruno.minhacasa.ActivityLigaDesliga;

public class threadClienteBroadCastServidor {
    String status;
    String comodo;

    public threadClienteBroadCastServidor(String status){
        this.status = status;
    }

    public void run(){


        try {

            Socket socketEn = new Socket("192.168.0.250", 8080);

            DataOutputStream EnviarParaServidor = new DataOutputStream(socketEn.getOutputStream());

            EnviarParaServidor.writeBytes(status);

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socketEn.getInputStream()));

            ActivityLigaDesliga.Status = inFromServer.readLine();

            socketEn.close();
        }catch (Exception e){
            System.out.println("ERRO "+e.getMessage());

        }
    }
}
