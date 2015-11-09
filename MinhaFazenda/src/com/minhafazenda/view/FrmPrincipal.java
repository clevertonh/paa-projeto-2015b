/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.view;

import com.minhafazenda.library.common.Licenca;
import com.minhafazenda.library.protocol.LicencaProtocol;
import java.awt.Component;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Rodrigo de Oliveira
 */
public class FrmPrincipal extends javax.swing.JFrame {

    private FrmCategoriaListagem frmCategoria;
    private FrmRacaListagem frmRaca;
    private FrmUsuarioListagem frmUsuario;
    
    
    private final Thread objThread;
    private Socket clientSocket;

    //public final LicencaProtocol objLicenca;
    private Licenca objMantemLicenca;
    private String chave;
    
    /**
     * Creates new form FrmPrincipal
     * @param chave
     */
    public FrmPrincipal(final String chave) {
        initComponents();

        this.chave = chave;
        
        // aplica skin = LookAndFeel a todas as janelas
        try {

            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }

        this.setExtendedState(MAXIMIZED_BOTH);

        
        objThread = new Thread(new Runnable() {
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);

                        clientSocket = new Socket("127.0.0.1", 6789);
                        ObjectOutputStream outToServer =  new ObjectOutputStream(clientSocket.getOutputStream());
                        ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
                    
                        LicencaProtocol objLicenca = new LicencaProtocol();
                        objLicenca.setStatus(LicencaProtocol.StatusType.MANTEM_LICENCA);
                        objLicenca.setDataHora(new Date());
                        objLicenca.setChave(chave);


                        //Solicita licenca
                        outToServer.writeObject(objLicenca);
                        //Retorno do servidor
                        objLicenca = (LicencaProtocol)inFromServer.readObject();

                        if(objLicenca.getStatus() == LicencaProtocol.StatusType.LICENCA_RENOVADA)
                            System.out.println("Licença: Renovada");
                        else
                            System.out.println("Licença: NÃO Renovada");

                        objLicenca.setStatus(LicencaProtocol.StatusType.MANTEM_LICENCA);

                        clientSocket.close();

                    } catch (InterruptedException | IOException | ClassNotFoundException ex) {
                        Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        //Inicia thread
        objThread.start();
    }

    public void novaJanela(Component janela) {
        jDesktopPane1.add(janela);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        btnCategoria = new javax.swing.JButton();
        btnItem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        btnRaca = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        menuCadastroCategoria = new javax.swing.JMenuItem();
        menuCadastroRaca = new javax.swing.JMenuItem();
        menuCadastroUsuario = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jFormattedTextField1.setText("jFormattedTextField1");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGF - Sistema Gerenciador de Fazendas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        jDesktopPane1.setBackground(new java.awt.Color(240, 240, 240));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Atalhos", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        btnCategoria.setText("Categorias");
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        btnItem.setText("Usuários");
        btnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        btnRaca.setText("Raças");
        btnRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRacaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRaca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(btnItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRaca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnItem)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(511, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(356, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenuCadastros.setText("Cadastros");
        jMenuCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastrosActionPerformed(evt);
            }
        });

        menuCadastroCategoria.setText("Categorias");
        menuCadastroCategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                menuCadastroCategoriaFocusLost(evt);
            }
        });
        menuCadastroCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroCategoriaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(menuCadastroCategoria);

        menuCadastroRaca.setText("Raças");
        menuCadastroRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroRacaActionPerformed(evt);
            }
        });
        jMenuCadastros.add(menuCadastroRaca);

        menuCadastroUsuario.setText("Usuários");
        menuCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroUsuarioActionPerformed(evt);
            }
        });
        jMenuCadastros.add(menuCadastroUsuario);

        jMenuBar1.add(jMenuCadastros);

        jMenu1.setText("jMenu1");

        jMenuItem2.setText("jMenuItem2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleName("Gerenciador");
        jMenuBar1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastrosActionPerformed
        // jMenu1.setEnabled(false);
    }//GEN-LAST:event_jMenuCadastrosActionPerformed

    private void menuCadastroRacaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuCadastroRacaActionPerformed
    {//GEN-HEADEREND:event_menuCadastroRacaActionPerformed
        if (frmRaca == null) {
            //Cria o form
            frmRaca = new FrmRacaListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmRaca);
            //diz que a janela interna é maximizável
            frmRaca.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmRaca.isVisible()) {
            //Mostra o formulário
            frmRaca.setVisible(true);
        }
    }//GEN-LAST:event_menuCadastroRacaActionPerformed

    private void menuCadastroCategoriaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuCadastroCategoriaActionPerformed
    {//GEN-HEADEREND:event_menuCadastroCategoriaActionPerformed
        if (frmCategoria == null) {
            //Cria o form
            frmCategoria = new FrmCategoriaListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmCategoria);
            //diz que a janela interna é maximizável
            frmCategoria.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmCategoria.isVisible()) {
            //Mostra o formulário
            frmCategoria.setVisible(true);
        }


    }//GEN-LAST:event_menuCadastroCategoriaActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowStateChanged
    {//GEN-HEADEREND:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void menuCadastroCategoriaFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_menuCadastroCategoriaFocusLost
    {//GEN-HEADEREND:event_menuCadastroCategoriaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCadastroCategoriaFocusLost

    private void btnRacaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRacaActionPerformed
    {//GEN-HEADEREND:event_btnRacaActionPerformed
        if (frmRaca == null) {
            //Cria o form
            frmRaca = new FrmRacaListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmRaca);
            //diz que a janela interna é maximizável
            frmRaca.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmRaca.isVisible()) {
            //Mostra o formulário
            frmRaca.setVisible(true);
        }

    }//GEN-LAST:event_btnRacaActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        if (frmCategoria == null) {
            //Cria o form
            frmCategoria = new FrmCategoriaListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmCategoria);
            //diz que a janela interna é maximizável
            frmCategoria.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmCategoria.isVisible()) {
            //Mostra o formulário
            frmCategoria.setVisible(true);
        }

    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemActionPerformed
        if (frmUsuario == null) {
            //Cria o form
            frmUsuario = new FrmUsuarioListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmUsuario);
            //diz que a janela interna é maximizável
            frmUsuario.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmUsuario.isVisible()) {
            //Mostra o formulário
            frmUsuario.setVisible(true);
        }
    }//GEN-LAST:event_btnItemActionPerformed

    private void menuCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroUsuarioActionPerformed
        if (frmUsuario == null) {
            //Cria o form
            frmUsuario = new FrmUsuarioListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmUsuario);
            //diz que a janela interna é maximizável
            frmUsuario.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmUsuario.isVisible()) {
            //Mostra o formulário
            frmUsuario.setVisible(true);
        }
    }//GEN-LAST:event_menuCadastroUsuarioActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//        teste janelaTU = new teste();
//        janelaTU.setVisible(true);
//        this.dispose();

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnItem;
    private javax.swing.JButton btnRaca;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JMenuItem menuCadastroCategoria;
    private javax.swing.JMenuItem menuCadastroRaca;
    private javax.swing.JMenuItem menuCadastroUsuario;
    // End of variables declaration//GEN-END:variables
}
