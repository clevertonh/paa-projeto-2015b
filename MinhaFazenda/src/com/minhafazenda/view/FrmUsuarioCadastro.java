/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.view;

import com.minhafazenda.controller.UsuarioController;
import com.minhafazenda.controller.UsuarioTipoController;
import com.minhafazenda.model.Usuario;
import com.minhafazenda.model.UsuarioTipo;
import com.minhafazenda.util.ComboBoxItem;


/**
 *
 * @author cleverton
 */
public class FrmUsuarioCadastro extends javax.swing.JDialog {

    private final UsuarioController objController;
    private Usuario objUsuario;
    private boolean edicao;
    

    /**
     * Creates new form FrmCategoriaCadastro
     */
    public FrmUsuarioCadastro() {
        initComponents();
        //Cria o objeto de controller
        this.objController = new UsuarioController();
        //Carrega comboBox com os dados
        jComboBoxTipoUsuario.setModel(this.objController.carregaComboTipoUsuario());
    }

    public void fNovoRegistro() {
        //
        this.objUsuario = new Usuario();
        //Por padrão oculta o botão excluir
        btnExcluir.setEnabled(false);
        //POr padrão limpa o campo texto
        txtDescricao.setText("");
        txtSenha.setText("");
        //Adiciona o status de edição
        this.edicao = false;
        //Seta o focu no campo de descrição ao abrir o formulário
        txtDescricao.requestFocus();
    }

    public void fCarregaCadastro(int id) {
        //Se for passado um código por parâmetro, pesquisa no banco
        this.objUsuario = this.objController.findById(id);
        //Carrega na tela a descrição 
        txtDescricao.setText(this.objUsuario.getUsuario());
        //Carrega senha
        txtSenha.setText(this.objUsuario.getSenha());
        
        if(this.objUsuario.getAdministrador() == 1){
            eAdministrador.setSelected(true);
        }else{
            eAdministrador.setSelected(false);
        }
        
        //Carrega na tela o tipo de usário
        jComboBoxTipoUsuario.getEditor().setItem(this.objUsuario.getUsuarioTipo().toString());
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
        jLabel1 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxTipoUsuario = new javax.swing.JComboBox();
        txtSenha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        eAdministrador = new javax.swing.JCheckBox();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setTitle("Cadastro de Usuários");
        setName(""); // NOI18N

        jLabel1.setText("Descrição:");

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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

        jLabel2.setText("Tipo:");

        jComboBoxTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoUsuarioActionPerformed(evt);
            }
        });

        jLabel3.setText("Senha:");

        eAdministrador.setText("É administrador");
        eAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eAdministradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtSenha)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                        .addComponent(jComboBoxTipoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(eAdministrador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eAdministrador))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
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
        objUsuario.setUsuario(txtDescricao.getText());
        //Senha
        objUsuario.setSenha(txtSenha.getText());
        
        if(eAdministrador.isSelected()){
            objUsuario.setAdministrador(1);
        }else{
            objUsuario.setAdministrador(0);
        }
        
        //Recebe o valor selecionado
        ComboBoxItem objItem = (ComboBoxItem)jComboBoxTipoUsuario.getSelectedItem();
        //Solicita o OBJETO do tipo de usuário
        UsuarioTipo objTipoTemp = new UsuarioTipoController().findById(objItem.getId());
        
        UsuarioTipo objTipo = new UsuarioTipo();
        objTipo.setId(objTipoTemp.getId());
        objTipo.setDescricao(objTipoTemp.getDescricao());
        
        objUsuario.setUsuarioTipo(objTipo);
        
        //Verifica se deve adicionar ou atualizar um registro
        if (this.edicao) {
            if (objController.update(objUsuario)) {
                //Limpa o campo de descrição da Categoria
                txtDescricao.setText("");
                //Fecha o formulário
                this.setVisible(false);
            }
        } else {
            //Chama o méotod INSERT do conttroler
            if (objController.insert(objUsuario)) {
                //Limpa o campo de descrição da Categoria
                txtDescricao.setText("");
                //Fecha o formulário
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        objController.delete(objUsuario);
        //Fecha o formulário
        this.setVisible(false);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jComboBoxTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoUsuarioActionPerformed

    private void eAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eAdministradorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox eAdministrador;
    private javax.swing.JComboBox jComboBoxTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
