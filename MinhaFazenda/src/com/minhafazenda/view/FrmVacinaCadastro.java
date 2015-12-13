/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.view;

import com.minhafazenda.controller.VacinaController;
import com.minhafazenda.model.Vacina;
import javax.swing.JOptionPane;

/**
 *
 * @author cleverton
 */
public class FrmVacinaCadastro extends javax.swing.JDialog {

    private final VacinaController objController;
    private Vacina objVacina;
    private boolean edicao;

    /**
     * Creates new form FrmCategoriaCadastro
     */
    public FrmVacinaCadastro() {
        initComponents();
        //Cria o objeto de controller
        this.objController = new VacinaController();
    }

    public void fNovoRegistro() {
        //
        this.objVacina = new Vacina();
        //Por padrão oculta o botão excluir
        btnExcluir.setEnabled(false);
        //Por padrão limpa o campo texto
        txtDescricao.setText("");
        txtDescricao.setText("");
        txtDiasValidade.setText("");
        txtModoUso.setText("");
        txtIndicacoes.setText("");
        //Adiciona o status de edição
        this.edicao = false;
        //Seta o focu no campo de descrição ao abrir o formulário
        txtDescricao.requestFocus();
    }

    public void fCarregaCadastro(int id) {
        //Se for passado um código por parâmetro, pesquisa no banco
        this.objVacina = this.objController.findById(id);
        //Carrega na tela a descrição
        txtDescricao.setText(this.objVacina.getDescricao());
        //Carrega na tela o modo de uso da vacina
        txtModoUso.setText(this.objVacina.getModoUso());
        //Carrega na tela as indicaçẽos da vacina
        txtIndicacoes.setText(this.objVacina.getIndicacoes());
        //Carrega na tela os dias de Validade da Vacina
        txtDiasValidade.setText(this.objVacina.getDiasValidade().toString());
        //Adiciona o status de edição
        this.edicao = true;
        //MOstra o botão excluir
        btnExcluir.setEnabled(true);
        //Seta o focu no campo de descrição ao abrir o formulário
        txtDescricao.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtModoUso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDiasValidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtIndicacoes = new javax.swing.JTextArea();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setTitle("Cadastro de Vacinas");
        setName(""); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Descrição:");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

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
                    .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Modo de Uso:");

        txtModoUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModoUsoActionPerformed(evt);
            }
        });

        jLabel3.setText("Indicações:");

        txtDiasValidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiasValidadeActionPerformed(evt);
            }
        });

        jLabel4.setText("Dias de Validade:");

        txtIndicacoes.setColumns(20);
        txtIndicacoes.setRows(5);
        jScrollPane1.setViewportView(txtIndicacoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiasValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(txtModoUso, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                        .addComponent(txtDescricao)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtModoUso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiasValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))))
        );

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        //Adiciona os atributos
        objVacina.setDescricao(txtDescricao.getText());
        objVacina.setModoUso(txtModoUso.getText());
        objVacina.setIndicacoes(txtIndicacoes.getText());

        try {
            int aux = Integer.parseInt(txtDiasValidade.getText());
            objVacina.setDiasValidade(aux);
            //Verifica se deve adicionar ou atualizar um registro
            if (this.edicao) {
                //Chama o méotod INSERT do conttroler
                if (objController.update(objVacina)) {
                    //Limpa os campos
                    txtDiasValidade.setText("");
                    txtModoUso.setText("");
                    txtIndicacoes.setText("");
                    txtDescricao.setText("");
                    //Fecha o formulário
                    this.setVisible(false);
                }
            } else {
                //Chama o méotod INSERT do conttroler
                if (objController.insert(objVacina)) {
                    //Limpa os campos
                    txtDiasValidade.setText("");
                    txtModoUso.setText("");
                    txtIndicacoes.setText("");
                    txtDescricao.setText("");
                    //Fecha o formulário
                    this.setVisible(false);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor informado para campo 'Dias de Validade' inválido!", "Atenção", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        objController.delete(objVacina);

        //Limpa os campos
        txtDescricao.setText("");
        txtDiasValidade.setText("");
        txtModoUso.setText("");
        txtIndicacoes.setText("");

        //Fecha o formulário
        this.setVisible(false);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtModoUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModoUsoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModoUsoActionPerformed

    private void txtDiasValidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiasValidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiasValidadeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtDiasValidade;
    private javax.swing.JTextArea txtIndicacoes;
    private javax.swing.JTextField txtModoUso;
    // End of variables declaration//GEN-END:variables
}