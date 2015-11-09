package com.minhafazenda.library.common;

import com.minhafazenda.library.protocol.LicencaProtocol;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cleverton
 */
//public class Licenca extends Thread{
public class Licenca{    
    private Thread objThread;
    private Socket clientSocket;
    
    public void mantemLicenca(){
    
        objThread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Teste");
                try {
                    //Inicia conexao
                    //Loop infinito para menter a execução do processo
                    while(true){
                        //Tratamento de erro
                        try {
                            Thread.sleep(5);
                            
                            clientSocket = new Socket("127.0.0.1", 6789);
                            ObjectOutputStream outToServer =  new ObjectOutputStream(clientSocket.getOutputStream());
                            ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
                    
                            LicencaProtocol objLicenca = new LicencaProtocol();
                            objLicenca.setStatus(LicencaProtocol.StatusType.MANTEM_LICENCA);
                            objLicenca.setDataHora(new Date());
                    
                            
                            //Solicita licenca
                            outToServer.writeObject(objLicenca);
                            //Retorno do servidor
                            objLicenca = (LicencaProtocol)inFromServer.readObject();
                            
                            if(objLicenca.getStatus() == LicencaProtocol.StatusType.LICENCA_RENOVADA)
                                System.out.println("Renovada");
                            else
                                System.out.println("NAO Renovada");
                            
                            
                            
                            objLicenca.setStatus(LicencaProtocol.StatusType.MANTEM_LICENCA);

                            clientSocket.close();
                            
                        } catch (InterruptedException | ClassNotFoundException ex) {
//                            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            
                        }
                    }
                } catch (IOException ex) {
  //                  Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        //Inicia thread
        objThread.start();
        
    
    }
    
    
    public void run() {

        try {
            while(true){
                Thread.sleep(1000);
                System.out.println("Verifica licenca");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Licenca.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
