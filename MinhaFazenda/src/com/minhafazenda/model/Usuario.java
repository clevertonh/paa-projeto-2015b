package com.minhafazenda.model;
// Generated 13/08/2015 12:46:09 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private Integer id;
     private UsuarioTipo usuarioTipo;
     private String usuario;
     private String senha;
     private Set vacinaAnimals = new HashSet(0);
     private Set propriedadeRurals = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(UsuarioTipo usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }
    public Usuario(UsuarioTipo usuarioTipo, String usuario, String senha, Set vacinaAnimals, Set propriedadeRurals) {
       this.usuarioTipo = usuarioTipo;
       this.usuario = usuario;
       this.senha = senha;
       this.vacinaAnimals = vacinaAnimals;
       this.propriedadeRurals = propriedadeRurals;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public UsuarioTipo getUsuarioTipo() {
        return this.usuarioTipo;
    }
    
    public void setUsuarioTipo(UsuarioTipo usuarioTipo) {
        this.usuarioTipo = usuarioTipo;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Set getVacinaAnimals() {
        return this.vacinaAnimals;
    }
    
    public void setVacinaAnimals(Set vacinaAnimals) {
        this.vacinaAnimals = vacinaAnimals;
    }
    public Set getPropriedadeRurals() {
        return this.propriedadeRurals;
    }
    
    public void setPropriedadeRurals(Set propriedadeRurals) {
        this.propriedadeRurals = propriedadeRurals;
    }




}

