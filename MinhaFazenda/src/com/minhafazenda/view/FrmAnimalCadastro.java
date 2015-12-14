/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.view;

import com.minhafazenda.controller.AnimalController;
import com.minhafazenda.model.Animal;
import com.minhafazenda.model.Categoria;
import com.minhafazenda.model.GrauSangue;
import com.minhafazenda.model.PropriedadeRural;
import com.minhafazenda.model.Raca;
import com.minhafazenda.util.Formatacao;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cleverton
 */
public class FrmAnimalCadastro extends javax.swing.JDialog
{
    private Formatacao formatacao;
    private final AnimalController objController;
    private Animal objAnimal;
    private boolean edicao;
    private FrmGrauSangueListagem frmGrauSangue;
    private FrmPesquisarRaca frmPesqRaca;
    private FrmPesquisarCategoria frmPesqCategoria;
    private FrmPesquisarGrauSangue frmPesqGrauSangue;
    private FrmPesquisarPropriedadeRural frmPesqPropriedadeRural;

    /**
     * Creates new form FrmCategoriaCadastro
     */
    public FrmAnimalCadastro()
    {
        initComponents();
        //Cria o objeto de controller
        this.objController = new AnimalController();
        desabilitarEdicao();
    }
    
    public void fNovoRegistro()
    {
        //
        this.objAnimal = new Animal();
        //Por padrão oculta o botão excluir
        btnExcluir.setEnabled(false);
        //Por padrão limpa o campo texto
        limparCampos();
        //Adiciona o status de edição
        this.edicao = false;
        //Seta o focu no campo de descrição ao abrir o formulário
        txtNome.requestFocus();
    }
    
    public void fCarregaCadastro(int id)
    {
        //Se for passado um código por parâmetro, pesquisa no banco
        this.objAnimal = this.objController.findById(id);
        //Carrega na tela o nome
        txtNome.setText(this.objAnimal.getNome());
        //Carrega na tela a raça do animal
        txtIdRaca.setText(this.objAnimal.getRaca().getId().toString());
        txtDescRaca.setText(this.objAnimal.getRaca().getDescricao());
        //Carrega na tela a categoria do animal
        txtIdCategoria.setText(this.objAnimal.getCategoria().getId().toString());
        txtDescCategoria.setText(this.objAnimal.getCategoria().getDescricao());
        //Carrega na tela o sexo do animal
        txtSexo.setText(this.objAnimal.getSexo().toString());
        //Carrega na tela o grau de sangue do animal
        txtIdGrauSangue.setText(this.objAnimal.getGrauSangue().getId().toString());
        txtDescGrauSangue.setText(this.objAnimal.getGrauSangue().getDescricao());
        //Carrega na tela a data de nascimento do animal
//        txtDataNascimento.setText(this.objAnimal.getDataNascimento().toString());
        txtDataNascimento.setText("");
        //Carrega na tela o número do botton do animal
        txtNumBotton.setText(this.objAnimal.getNumeroBotton().toString());
        //Carrega na tela o número do registro do animal
        txtTipoRegistro.setText(this.objAnimal.getTipoRegistro().toString());
        //Carrega na tela o registro do pai do animal
//        txtCodPai.setText("");
////        txtCodPai.setText(this.objAnimal.getAnimalByIdPai().toString());
//        //Carrega na tela o registro da mãe do animal
//        txtCodMae.setText(this.objAnimal.getAnimalByIdMae().toString());
        //Carrega na tela o código da propriedade rural do animal
        txtIdPropRural.setText(this.objAnimal.getPropriedadeRural().getId().toString());
        txtDescPropRural.setText(this.objAnimal.getPropriedadeRural().getDescricao());

//         txtMae.setText(this.objAnimal.getAnimalByIdMae().toString());
        //Adiciona o status de edição
        this.edicao = true;
        //MOstra o botão excluir
        btnExcluir.setEnabled(true);
        //Seta o focu no campo de descrição ao abrir o formulário
        txtNome.requestFocus();
    }
    
