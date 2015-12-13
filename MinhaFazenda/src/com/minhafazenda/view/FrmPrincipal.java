/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.view;

import com.minhafazenda.view.relatorio.RelProducaoLeite;
import com.minhafazenda.view.relatorio.RelProducaoLeiteHoje;
import com.minhafazenda.view.relatorio.RelVencimentoVacina;
import com.minhafazenda.library.common.Licenca;
import com.minhafazenda.library.protocol.LicencaProtocol;
import com.minhafazenda.util.UsuarioLogado;
import java.awt.Component;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Rodrigo de Oliveira
 */
public class FrmPrincipal extends javax.swing.JFrame
{

    private FrmCategoriaListagem frmCategoria;
    private FrmRacaListagem frmRaca;
    private FrmUsuarioListagem frmUsuario;
    private FrmUsuarioTipoListagem frmUsuarioTipo;
    private FrmVacinaListagem frmVacina;
    private FrmGrauSangueListagem frmGrauSangue;
    private FrmAnimalListagem frmAnimal;
    private IfrAnimal ifrmAnimal;
    private FrmPropriedadeRuralListagem frmPropriedadeRural;
    private FrmAuditoriaListagem frmAuditoria;
    private RelProducaoLeite relProducaoLeite;
    private RelProducaoLeiteHoje relProducaoLeiteHoje;
    private RelVencimentoVacina relVencimentoVacina;

    private final Thread objThread;
    private Socket clientSocket;

    //public final LicencaProtocol objLicenca;
    private Licenca objMantemLicenca;
    private String chave;

