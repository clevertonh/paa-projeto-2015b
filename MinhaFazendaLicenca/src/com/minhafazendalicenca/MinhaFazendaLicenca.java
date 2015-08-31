/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazendalicenca;

import com.minhafazenda.library.protocol.LicencaProtocol;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author cleverton
 */
public class MinhaFazendaLicenca {

    private static ArrayList<LicencaProtocol> lstLicencaUso;
    private static int quantidadeLicenca;
    
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
            System.out.println("Iniciado o servidor de licença na porta: " + portaServico);
            //Inicia um LOOP infiníto
            while(true){            
                //Aguardando conexão
                System.out.println("Aguardando conexão");
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
                        //Verifica se existe alguma licenca livre.
                        if(lstLicencaUso.size() < quantidadeLicenca){
                            //Existe licenca livre
                            //Adiciona o usuario na lista
                            lstLicencaUso.add(objRecebido);
                            //Altera o status do objeto
                            objRecebido.setStatus(LicencaProtocol.StatusType.LICENCA_FORNECIDA);
                        }else{
                            //Não existe uma licenca disponível
                            
                            //Altera o status do objeto
                            objRecebido.setStatus(LicencaProtocol.StatusType.SEM_LICENCA);
                        }
                        //
                        System.out.println(lstLicencaUso.size());
                        
                    }else if(objRecebido.getStatus() == LicencaProtocol.StatusType.LIBERAR_LICENCA){
                        //Usuário solicitou a liberação de uma licença
                        lstLicencaUso.remove(objRecebido);
                        System.out.println(lstLicencaUso.size());
                    }else if(objRecebido.getStatus() == LicencaProtocol.StatusType.MANTEM_LICENCA){
                        objRecebido.setStatus(LicencaProtocol.StatusType.LICENCA_RENOVADA);
                        lstLicencaUso.remove(objRecebido);
                    }
                    
                    System.out.println("Recebido solicitação do IP: " + connectionSocket.getInetAddress().toString());                

                    //Devolve
                    outToClient.writeObject(objRecebido);
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
