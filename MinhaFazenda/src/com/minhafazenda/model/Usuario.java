package com.minhafazenda.model;
// Generated 18/08/2015 19:49:12 by Hibernate Tools 4.3.1

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "fazenda"
)
public class Usuario implements java.io.Serializable {
    @Transient 
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

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

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_tipo", nullable = false)
    public UsuarioTipo getUsuarioTipo() {
        return this.usuarioTipo;
    }

    public void setUsuarioTipo(UsuarioTipo usuarioTipo) {
        UsuarioTipo oldUsuarioTipo = this.usuarioTipo;
        this.usuarioTipo = usuarioTipo;
        changeSupport.firePropertyChange("usuarioTipo", oldUsuarioTipo, usuarioTipo);
    }

    @Column(name = "usuario", length = 45)
    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        String oldUsuario = this.usuario;
        this.usuario = usuario;
        changeSupport.firePropertyChange("usuario", oldUsuario, usuario);
    }

    @Column(name = "senha", length = 45)
    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        String oldSenha = this.senha;
        this.senha = senha;
        changeSupport.firePropertyChange("senha", oldSenha, senha);
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set getVacinaAnimals() {
        return this.vacinaAnimals;
    }

    public void setVacinaAnimals(Set vacinaAnimals) {
        this.vacinaAnimals = vacinaAnimals;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_propriedade_rural", catalog = "fazenda", joinColumns = {
        @JoinColumn(name = "id_usuario", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_propriedade_rural", nullable = false, updatable = false)})
    public Set getPropriedadeRurals() {
        return this.propriedadeRurals;
    }

    public void setPropriedadeRurals(Set propriedadeRurals) {
        this.propriedadeRurals = propriedadeRurals;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
