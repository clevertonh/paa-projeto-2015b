package com.minhafazenda.view;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;
import com.minhafazenda.controller.UsuarioController;
import com.minhafazenda.library.common.Licenca;
import com.minhafazenda.library.protocol.LicencaProtocol;
import com.minhafazenda.model.Usuario;
import com.minhafazenda.util.Util;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

public class Login extends javax.swing.JFrame {

    private UsuarioController objController;
    private static String chave;
    //private Usuario ObjUsuario;
    
    public Login() {

        initComponents();

        //Inicia o objeto de controller
        objController = new UsuarioController();
        
        // aplica skin = LookAndFeel a todas as janelas
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Posicionar tela no centro da tela
        this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width / 2) - (this.getWidth() / 2)),
                ((Toolkit.getDefaultToolkit().getScreenSize().height / 2) - (this.getHeight() / 2)));   
    }

    public void pesquisar() {
        //Efetua a busca pela descricão no conttroler
        if (objController.findByUsuario(txtUsuario.getText(), new String(jPSenha.getPassword())) != null) {
            // abrir tela da aplicação
            FrmPrincipal frm = new FrmPrincipal(getChave());
            
            frm.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    
                    /****************************************************************
                     * INICIO - Antes de fechar o sistema libera a licença no servidor
                     */
                        try {

                            Socket clientSocket_ = new Socket("127.0.0.1", 6789);
                            ObjectOutputStream outToServer =  new ObjectOutputStream(clientSocket_.getOutputStream());    

                            LicencaProtocol objLicenca = new LicencaProtocol();
                            objLicenca.setStatus(LicencaProtocol.StatusType.LIBERAR_LICENCA);
                            objLicenca.setChave(chave);
                            outToServer.writeObject(objLicenca);

                        } catch (IOException ex) {
                            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    /*
                     * FIM - Antes de fechar o sistema libera a licença no servidor
                     ****************************************************************/                    
                    
                    
                    
                    
                    
                    
                    System.out.println("TESTE SAKDASJ LAS JLKA");
//                    int confirmed = JOptionPane.showConfirmDialog(null,"Voce deseja fechar o sistema?", "Fechar o sistema",JOptionPane.YES_NO_OPTION);
//                    if (confirmed == JOptionPane.YES_OPTION) {
//                        dispose();
//                    }
                    
                }
            });
            