    public void fPesquisaRaca()
    {
        if (frmPesqRaca == null) {
            frmPesqRaca = new FrmPesquisarRaca();
            frmPesqRaca.setModal(true);
        }
        
        if (frmPesqRaca.isVisible()) {
            frmPesqRaca.setVisible(false);
        } else {
            frmPesqRaca.setLocationRelativeTo(null);
            frmPesqRaca.setVisible(true);
        }
        
    }
    
    public void fPesquisaCategoria()
    {
        if (frmPesqCategoria == null) {
            frmPesqCategoria = new FrmPesquisarCategoria();
            frmPesqCategoria.setModal(true);
        }
        
        if (frmPesqCategoria.isVisible()) {
            frmPesqCategoria.setVisible(false);
        } else {
            frmPesqCategoria.setLocationRelativeTo(null);
            frmPesqCategoria.setVisible(true);
        }
    }
    
    public void fPesquisaGrauSangue()
    {
        if (frmPesqGrauSangue == null) {
            frmPesqGrauSangue= new FrmPesquisarGrauSangue();
            frmPesqGrauSangue.setModal(true);
        }
        
        if (frmPesqGrauSangue.isVisible()) {
            frmPesqGrauSangue.setVisible(false);
        } else {
            frmPesqGrauSangue.setLocationRelativeTo(null);
            frmPesqGrauSangue.setVisible(true);
        }
        
    }
    
