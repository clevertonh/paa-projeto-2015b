/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minhafazenda.model;

import com.minhafazenda.util.MinhaFazendaHibernateUtil;
import java.util.ArrayList;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author cleverton
 */
public class RacaModel {

    //

    private final SessionFactory objSessionFactory;
    //String para mensagem de erro
    String msg = "";

    public RacaModel() {
        //Recebe o Session Factory do HIbernate
        this.objSessionFactory = MinhaFazendaHibernateUtil.getSessionFactory();
    }

    public String insert(Raca obj) {
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();
        //Inicia uma transação dentro da sessão aberta
        Transaction objTransaction = objSession.beginTransaction();

        try {
            //ADICIONA o objeto categoria, assim o hibernate persiste no bancoapagando o registro.
            objSession.save(obj);
            //Realiza um commit do INSERT
            objTransaction.commit();
        } catch (Exception e) {
            //Caso ocorrer algum erro, mostra uma mensagem
            this.msg = e.getMessage();
            //Realiza o Rollback, cancelando o INSERT no banco de dados.
            objTransaction.rollback();
        }

        //Fecha a sessão
        objSession.close();
        //Retorna a mensagem
        return this.msg;
    }

    public String update(Raca obj) {
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();
        //Inicia uma transação dentro da sessão aberta
        Transaction objTransaction = objSession.beginTransaction();

        try {
            //ATUALIZA o objeto categoria, assim o hibernate persiste no bancoapagando o registro.
            objSession.merge(obj);
            //Realiza um commit do UPDATE
            objTransaction.commit();
        } catch (Exception e) {
            //Caso ocorrer algum erro, mostra uma mensagem
            msg = e.getMessage();
            //Realiza o Rollback, cancelando o UPDATE no banco de dados.
            objTransaction.rollback();
        }

        //Fecha a sessão
        objSession.close();
        //Retorna a mensagem
        return msg;
    }

    public String delete(Raca obj) {
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();
        //Inicia uma transação dentro da sessão aberta
        Transaction objTransaction = objSession.beginTransaction();

        try {
            //Cria QUERY para excluir o registro
            Query query = objSession.createQuery("delete Raca where id = :id");
            //Seta os parâmetros
            query.setParameter("id", obj.getId());
            //Executa a QUERY
            query.executeUpdate();
                //ATUALIZA o objeto categoria, assim o hibernate persiste no bancoapagando o registro.
            //objSession.delete(obj);
            //Realiza um commit do UPDATE
            objTransaction.commit();
        } catch (Exception e) {
            //Caso ocorrer algum erro, mostra uma mensagem
            msg = e.getMessage();
            //Realiza o Rollback, cancelando o UPDATE no banco de dados.
            objTransaction.rollback();
        }

        //Fecha a sessão
        objSession.close();
        //Retorna a mensagem
        return msg;
    }

    public ArrayList<Raca> findByAll() {
        //Cria lista de objetos
        ArrayList<Raca> lstRaca = null;
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();

        try {
            Query objQuery = objSession.createQuery("from Raca");
            lstRaca = (ArrayList<Raca>) objQuery.list();
        } catch (ObjectNotFoundException e) {
            return null;
        }

        //Fecha a sessão
        objSession.close();
        //Retorna lista de categoria
        return lstRaca;
    }

    public Raca findById(int id) {
        //Cria lista de objetos
        Raca objRaca = null;
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();

        try {
            objRaca = (Raca) objSession.load(Raca.class, id);
        } catch (ObjectNotFoundException e) {
            return null;
        }
        //Fecha a sessão
        //objSession.close();
        //Retorna objeto categoria
        return objRaca;
    }

    public ArrayList<Raca> findByAll(String condicao) {
        //Cria lista de objetos
        ArrayList<Raca> lstRaca = null;
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();

        try {
            Query objQuery = objSession.createQuery("from Raca where descricao like '%" + condicao + "%'");
            lstRaca = (ArrayList<Raca>) objQuery.list();
        } catch (ObjectNotFoundException e) {
            return null;
        }

        //Fecha a sessão
        objSession.close();
        //Retorna lista
        return lstRaca;
    }
    /**
     *
     */
//    public class CategoriaTableModel extends AbstractTableModel{     
//
//        private ArrayList linhas = null;  
//        private String [] colunas = null;  
//    
//        public CategoriaTableModel(ArrayList dados, String[] colunas){  
//            setLinhas(dados);  
//            setColunas(colunas);     
//        }
//        
//        public ArrayList getLinhas() {
//            return linhas;
//        }
//
//        public void setLinhas(ArrayList linhas) {
//            this.linhas = linhas;
//        }
//
//        public String[] getColunas() {
//            return colunas;
//        }
//
//        public void setColunas(String[] colunas) {
//            this.colunas = colunas;
//        }        
//        
//        @Override
//        public int getRowCount() {
//            return getLinhas().size();  
//        }
//
//        @Override
//        public int getColumnCount() {
//            return getColunas().length;  
//        }
//
//        @Override
//        public Object getValueAt(int rowIndex, int columnIndex){
//
//            Object value = null;  
//            final Categoria c = (Categoria)linhas.get(rowIndex);  
//
//            switch(columnIndex){  
//            case 0:   
//                value = c.getId();
//                break;  
//            case 1:  
//                value = c.getDescricao();  
//                break; 
//            }
//            return value;  
//
//        }
//
//        public String getColumnName(int col) {  
//            return colunas[col];  
//        }
//
//    }

}