    /**
     * Creates new form FrmPrincipal
     *
     * @param chave
     */
    public FrmPrincipal(final String chave)
    {
        initComponents();

        this.chave = chave;

        // aplica skin = LookAndFeel a todas as janelas
        try
        {

            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
        {
        }
        
        this.setExtendedState(MAXIMIZED_BOTH);

        objThread = new Thread(new Runnable()
        {
            public void run()
            {
                while (true)
                {
                    try
                    {
                        Thread.sleep(1000);

                        clientSocket = new Socket("127.0.0.1", 6789);
                        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
                        ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());

                        LicencaProtocol objLicenca = new LicencaProtocol();
                        objLicenca.setStatus(LicencaProtocol.StatusType.MANTEM_LICENCA);
                        objLicenca.setDataHora(new Date());
                        objLicenca.setChave(chave);

                        //Solicita licenca
                        outToServer.writeObject(objLicenca);
                        //Retorno do servidor
                        objLicenca = (LicencaProtocol) inFromServer.readObject();

                        if (objLicenca.getStatus() == LicencaProtocol.StatusType.LICENCA_RENOVADA)
                        {
                            System.out.println("Licença: Renovada");
                        } else
                        {
                            System.out.println("Licença: NÃO Renovada");
                        }

                        objLicenca.setStatus(LicencaProtocol.StatusType.MANTEM_LICENCA);

                        clientSocket.close();

                    } catch (InterruptedException | IOException | ClassNotFoundException ex)
                    {
                        Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        //Inicia thread
        objThread.start();
        
        if(UsuarioLogado.getAdministrador() == 1){
            //É administrador
            jMenuDiversos.setVisible(true);
            jMenuRelatorio.setVisible(true);
        }else{
            jMenuDiversos.setVisible(false);
            jMenuRelatorio.setVisible(false);
        }
    }

    FrmPrincipal()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void novaJanela(Component janela)
    {
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
        btnACategoria = new javax.swing.JButton();
        btnAUsuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        btnARaca = new javax.swing.JButton();
        btnATipoUsuario = new javax.swing.JButton();
        btnAVacina = new javax.swing.JButton();
        btnAGrauSangue = new javax.swing.JButton();
        btnAAnimal = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnAPropriedadeRural = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        menuCadastroCategoria = new javax.swing.JMenuItem();
        menuCadastroRaca = new javax.swing.JMenuItem();
        menuCadastroUsuario = new javax.swing.JMenuItem();
        menuCadastroUsuarioTipo = new javax.swing.JMenuItem();
        menuCadastroCategoria1 = new javax.swing.JMenuItem();
        jMenuDiversos = new javax.swing.JMenu();
        menuAuditoria = new javax.swing.JMenuItem();
        jMenuRelatorio = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

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

        btnACategoria.setText("Categorias");
        btnACategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnACategoriaActionPerformed(evt);
            }
        });

        btnAUsuario.setText("Usuários");
        btnAUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAUsuarioActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPane1);

        btnARaca.setText("Raças");
        btnARaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnARacaActionPerformed(evt);
            }
        });

        btnATipoUsuario.setText("Tipo de Usuário");
        btnATipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnATipoUsuarioActionPerformed(evt);
            }
        });

        btnAVacina.setText("Vacina");
        btnAVacina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAVacinaActionPerformed(evt);
            }
        });

        btnAGrauSangue.setText("Grau de Sangue");
        btnAGrauSangue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAGrauSangueActionPerformed(evt);
            }
        });

        btnAAnimal.setText("Animal");
        btnAAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAAnimalActionPerformed(evt);
            }
        });

        jButton1.setText("Animal Teste");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAPropriedadeRural.setText("Propriedade Rural");
        btnAPropriedadeRural.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAPropriedadeRuralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAPropriedadeRural, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAGrauSangue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAVacina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnATipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnARaca, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnACategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(btnAUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnACategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnARaca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnATipoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAVacina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAGrauSangue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAAnimal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAPropriedadeRural)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(472, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
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

        menuCadastroUsuarioTipo.setText("Tipo de Usuário");
        menuCadastroUsuarioTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroUsuarioTipoActionPerformed(evt);
            }
        });
        jMenuCadastros.add(menuCadastroUsuarioTipo);

        menuCadastroCategoria1.setText("Vacinas");
        menuCadastroCategoria1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                menuCadastroCategoria1FocusLost(evt);
            }
        });
        menuCadastroCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroCategoria1ActionPerformed(evt);
            }
        });
        jMenuCadastros.add(menuCadastroCategoria1);

        jMenuBar1.add(jMenuCadastros);

        jMenuDiversos.setText("Diversos");

        menuAuditoria.setText("Auditoria");
        menuAuditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAuditoriaActionPerformed(evt);
            }
        });
        jMenuDiversos.add(menuAuditoria);

        jMenuBar1.add(jMenuDiversos);

        jMenuRelatorio.setText("Relatórios");

        jMenuItem1.setText("Produção de leite");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItem1);

        jMenuItem2.setText("Produção de leite hoje");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItem2);

        jMenuItem3.setText("Vencimento de vacina");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuRelatorio.add(jMenuItem3);

        jMenuBar1.add(jMenuRelatorio);

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
        if (frmRaca == null)
        {
            //Cria o form
            frmRaca = new FrmRacaListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmRaca);
            //diz que a janela interna é maximizável
            frmRaca.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmRaca.isVisible())
        {
            //Mostra o formulário
            frmRaca.setVisible(true);
        }
    }//GEN-LAST:event_menuCadastroRacaActionPerformed

    private void menuCadastroCategoriaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuCadastroCategoriaActionPerformed
    {//GEN-HEADEREND:event_menuCadastroCategoriaActionPerformed
        if (frmCategoria == null)
        {
            //Cria o form
            frmCategoria = new FrmCategoriaListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmCategoria);
            //diz que a janela interna é maximizável
            frmCategoria.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmCategoria.isVisible())
        {
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

    private void btnARacaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnARacaActionPerformed
    {//GEN-HEADEREND:event_btnARacaActionPerformed
        if (frmRaca == null)
        {
            //Cria o form
            frmRaca = new FrmRacaListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmRaca);
            //diz que a janela interna é maximizável
            frmRaca.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmRaca.isVisible())
        {
            //Mostra o formulário
            frmRaca.setVisible(true);
        }

    }//GEN-LAST:event_btnARacaActionPerformed

    private void btnACategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnACategoriaActionPerformed
        if (frmCategoria == null)
        {
            //Cria o form
            frmCategoria = new FrmCategoriaListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmCategoria);
            //diz que a janela interna é maximizável
            frmCategoria.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmCategoria.isVisible())
        {
            //Mostra o formulário
            frmCategoria.setVisible(true);
        }

    }//GEN-LAST:event_btnACategoriaActionPerformed

    private void btnAUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAUsuarioActionPerformed
        if (frmUsuario == null)
        {
            //Cria o form
            frmUsuario = new FrmUsuarioListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmUsuario);
            //diz que a janela interna é maximizável
            frmUsuario.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmUsuario.isVisible())
        {
            //Mostra o formulário
            frmUsuario.setVisible(true);
        }
    }//GEN-LAST:event_btnAUsuarioActionPerformed

    private void menuCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroUsuarioActionPerformed
        if (frmUsuario == null)
        {
            //Cria o form
            frmUsuario = new FrmUsuarioListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmUsuario);
            //diz que a janela interna é maximizável
            frmUsuario.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmUsuario.isVisible())
        {
            //Mostra o formulário
            frmUsuario.setVisible(true);
        }
    }//GEN-LAST:event_menuCadastroUsuarioActionPerformed

    private void menuAuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAuditoriaActionPerformed
        if(frmAuditoria == null){
            frmAuditoria = new FrmAuditoriaListagem();
            this.jDesktopPane1.add(frmAuditoria);
            frmAuditoria.setMaximizable(true);
        }
        
        if(!frmAuditoria.isVisible()){
            frmAuditoria.setVisible(true);
        }
    }//GEN-LAST:event_menuAuditoriaActionPerformed

    private void menuCadastroUsuarioTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroUsuarioTipoActionPerformed
        if (frmUsuarioTipo == null)
        {
            //Cria o form
            frmUsuarioTipo = new FrmUsuarioTipoListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmUsuarioTipo);
            //diz que a janela interna é maximizável
            frmUsuarioTipo.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmUsuarioTipo.isVisible())
        {
            //Mostra o formulário
            frmUsuarioTipo.setVisible(true);
        }
    }//GEN-LAST:event_menuCadastroUsuarioTipoActionPerformed

    private void menuCadastroCategoria1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_menuCadastroCategoria1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCadastroCategoria1FocusLost

    private void menuCadastroCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroCategoria1ActionPerformed
        if (frmVacina == null)
        {
            //Cria o form
            frmVacina = new FrmVacinaListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmVacina);
            //diz que a janela interna é maximizável
            frmVacina.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmVacina.isVisible())
        {
            //Mostra o formulário
            frmVacina.setVisible(true);
        }

    }//GEN-LAST:event_menuCadastroCategoria1ActionPerformed

    private void btnATipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnATipoUsuarioActionPerformed
        if (frmUsuarioTipo == null)
        {
            //Cria o form
            frmUsuarioTipo = new FrmUsuarioTipoListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmUsuarioTipo);
            //diz que a janela interna é maximizável
            frmUsuarioTipo.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmUsuarioTipo.isVisible())
        {
            //Mostra o formulário
            frmUsuarioTipo.setVisible(true);
        }
    }//GEN-LAST:event_btnATipoUsuarioActionPerformed

    private void btnAVacinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAVacinaActionPerformed
        if (frmVacina == null)
        {
            //Cria o form
            frmVacina = new FrmVacinaListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmVacina);
            //diz que a janela interna é maximizável
            frmVacina.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmVacina.isVisible())
        {
            //Mostra o formulário
            frmVacina.setVisible(true);
        }

    }//GEN-LAST:event_btnAVacinaActionPerformed

    private void btnAGrauSangueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAGrauSangueActionPerformed
        if (frmGrauSangue == null)
        {
            //Cria o form
            frmGrauSangue = new FrmGrauSangueListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmGrauSangue);
            //diz que a janela interna é maximizável
            frmGrauSangue.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmGrauSangue.isVisible())
        {
            //Mostra o formulário
            frmGrauSangue.setVisible(true);
        }

    }//GEN-LAST:event_btnAGrauSangueActionPerformed

    private void btnAAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAAnimalActionPerformed
        if (frmAnimal == null)
        {
            //Cria o form
            frmAnimal = new FrmAnimalListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmAnimal);
            //diz que a janela interna é maximizável
            frmAnimal.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmAnimal.isVisible())
        {
            //Mostra o formulário
            frmAnimal.setVisible(true);
        }
    }//GEN-LAST:event_btnAAnimalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
       if (ifrmAnimal == null)
        {
            //Cria o form
            ifrmAnimal = new IfrAnimal();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(ifrmAnimal);
            //diz que a janela interna é maximizável
            ifrmAnimal.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!ifrmAnimal.isVisible())
        {
            //Mostra o formulário
            ifrmAnimal.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAPropriedadeRuralActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAPropriedadeRuralActionPerformed
    {//GEN-HEADEREND:event_btnAPropriedadeRuralActionPerformed
       if (frmPropriedadeRural == null)
        {
            //Cria o form
            frmPropriedadeRural = new FrmPropriedadeRuralListagem();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(frmPropriedadeRural);
            //diz que a janela interna é maximizável
            frmPropriedadeRural.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!frmPropriedadeRural.isVisible())
        {
            //Mostra o formulário
            frmPropriedadeRural.setVisible(true);
        }
    }//GEN-LAST:event_btnAPropriedadeRuralActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (relProducaoLeite == null)
        {
            //Cria o form
            relProducaoLeite = new RelProducaoLeite();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(relProducaoLeite);
            //diz que a janela interna é maximizável
            relProducaoLeite.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!relProducaoLeite.isVisible())
        {
            //Mostra o formulário
            relProducaoLeite.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (relProducaoLeiteHoje == null)
        {
            //Cria o form
            relProducaoLeiteHoje = new RelProducaoLeiteHoje();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(relProducaoLeiteHoje);
            //diz que a janela interna é maximizável
            relProducaoLeiteHoje.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!relProducaoLeiteHoje.isVisible())
        {
            //Mostra o formulário
            relProducaoLeiteHoje.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (relVencimentoVacina == null){
            //Cria o form
            relVencimentoVacina = new RelVencimentoVacina();
            //Adiciona o formulario dentro do DESKTOP
            this.jDesktopPane1.add(relVencimentoVacina);
            //diz que a janela interna é maximizável
            relVencimentoVacina.setMaximizable(true);
            //set o tamanho máximo dela, que depende da janela pai
            //frmCategoria.setMaximum(true);
        }
        if (!relVencimentoVacina.isVisible())
        {
            //Mostra o formulário
            relVencimentoVacina.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
    private javax.swing.JButton btnAAnimal;
    private javax.swing.JButton btnACategoria;
    private javax.swing.JButton btnAGrauSangue;
    private javax.swing.JButton btnAPropriedadeRural;
    private javax.swing.JButton btnARaca;
    private javax.swing.JButton btnATipoUsuario;
    private javax.swing.JButton btnAUsuario;
    private javax.swing.JButton btnAVacina;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenu jMenuDiversos;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenu jMenuRelatorio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JMenuItem menuAuditoria;
    private javax.swing.JMenuItem menuCadastroCategoria;
    private javax.swing.JMenuItem menuCadastroCategoria1;
    private javax.swing.JMenuItem menuCadastroRaca;
    private javax.swing.JMenuItem menuCadastroUsuario;
    private javax.swing.JMenuItem menuCadastroUsuarioTipo;
    // End of variables declaration//GEN-END:variables
}