     public void fPesquisaPropriedadeRural()
    {
        if (frmPesqPropriedadeRural == null) {
            frmPesqPropriedadeRural= new FrmPesquisarPropriedadeRural();
            frmPesqPropriedadeRural.setModal(true);
        }
        
        if (frmPesqPropriedadeRural.isVisible()) {
            frmPesqPropriedadeRural.setVisible(false);
        } else {
            frmPesqPropriedadeRural.setLocationRelativeTo(null);
            frmPesqPropriedadeRural.setVisible(true);
        }
        
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

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtDescRaca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumBotton = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescCategoria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSexo = new javax.swing.JTextField();
        txtDescGrauSangue = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDataNascimento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTipoRegistro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtIdPropRural = new javax.swing.JTextField();
        txtIdGrauSangue = new javax.swing.JTextField();
        txtIdRaca = new javax.swing.JTextField();
        btnPesqRaca = new javax.swing.JButton();
        txtIdCategoria = new javax.swing.JTextField();
        btnPesqCategoria = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnPesqGrauSangue = new javax.swing.JButton();
        txtDescPropRural = new javax.swing.JTextField();
        btnPesqPropRural = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setTitle("Cadastro de Animais");
        setName(""); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome:");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        txtNome.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtNomeActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnExcluirActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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
        jLabel2.setText("Raça:");

        txtDescRaca.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtDescRacaActionPerformed(evt);
            }
        });

        jLabel3.setText("Categoria:");

        txtNumBotton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtNumBottonActionPerformed(evt);
            }
        });

        jLabel4.setText("Nº Botton:");

        jLabel5.setText("Sexo:");

        jLabel6.setText("Grau de Sangue:");

        jLabel7.setText("Data de Nascimento:");

        jLabel8.setText("Tipo de Registro:");

        txtTipoRegistro.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtTipoRegistroActionPerformed(evt);
            }
        });

        jLabel11.setText("Propriedade Rural:");

        txtIdPropRural.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtIdPropRuralActionPerformed(evt);
            }
        });

        txtIdRaca.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtIdRacaActionPerformed(evt);
            }
        });
        txtIdRaca.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                txtIdRacaKeyPressed(evt);
            }
        });

        btnPesqRaca.setText("...");
        btnPesqRaca.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPesqRacaActionPerformed(evt);
            }
        });

        txtIdCategoria.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtIdCategoriaActionPerformed(evt);
            }
        });
        txtIdCategoria.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                txtIdCategoriaKeyPressed(evt);
            }
        });

        btnPesqCategoria.setText("...");
        btnPesqCategoria.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPesqCategoriaActionPerformed(evt);
            }
        });

        jLabel12.setText("M - Masculino                          F - Feminino");

        btnPesqGrauSangue.setText("...");
        btnPesqGrauSangue.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPesqGrauSangueActionPerformed(evt);
            }
        });

        btnPesqPropRural.setText("...");
        btnPesqPropRural.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPesqPropRuralActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumBotton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtIdRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtDescRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtDescCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txtIdGrauSangue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtDescGrauSangue)))
                            .addGap(4, 4, 4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnPesqRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPesqCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPesqGrauSangue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdPropRural, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txtDescPropRural, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesqPropRural, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescRaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesqRaca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtIdCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesqCategoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescGrauSangue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdGrauSangue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesqGrauSangue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNumBotton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTipoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdPropRural, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDescPropRural, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesqPropRural))))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        //Adiciona os atributos
        objAnimal.setNome(txtNome.getText());
        Raca r = new Raca();
        r.setId(Integer.parseInt(txtIdRaca.getText()));
        objAnimal.setRaca(r);
        Categoria c = new Categoria();
        c.setId(Integer.parseInt(txtIdCategoria.getText()));
        objAnimal.setCategoria(c);
        objAnimal.setSexo(txtSexo.getText().charAt(0));
        GrauSangue gs = new GrauSangue();
        gs.setId(Integer.parseInt(txtIdGrauSangue.getText()));
        objAnimal.setGrauSangue(gs);
        try {
            String dataString = formatacao.ajustaDataAMD(txtDataNascimento.getText());
            Date data = new Date();
            data = formatacao.formataData(dataString);
            objAnimal.setDataNascimento(data);
        } catch (Exception ex) {
            Logger.getLogger(FrmAnimalCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        objAnimal.setNumeroBotton(Integer.parseInt(txtNumBotton.getText()));
        objAnimal.setTipoRegistro(Integer.parseInt(txtTipoRegistro.getText()));
        objAnimal.setAnimalByIdPai(null);
        objAnimal.setAnimalByIdMae(null);
        PropriedadeRural pr = new PropriedadeRural();
        pr.setId(Integer.parseInt(txtIdPropRural.getText()));
        objAnimal.setPropriedadeRural(pr);
        try {
//            int aux = Integer.parseInt(txtDiasValidade.getText());
//            objAnimal.setDiasValidade(aux);
//            //Verifica se deve adicionar ou atualizar um registro
            if (this.edicao) {
                //Chama o méotod INSERT do conttroler
                if (objController.update(objAnimal)) {
                    //Limpa os campos
                    limparCampos();
                    //Fecha o formulário
                    this.setVisible(false);
                }
            } else {
                //Chama o méotod INSERT do conttroler
                if (objController.insert(objAnimal)) {
                    //Limpa os campos
                    limparCampos();
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
        objController.delete(objAnimal);

        //Limpa os campos
        limparCampos();

        //Fecha o formulário
        this.setVisible(false);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtDescRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescRacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescRacaActionPerformed

    private void txtNumBottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumBottonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumBottonActionPerformed

    private void txtTipoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoRegistroActionPerformed

    private void txtIdPropRuralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPropRuralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPropRuralActionPerformed

    private void txtIdRacaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtIdRacaActionPerformed
    {//GEN-HEADEREND:event_txtIdRacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdRacaActionPerformed

    private void txtIdRacaKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtIdRacaKeyPressed
    {//GEN-HEADEREND:event_txtIdRacaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdRacaKeyPressed

    private void btnPesqRacaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPesqRacaActionPerformed
    {//GEN-HEADEREND:event_btnPesqRacaActionPerformed
        fPesquisaRaca();
        this.txtIdRaca.setText(String.valueOf(this.frmPesqRaca.getId()));
        this.txtDescRaca.setText(String.valueOf(this.frmPesqRaca.getNome()));
    }//GEN-LAST:event_btnPesqRacaActionPerformed

    private void txtIdCategoriaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_txtIdCategoriaActionPerformed
    {//GEN-HEADEREND:event_txtIdCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCategoriaActionPerformed

    private void txtIdCategoriaKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_txtIdCategoriaKeyPressed
    {//GEN-HEADEREND:event_txtIdCategoriaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCategoriaKeyPressed

    private void btnPesqCategoriaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPesqCategoriaActionPerformed
    {//GEN-HEADEREND:event_btnPesqCategoriaActionPerformed
        fPesquisaCategoria();
        this.txtIdCategoria.setText(String.valueOf(this.frmPesqCategoria.getId()));
        this.txtDescCategoria.setText(String.valueOf(this.frmPesqCategoria.getNome()));
    }//GEN-LAST:event_btnPesqCategoriaActionPerformed

    private void btnPesqGrauSangueActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPesqGrauSangueActionPerformed
    {//GEN-HEADEREND:event_btnPesqGrauSangueActionPerformed
        fPesquisaGrauSangue();
        this.txtIdGrauSangue.setText(String.valueOf(this.frmPesqGrauSangue.getId()));
        this.txtDescGrauSangue.setText(String.valueOf(this.frmPesqGrauSangue.getNome()));
    }//GEN-LAST:event_btnPesqGrauSangueActionPerformed

    private void btnPesqPropRuralActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPesqPropRuralActionPerformed
    {//GEN-HEADEREND:event_btnPesqPropRuralActionPerformed
        fPesquisaPropriedadeRural();
        this.txtIdPropRural.setText(String.valueOf(this.frmPesqPropriedadeRural.getId()));
        this.txtDescPropRural.setText(String.valueOf(this.frmPesqPropriedadeRural.getNome()));
    }//GEN-LAST:event_btnPesqPropRuralActionPerformed
    
    public void limparCampos()
    {
//        txtIdAnimal.setText("");
        txtNome.setText("");
        txtIdRaca.setText("");
        txtDescRaca.setText("");
        txtIdCategoria.setText("");
        txtDescCategoria.setText("");
        txtSexo.setText("");
        txtIdGrauSangue.setText("");
        txtDescGrauSangue.setText("");
        txtDataNascimento.setText("");
        txtNumBotton.setText("");
        txtTipoRegistro.setText("");
//        txtIdPai.setText("");
//        txtDescPai.setText("");
//        txtIdMae.setText("");
//        txtDescMae.setText("");
        txtIdPropRural.setText("");
        txtDescPropRural.setText("");
    }
    
    public void desabilitarEdicao()
    {
        //Desabilita a edição do componente

        txtIdRaca.setEnabled(false);
        txtIdCategoria.setEnabled(false);
        txtIdGrauSangue.setEnabled(false);
//        txtIdPai.setEnabled(false);
//        txtIdMae.setEnabled(false);
        txtIdPropRural.setEnabled(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnPesqCategoria;
    private javax.swing.JButton btnPesqGrauSangue;
    private javax.swing.JButton btnPesqPropRural;
    private javax.swing.JButton btnPesqRaca;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtDescCategoria;
    private javax.swing.JTextField txtDescGrauSangue;
    private javax.swing.JTextField txtDescPropRural;
    private javax.swing.JTextField txtDescRaca;
    private javax.swing.JTextField txtIdCategoria;
    private javax.swing.JTextField txtIdGrauSangue;
    private javax.swing.JTextField txtIdPropRural;
    private javax.swing.JTextField txtIdRaca;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumBotton;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtTipoRegistro;
    // End of variables declaration//GEN-END:variables
}
