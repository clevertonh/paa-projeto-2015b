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
public class CategoriaModel {
    //
    private final SessionFactory objSessionFactory;
    
    //String para mensagem de erro
    String msg = "";
    
    public CategoriaModel(){    
        //Recebe o Session Factory do HIbernate
        this.objSessionFactory = MinhaFazendaHibernateUtil.getSessionFactory(); 
    }
    
    public String insert(Categoria obj) {
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
    
    public String update(Categoria obj) {
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
    
    public String delete(Categoria obj) {        
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();    
        //Inicia uma transação dentro da sessão aberta
        Transaction objTransaction = objSession.beginTransaction();
        
        try {    
            //Cria QUERY para excluir o registro
            Query query = objSession.createQuery("delete Categoria where id = :id");
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

    public ArrayList<Categoria> findByAll() {  
        //Cria lista de objetos
        ArrayList<Categoria> lstCategoria = null;  
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            Query objQuery = objSession.createQuery("from Categoria");
            lstCategoria = (ArrayList<Categoria>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        //Fecha a sessão
        objSession.close();
        //Retorna lista de categoria
        return lstCategoria;  
    }
    
    public Categoria findById(int id) {  
        //Cria lista de objetos
        Categoria objCategoria = null;  
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            objCategoria = (Categoria)objSession.load(Categoria.class, id);
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        //Fecha a sessão
        //objSession.close();
        //Retorna objeto categoria
        return objCategoria;
    }    
    
    public ArrayList<Categoria> findByDescricao(String descricao) {  
        //Cria lista de objetos
        ArrayList<Categoria> lstCategoria = null;  
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();    

        try {  
            Query objQuery = objSession.createQuery("from Categoria where descricao like '%" + descricao + "%'");
            lstCategoria = (ArrayList<Categoria>)objQuery.list();  
        } catch (ObjectNotFoundException e) {  
            return null;  
        }  
        
        //Fecha a sessão
        objSession.close();
        //Retorna lista de categoria
  
        return lstCategoria;  
    } 
}