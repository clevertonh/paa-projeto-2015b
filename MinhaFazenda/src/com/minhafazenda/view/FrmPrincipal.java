/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.view;

import com.minhafazenda.library.common.Licenca;
import com.minhafazenda.library.protocol.LicencaProtocol;
import com.minhafazenda.util.ConfiguracaoSistema;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Cléverton Heming
 */
public class FrmPrincipal extends javax.swing.JFrame {

    private FrmCategoriaListagem frmCategoria;
    private FrmRacaListagem frmRaca;
    
    private Licenca objLicenca;
    
    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        //Inicia o form principal maximizado
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        objLicenca = new Licenca();
        objLicenca.mantemLicenca();
        //Altera o título do sistema
        this.setTitle(ConfiguracaoSistema.tituloJanela);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuCadastriCategoria = new javax.swing.JMenuItem();
        menuCadastroRaca = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(723, 598));
        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);

        jButton1.setText("Categoria");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPreferredSize(new java.awt.Dimension(64, 40));
        jButton1.setRolloverEnabled(false);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jMenu1.setText("Cadastros");

        menuCadastriCategoria.setText("Categoria");
        menuCadastriCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastriCategoriaActionPerformed(evt);
            }
        });
        jMenu1.add(menuCadastriCategoria);

        menuCadastroRaca.setText("Raça");
        menuCadastroRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroRacaActionPerformed(evt);
            }
        });
        jMenu1.add(menuCadastroRaca);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sobre");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastriCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastriCategoriaActionPerformed
        if(frmCategoria == null){
            //Cria o form
            frmCategoria = new FrmCategoriaListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmCategoria);
            //diz que a janela interna é maximizável
            frmCategoria.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if(!frmCategoria.isVisible()){
            //Mostra o formulário
            frmCategoria.setVisible(true);
        }
    }//GEN-LAST:event_menuCadastriCategoriaActionPerformed

    private void menuCadastroRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroRacaActionPerformed
        try {   
            //Verifica se o formulario ja existe
            if(frmRaca == null){
                //Cria o form
                frmRaca = new FrmRacaListagem();
                //Adiciona o formulario dentro do DESKTOP
                this.jDesktopPane1.add(frmRaca);
                //diz que a janela interna é maximizável     
                frmRaca.setMaximizable(true);     
                //set o tamanho máximo dela, que depende da janela pai     
                frmRaca.setMaximum(true);     
            }
            
            //Verifica se o formulario nao esta visivel
            if(!frmRaca.isVisible()){
                //Mostra o formulário
                frmRaca.setVisible(true);
            }
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuCadastroRacaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            
            Socket clientSocket = new Socket("127.0.0.1", 6789);
            ObjectOutputStream outToServer =  new ObjectOutputStream(clientSocket.getOutputStream());    
            ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
                
            LicencaProtocol objLicenca = new LicencaProtocol();
            objLicenca.setStatus(LicencaProtocol.StatusType.SOLICITA_LICENCA);
            objLicenca.setDataHora(new Date());
            
            //Solicita licenca
            outToServer.writeObject(objLicenca);
                
            //Retorno do servidor
            objLicenca = (LicencaProtocol)inFromServer.readObject();
            
            //Valida o STATUS do retorno
            if(objLicenca.getStatus() == LicencaProtocol.StatusType.LICENCA_FORNECIDA){
                //A licenca foi fornecida pelo servidor
                java.awt.EventQueue.invokeLater(new Runnable() {
                    //Abre o formulário principal
                    public void run() {
                        final FrmPrincipal frm = new FrmPrincipal();
                        //frm.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                        frm.addWindowListener(new WindowAdapter() {
                            //Quando o usuário for fechar o sistema, libera a LICENCA no servidor
                            public void windowClosing(WindowEvent ev) {
//                                try {
//                                    //Libera a licenca
//                                    objLicenca.setStatus(LicencaProtocol.StatusType.LIBERAR_LICENCA);
//                                    //Envia a solicitacao para o servidor
//                                    outToServer.writeObject(objLicenca);
//                                    
//                                    objLicenca = (LicencaProtocol)inFromServer.readObject();
//                                    
//                                    System.out.println("");
//                                    //Fecha conexao
//                                    //clientSocket.close();
//                                } catch (IOException ex) {
//                                    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//                                } catch (ClassNotFoundException ex) {
//                                    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//                                }
                            }
                        });
                        frm.setVisible(true);
                    }
                });
            }else if(objLicenca.getStatus() == LicencaProtocol.StatusType.SEM_LICENCA){
                JOptionPane.showMessageDialog(null, "Não existe licenças disponíveis para iniciar o sistema!", "Sem licença", JOptionPane.ERROR_MESSAGE);
            }else if(objLicenca.getStatus() == LicencaProtocol.StatusType.SISTEMA_BLOQUEADO){
                JOptionPane.showMessageDialog(null, "O sistema está bloqueado, entre em contato com a Software House", "Aviso", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Erro.....", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ConnectException e){
            JOptionPane.showMessageDialog(null, "Não foi possível conectar no servidor de Licença", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem menuCadastriCategoria;
    private javax.swing.JMenuItem menuCadastroRaca;
    // End of variables declaration//GEN-END:variables
}
