package app.bruno.minhacasa;

import java.io.DataOutputStream;
import java.net.Socket;

public class thread extends Thread {
    String status;
    String comodo;

    public thread(String status, String comodo){
        this.status = status;
        this.comodo = comodo;
    }
    public void run(){
        try{


            Socket socket = new Socket("192.168.0.250", 8080);

            DataOutputStream EnviarParaServidor = new DataOutputStream(socket.getOutputStream());

            // BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //  String LigaDesliga = "1";


            //EnviarParaServidor.writeBytes(comodo);
            EnviarParaServidor.writeBytes(status);
            EnviarParaServidor.writeBytes(comodo);

            //  EnviarParaServidor.writeByte(Integer.parseInt(comodo));

            socket.close();
        }catch (Exception e){
            //String mensagem = e.getMessage();
            // Toast.makeText("Erro " + e,Toast.LENGTH_LONG).show();
            System.out.println("ERRO "+e.getMessage());

        }
    }

}
