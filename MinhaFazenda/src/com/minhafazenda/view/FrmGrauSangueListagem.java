/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.view;

import com.minhafazenda.controller.GrauSangueController;
import com.minhafazenda.util.ForcedListSelectionModel;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author cleverton
 */
public class FrmGrauSangueListagem extends javax.swing.JInternalFrame {

    private FrmGrauSangueCadastro frm;
    private final GrauSangueController objController;

    /**
     * Creates new form FrmCategoriaListagem
     */
    public FrmGrauSangueListagem() {
        //
        initComponents();
        //Define o título para a janela
        this.setTitle("SGF - Relação de G.S.");
        //Inicia o objeto de controller
        objController = new GrauSangueController();
        //Carrega a lista de categorias no controller
        objController.findByAll();
        //Seta o controller no JTABLE
        jTableGrauSangue.setModel(objController);
        //
        jTableGrauSangue.setFillsViewportHeight(true);

        //LIbera a seleção das linhas da jTAble
        jTableGrauSangue.setRowSelectionAllowed(true);
        //Aceita somente uma linha selecionada por vez
        jTableGrauSangue.setSelectionModel(new ForcedListSelectionModel());

        //Configuração da Jtable
        TableColumnModel objColumn = jTableGrauSangue.getColumnModel();
        objColumn.getColumn(0).setMaxWidth(100);
    }

    public void pesquisar() {
        //Efetua a busca pela descricão no conttroler
        objController.findByDescricao(txtBusca.getText());
        //
        jTableGrauSangue.setFillsViewportHeight(true);
    }

    public void fAbreCadastro(int id) {
        if (frm == null) {
            frm = new FrmGrauSangueCadastro();
            frm.setModal(true);
        }

        if (id > 0) {
            frm.fCarregaCadastro(id);
        }

        if (frm.isVisible()) {
            frm.setVisible(false);
        } else {
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
        }

        pesquisar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGrauSangue = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setName("Relação de Categorias"); // NOI18N
        setVerifyInputWhenFocusTarget(false);

        btnBuscar.setText("Buscar");
        btnBuscar.setName("btnBuscar"); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBusca.setName(""); // NOI18N
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.setName("btnNovo"); // NOI18N
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        jTableGrauSangue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableGrauSangue.setToolTipText("");
        jTableGrauSangue.setRowSelectionAllowed(false);
        jTableGrauSangue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGrauSangueMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableGrauSangue);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.setToolTipText("");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo)
                    .addComponent(btnAlterar)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        txtBusca.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanel1.getAccessibleContext().setAccessibleName("Relação de Categorias");
        jPanel1.getAccessibleContext().setAccessibleDescription("Relação de Categorias");

        getAccessibleContext().setAccessibleName("Cadastro de Categorias");
        getAccessibleContext().setAccessibleDescription("Cadastro de Categorias");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        pesquisar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        if (frm == null) {
            frm = new FrmGrauSangueCadastro();
            frm.setModal(true);
        }

        frm.fNovoRegistro();

        if (frm.isVisible()) {
            frm.setVisible(false);
        } else {
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
        }

        pesquisar();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed

        //Verifica se foi pressionado a tecla ENTER
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //Realiza pesquisa
            pesquisar();
            //Seleciona o texto do campo, para que o usuário já possa realizar outra pesquisa
            txtBusca.selectAll();
        }
    }//GEN-LAST:event_txtBuscaKeyPressed

    private void jTableGrauSangueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGrauSangueMouseClicked

        if (evt.getClickCount() == 2) {
            fAbreCadastro((int) jTableGrauSangue.getValueAt(jTableGrauSangue.getSelectedRow(), 0));
        }
    }//GEN-LAST:event_jTableGrauSangueMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (jTableGrauSangue.getSelectedRow() >= 0) {
            fAbreCadastro((int) jTableGrauSangue.getValueAt(jTableGrauSangue.getSelectedRow(), 0));
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para edição!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        pesquisar();
    }//GEN-LAST:event_txtBuscaKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableGrauSangue;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
