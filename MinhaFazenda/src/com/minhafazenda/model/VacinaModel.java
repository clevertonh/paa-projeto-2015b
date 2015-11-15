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
public class VacinaModel {

    //
    private final SessionFactory objSessionFactory;

    //String para mensagem de erro
    String msg = "";

    public VacinaModel() {
        //Recebe o Session Factory do HIbernate
        this.objSessionFactory = MinhaFazendaHibernateUtil.getSessionFactory();
    }

    public String insert(Vacina obj) {
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();
        //Inicia uma transação dentro da sessão aberta
        Transaction objTransaction = objSession.beginTransaction();

        try {
            //ADICIONA o objeto, assim o hibernate persiste no bancoapagando o registro.
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

    public String update(Vacina obj) {
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();
        //Inicia uma transação dentro da sessão aberta
        Transaction objTransaction = objSession.beginTransaction();

        try {
            //ATUALIZA o objeto, assim o hibernate persiste no bancoapagando o registro.
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

    public String delete(Vacina obj) {
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();
        //Inicia uma transação dentro da sessão aberta
        Transaction objTransaction = objSession.beginTransaction();

        try {
            //Cria QUERY para excluir o registro
            Query query = objSession.createQuery("delete Vacina where id = :id");
            //Seta os parâmetros
            query.setParameter("id", obj.getId());
            //Executa a QUERY
            query.executeUpdate();
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

    public ArrayList<Vacina> findByAll() {
        //Cria lista de objetos
        ArrayList<Vacina> lstUsuario = null;
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();

        try {
            Query objQuery = objSession.createQuery("from Vacina");
            lstUsuario = (ArrayList<Vacina>) objQuery.list();
        } catch (ObjectNotFoundException e) {
            return null;
        }
        //Fecha a sessão
        objSession.close();
        //Retorna lista
        return lstUsuario;
    }

    public Vacina findById(int id) {
        //Cria lista de objetos
        Vacina objUsuario = null;
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();

        try {
            objUsuario = (Vacina) objSession.load(Vacina.class, id);
        } catch (ObjectNotFoundException e) {
            return null;
        }
        //Retorna objeto Usuario
        return objUsuario;
    }

    public ArrayList<Vacina> findByDescricao(String descricao) {
        //Cria lista de objetos
        ArrayList<Vacina> lstUsuario = null;
        //Abre um sessão
        Session objSession = this.objSessionFactory.openSession();

        try {
            Query objQuery = objSession.createQuery("from Vacina where descricao like '%" + descricao + "%'");
            lstUsuario = (ArrayList<Vacina>) objQuery.list();
        } catch (ObjectNotFoundException e) {
            return null;
        }
        //Fecha a sessão
        objSession.close();
        //Retorna lista de Usuarios
        return lstUsuario;
    }

}
