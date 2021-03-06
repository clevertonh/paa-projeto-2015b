/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.view.relatorio;

import com.minhafazenda.controller.ViewVacinaVencimentoController;
import com.minhafazenda.model.ViewVacinaVencimento;
import com.minhafazenda.util.ForcedListSelectionModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author cleverton
 */
public class RelVencimentoVacina extends javax.swing.JInternalFrame {

    private final ViewVacinaVencimentoController objController;

    /**
     * Creates new form FrmCategoriaListagem
     */
    public RelVencimentoVacina() {
        initComponents();
        this.setTitle("SGF - Relatório");
        objController = new ViewVacinaVencimentoController();
        //Carrega a lista de categorias no controller
        objController.findByAll();
        //Seta o controller no JTABLE
        jTableCategoria.setModel(objController);
        //
        jTableCategoria.setFillsViewportHeight(true);

        //LIbera a seleção das linhas da jTAble
        jTableCategoria.setRowSelectionAllowed(true);
        //Aceita somente uma linha selecionada por vez
        jTableCategoria.setSelectionModel(new ForcedListSelectionModel());

        //Configuração da Jtable
        TableColumnModel objColumn = jTableCategoria.getColumnModel();
        objColumn.getColumn(0).setMaxWidth(100);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCategoria = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setName("Relação de Categorias"); // NOI18N
        setVerifyInputWhenFocusTarget(false);

        jTableCategoria.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableCategoria.setToolTipText("");
        jTableCategoria.setRowSelectionAllowed(false);
        jTableCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCategoriaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCategoria);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
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
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanel1.getAccessibleContext().setAccessibleName("Relação de Categorias");
        jPanel1.getAccessibleContext().setAccessibleDescription("Relação de Categorias");

        getAccessibleContext().setAccessibleName("Cadastro de Categorias");
        getAccessibleContext().setAccessibleDescription("Cadastro de Categorias");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void jTableCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCategoriaMouseClicked

    }//GEN-LAST:event_jTableCategoriaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCategoria;
    // End of variables declaration//GEN-END:variables
}