//            
//            frm.addWindowListener(new WindowAdapter() {
//                //Quando o usuário for fechar o sistema, libera a LICENCA no servidor
//                public void windowClosing(WindowEvent ev) {
//                    
//                    System.out.println("TESTE SAKDASJ LAS JLKA");
//                                
////                                /****************************************************************
////                                 * INICIO - Antes de fechar o sistema libera a licença no servidor
////                                 */
////                                    try {
////                                    
////                                        Socket clientSocket_ = new Socket("127.0.0.1", 6789);
////                                        ObjectOutputStream outToServer_ =  new ObjectOutputStream(clientSocket_.getOutputStream());    
////                                        
////                                        //Libera a licenca
////                                        objRetorno.setStatus(LicencaProtocol.StatusType.LIBERAR_LICENCA);
////                                        //Envia a solicitacao para o servidor
////                                        outToServer_.writeObject(objRetorno);      
////                                
////                                    } catch (IOException ex) {
////                                        Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
////                                    }
////                                /*
////                                 * FIM - Antes de fechar o sistema libera a licença no servidor
////                                 ****************************************************************/
////                                
//                                
//                                
////                                try {
////                                    //Libera a licenca
////                                    objLicenca.setStatus(LicencaProtocol.StatusType.LIBERAR_LICENCA);
////                                    //Envia a solicitacao para o servidor
////                                    outToServer.writeObject(objLicenca);
////                                    
////                                    objLicenca = (LicencaProtocol)inFromServer.readObject();
////                                    
////                                    System.out.println("");
////                                    //Fecha conexao
////                                    //clientSocket.close();
////                                } catch (IOException ex) {
////                                    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
////                                } catch (ClassNotFoundException ex) {
////                                    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
////                                }
//                                
//                                
//                                
//                                
//                                
//                                
//                            }
//                        });
            
            frm.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário e senha não conferem!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jPSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SGF - Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setText("Usuário");

        jLabel2.setText("Senha");

        jPSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPSenhaActionPerformed(evt);
            }
        });
        jPSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPSenhaKeyPressed(evt);
            }
        });

        btnEntrar.setText("Entrar");
        btnEntrar.setBorderPainted(false);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(txtUsuario)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEntrar)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // validar no banco
        pesquisar();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void jPSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPSenhaKeyPressed
        //Verifica se foi pressionado a tecla ENTER
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // validar no banco
            pesquisar();
        }

    }//GEN-LAST:event_jPSenhaKeyPressed

    private void jPSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPSenhaActionPerformed

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.security.NoSuchAlgorithmException
     */
    public static void main(String args[]) throws IOException, NoSuchAlgorithmException {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */

        
        
        
        
        
        
        
        try {
            
              final LicencaProtocol objLicenca;
            
            final Socket clientSocket = new Socket("127.0.0.1", 6789);
            final ObjectOutputStream outToServer =  new ObjectOutputStream(clientSocket.getOutputStream());    
            final ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
           
            objLicenca = new LicencaProtocol();
            objLicenca.setStatus(LicencaProtocol.StatusType.SOLICITA_LICENCA);
            objLicenca.setDataHora(new Date());
            objLicenca.setChave(Util.md5(new Date().toString() + InetAddress.getLocalHost()));
         
            //Adiciona a chave gerada na variavel estatica
            setChave(objLicenca.getChave());
            
            //Solicita licenca
            outToServer.writeObject(objLicenca);
                
            //Retorno do servidor
            final LicencaProtocol objRetorno = (LicencaProtocol)inFromServer.readObject();
            
            //Valida o STATUS do retorno
            if(objRetorno.getStatus() == LicencaProtocol.StatusType.LICENCA_FORNECIDA){
                //A licenca foi fornecida pelo servidor
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
                        
                
                
                
                
//                java.awt.EventQueue.invokeLater(new Runnable() {
//                    //Abre o formulário principal
//                    public void run() {
//                        final FrmPrincipal frm = new FrmPrincipal();
//                        //frm.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//                        frm.addWindowListener(new WindowAdapter() {
//                            //Quando o usuário for fechar o sistema, libera a LICENCA no servidor
//                            public void windowClosing(WindowEvent ev) {
//                                
//                                /****************************************************************
//                                 * INICIO - Antes de fechar o sistema libera a licença no servidor
//                                 */
//                                    try {
//                                    
//                                        Socket clientSocket_ = new Socket("127.0.0.1", 6789);
//                                        ObjectOutputStream outToServer_ =  new ObjectOutputStream(clientSocket_.getOutputStream());    
//                                        
//                                        //Libera a licenca
//                                        objRetorno.setStatus(LicencaProtocol.StatusType.LIBERAR_LICENCA);
//                                        //Envia a solicitacao para o servidor
//                                        outToServer_.writeObject(objRetorno);      
//                                
//                                    } catch (IOException ex) {
//                                        Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//                                    }
//                                /*
//                                 * FIM - Antes de fechar o sistema libera a licença no servidor
//                                 ****************************************************************/
//                                
//                                
//                                
////                                try {
////                                    //Libera a licenca
////                                    objLicenca.setStatus(LicencaProtocol.StatusType.LIBERAR_LICENCA);
////                                    //Envia a solicitacao para o servidor
////                                    outToServer.writeObject(objLicenca);
////                                    
////                                    objLicenca = (LicencaProtocol)inFromServer.readObject();
////                                    
////                                    System.out.println("");
////                                    //Fecha conexao
////                                    //clientSocket.close();
////                                } catch (IOException ex) {
////                                    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
////                                } catch (ClassNotFoundException ex) {
////                                    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
////                                }
//                                
//                                
//                                
//                                
//                                
//                                
//                            }
//                        });
//                        frm.setVisible(true);
//                    }
//                });
                
                
                
            }else if(objRetorno.getStatus() == LicencaProtocol.StatusType.SEM_LICENCA){
                JOptionPane.showMessageDialog(null, "Não existe licenças disponíveis para iniciar o sistema!", "Sem licença", JOptionPane.ERROR_MESSAGE);
            }else if(objRetorno.getStatus() == LicencaProtocol.StatusType.SISTEMA_BLOQUEADO){
                JOptionPane.showMessageDialog(null, "O sistema está bloqueado, entre em contato com a Software House", "Aviso", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Erro.....", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }                
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the chave
     */
    public static String getChave() {
        return chave;
    }

    /**
     * @param chave_ the chave to set
     */
    public static void setChave(String chave_) {
        chave = chave_;
    }
}
