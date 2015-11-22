package com.minhafazenda.model;
// Generated 22/11/2015 11:05:37 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * UsuarioTipo generated by hbm2java
 */
public class UsuarioTipo  implements java.io.Serializable {


     private Integer id;
     private String descricao;
     private Integer idUsuarioAlterou;
     private Set usuarios = new HashSet(0);

    public UsuarioTipo() {
    }

    public UsuarioTipo(String descricao, Integer idUsuarioAlterou, Set usuarios) {
       this.descricao = descricao;
       this.idUsuarioAlterou = idUsuarioAlterou;
       this.usuarios = usuarios;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Integer getIdUsuarioAlterou() {
        return this.idUsuarioAlterou;
    }
    
    public void setIdUsuarioAlterou(Integer idUsuarioAlterou) {
        this.idUsuarioAlterou = idUsuarioAlterou;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}


