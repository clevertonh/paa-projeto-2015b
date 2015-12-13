package com.minhafazendalicenca;

import com.minhafazenda.library.protocol.LicencaProtocol;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cleverton
 */
public class MinhaFazendaLicenca {

    private static List<LicencaProtocol> lstLicencaUso;
    private static int quantidadeLicenca;

    private static void resumoLicenca(){
        System.out.println(" ");
        System.out.println("||================================================================================||"); 
        System.out.println("|| " + lstLicencaUso.size() + " de " + quantidadeLicenca + " licenças usadas");
        System.out.println("||================================================================================||"); 
        System.out.println(" ");
    }
    
    private static void monitor(){
    
        Thread objThread = new Thread(new Runnable() {
            public void run() {
                while(true){
                    
                    try {
                        Thread.sleep(1000);

                        Date dtAgora = new Date();
        
                        if(lstLicencaUso.size() > 0){
                            
                            for (int i=0; i<lstLicencaUso.size(); i++) {
                                LicencaProtocol _lstLicencaUso = lstLicencaUso.get(i);
                                Date dtDiferenca = new Date(dtAgora.getTime() - _lstLicencaUso.getDataHora().getTime());

                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(dtDiferenca);
                                //System.out.println("Tempo Seg: " + calendar.get(Calendar.SECOND));

                                if(calendar.get(Calendar.SECOND) > 60){
                                    //Removendo a licença
                                    System.out.println(" ");
                                    System.out.println("+ Removido a licença AUTOMATICAMENTE: " + _lstLicencaUso.getChave());
                                    System.out.println(" ");
                                    removeLicenca(_lstLicencaUso);
                                    
                                    resumoLicenca();
                                }  
                            }
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MinhaFazendaLicenca.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        });
        
        //Inicia thread
        objThread.start();
    
    }
    
    
    /**
     * Método de serviço
     * @param portaServico 
     */
    private static void run(int portaServico){
        try {
            //Inicia a lista de licenca
            lstLicencaUso = new ArrayList<>();
            //Inicia um servidor de SOCKET na porta em questão
            ServerSocket welcomeSocket = new ServerSocket(portaServico);
            //Mostra processo
            System.out.println(" ");
            System.out.println("||================================================================================||");
            System.out.println("||                                                                                ||");
            System.out.println("|| Iniciado o servidor de licença na porta: " + portaServico + "                                  ||");
            System.out.println("||                                                                                ||");
            System.out.println("||================================================================================||");            
            System.out.println(" ");

            monitor();
            
            //Inicia um LOOP infiníto
            while(true){        
                //verificaLista();

                //Aguardando conexão
                Socket connectionSocket = welcomeSocket.accept();
                //Cria objeto de STREAM de ENTRADA
                ObjectInputStream inFromClient = new ObjectInputStream(connectionSocket.getInputStream());
                //Cria objeto de STREAM de SAIDE
                ObjectOutputStream outToClient = new ObjectOutputStream(connectionSocket.getOutputStream());                              
                
                try {
                    //Recebe o objeto de licença Seriadlizado, após isso converte
                    LicencaProtocol objRecebido = (LicencaProtocol)inFromClient.readObject();
                    
                    //Verifica o status da solicitação
                    if(objRecebido.getStatus() == LicencaProtocol.StatusType.SOLICITA_LICENCA){
                        //Usuário solicitou uma licenca.
                        System.out.println("+ Solicitado licença: " + objRecebido.getChave());
                        //Verifica se existe alguma licenca livre.
                        if(lstLicencaUso.size() < quantidadeLicenca){
                            //Existe licenca livre
                            System.out.println("+ Licença fornecida para: " + objRecebido.getChave());
                            System.out.println("+ IP: " + connectionSocket.getInetAddress().toString());
                            System.out.println(" ");
                            //Altera o status do objeto
                            objRecebido.setStatus(LicencaProtocol.StatusType.LICENCA_FORNECIDA);
                            //Adiciona o usuario na lista
                            lstLicencaUso.add(objRecebido);
                            //Mostra resumo
                            resumoLicenca();
                        }else{
                            //Não existe uma licenca disponível
                            System.out.println("+ Não existe nenhuma licença disponível");
                            System.out.println(" ");
                            //Altera o status do objeto
                            objRecebido.setStatus(LicencaProtocol.StatusType.SEM_LICENCA);
                        }
                        //Devolve
                        outToClient.writeObject(objRecebido);
                        
                    }else if(objRecebido.getStatus() == LicencaProtocol.StatusType.LIBERAR_LICENCA){
                        //Usuário solicitou a liberação de uma licença
                        //String chaveTempo = objRecebido.getChave();
                        removeLicenca(objRecebido);
                        System.out.println("+ Licença liberada");
                        System.out.println("+ IP: " + connectionSocket.getInetAddress().toString());
                        System.out.println(" ");
                        //Mostra resumo
                        resumoLicenca();
                            
                    }else if(objRecebido.getStatus() == LicencaProtocol.StatusType.MANTEM_LICENCA){
                        //
                        removeLicenca(objRecebido);
                        //
                        objRecebido.setStatus(LicencaProtocol.StatusType.LICENCA_RENOVADA);
                        //
                        lstLicencaUso.add(objRecebido);
                        System.out.println("+ Licença renovada");
                        System.out.println("+ Licença: " + objRecebido.getChave());
                        System.out.println("+ " + objRecebido.getDataHora().toString());
                        System.out.println(" ");
                        
                        //Devolve
                        outToClient.writeObject(objRecebido);
                    }
                    
                    connectionSocket.close();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                    System.out.println(e.getLocalizedMessage());
                }
            }            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    private static void removeLicenca(LicencaProtocol obj){
        
        try {
            for (int i=0; i<lstLicencaUso.size(); i++) {
                LicencaProtocol val = lstLicencaUso.get(i);
                if (val.getChave().equals(obj.getChave())) {
                    lstLicencaUso.remove(i);
                    break;
                }
            } 

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //Informa a quantidade de licenca para esse cliente
        quantidadeLicenca = 30;
        //Inicia serviço
        run(6789);        
    }
    
}
