package com.minhafazenda.model;
// Generated 18/08/2015 19:49:12 by Hibernate Tools 4.3.1

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * UsuarioTipo generated by hbm2java
 */
@Entity
@Table(name = "usuario_tipo", catalog = "fazenda"
)
public class UsuarioTipo implements java.io.Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private int id;
    private String descricao;
    private Set usuarios = new HashSet(0);
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioTipo")
    private Collection<Usuario> usuarioCollection;

    public UsuarioTipo() {
    }

    public UsuarioTipo(int id) {
        this.id = id;
    }

    public UsuarioTipo(int id, String descricao, Set usuarios) {
        this.id = id;
        this.descricao = descricao;
        this.usuarios = usuarios;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = IDENTITY)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        int oldId = this.id;

        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);

    }

    @Column(name = "descricao", length = 45)
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;

        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);

    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioTipo")
    public Set getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        Collection<Usuario> oldUsuarioCollection = this.usuarioCollection;
        this.usuarioCollection = usuarioCollection;
        changeSupport.firePropertyChange("usuarioCollection", oldUsuarioCollection, usuarioCollection);
    }

}
