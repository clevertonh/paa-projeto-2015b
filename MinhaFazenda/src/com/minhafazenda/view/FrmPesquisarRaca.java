/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.view;

import com.minhafazenda.controller.RacaController;
import com.minhafazenda.util.ForcedListSelectionModel;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author rodrigo
 */
public class FrmPesquisarRaca extends javax.swing.JDialog
{

    private final RacaController objController;
    private String idRaca;
    private String nomeRaca;

    /**
     * Creates new form
     */
    FrmPesquisarRaca()
    {
//        super();
        initComponents();

        //Define o título para a janela
        this.setTitle("SGF - Relação de Raças");
        //Inicia o objeto de controller
        objController = new RacaController();
        //Carrega a lista de categorias no controller
        objController.findByAll();
        //Seta o controller no JTABLE
        jTableRaca.setModel(objController);
        //
        jTableRaca.setFillsViewportHeight(true);

        //LIbera a seleção das linhas da jTAble
        jTableRaca.setRowSelectionAllowed(true);
        //Aceita somente uma linha selecionada por vez
        jTableRaca.setSelectionModel(new ForcedListSelectionModel());

        //Configuração da Jtable
        TableColumnModel objColumn = jTableRaca.getColumnModel();
        objColumn.getColumn(0).setMaxWidth(100);
        
        pesquisar();
    }

    public void pesquisar()
    {
        //Efetua a busca pela descricão no conttroler
        objController.findByAll(txtBusca.getText());
        //
        jTableRaca.setFillsViewportHeight(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRaca = new javax.swing.JTable();
        txtBusca = new javax.swing.JTextField();
        btnSelecionar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableRaca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableRaca);

        txtBusca.setName(""); // NOI18N
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                txtBuscaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                txtBuscaKeyReleased(evt);
            }
        });

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.setName("btnBuscar"); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSelecionar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelecionar))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("Pesquisar Cidade");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtBuscaKeyPressed
    {//GEN-HEADEREND:event_txtBuscaKeyPressed

        //Verifica se foi pressionado a tecla ENTER
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //Realiza pesquisa
            pesquisar();
            //Seleciona o texto do campo, para que o usuário já possa realizar outra pesquisa
            txtBusca.selectAll();
        }
    }//GEN-LAST:event_txtBuscaKeyPressed

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtBuscaKeyReleased
    {//GEN-HEADEREND:event_txtBuscaKeyReleased
        pesquisar();
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSelecionarActionPerformed
    {//GEN-HEADEREND:event_btnSelecionarActionPerformed
        if (jTableRaca.getSelectedRow() >= 0) {
            this.idRaca = String.valueOf(jTableRaca.getValueAt(jTableRaca.getSelectedRow(), 0));
            this.nomeRaca = String.valueOf(jTableRaca.getValueAt(jTableRaca.getSelectedRow(), 1));

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para edição!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBuscarActionPerformed
    {//GEN-HEADEREND:event_btnBuscarActionPerformed
        pesquisar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    public String getId()
    {
        return idRaca;
    }

    public void setId(String id)
    {
        this.idRaca = id;
    }

    public String getNome()
    {
        return nomeRaca;
    }

    public void setNome(String nome)
    {
        this.nomeRaca = nome;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRaca;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
