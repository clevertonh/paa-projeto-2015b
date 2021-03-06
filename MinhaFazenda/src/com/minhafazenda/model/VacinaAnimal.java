package com.minhafazenda.model;
// Generated 13/12/2015 15:29:49 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * VacinaAnimal generated by hbm2java
 */
public class VacinaAnimal  implements java.io.Serializable {


     private VacinaAnimalId id;
     private Animal animal;
     private Usuario usuario;
     private Vacina vacina;
     private Date dataAplicacao;
     private Date dataVencimento;
     private Integer dose;
     private Integer idUsuarioAlterou;

    public VacinaAnimal() {
    }

	
    public VacinaAnimal(VacinaAnimalId id, Animal animal, Usuario usuario, Vacina vacina) {
        this.id = id;
        this.animal = animal;
        this.usuario = usuario;
        this.vacina = vacina;
    }
    public VacinaAnimal(VacinaAnimalId id, Animal animal, Usuario usuario, Vacina vacina, Date dataAplicacao, Date dataVencimento, Integer dose, Integer idUsuarioAlterou) {
       this.id = id;
       this.animal = animal;
       this.usuario = usuario;
       this.vacina = vacina;
       this.dataAplicacao = dataAplicacao;
       this.dataVencimento = dataVencimento;
       this.dose = dose;
       this.idUsuarioAlterou = idUsuarioAlterou;
    }
   
    public VacinaAnimalId getId() {
        return this.id;
    }
    
    public void setId(VacinaAnimalId id) {
        this.id = id;
    }
    public Animal getAnimal() {
        return this.animal;
    }
    
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Vacina getVacina() {
        return this.vacina;
    }
    
    public void setVacina(Vacina vacina) {
        this.vacina = vacina;
    }
    public Date getDataAplicacao() {
        return this.dataAplicacao;
    }
    
    public void setDataAplicacao(Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }
    public Date getDataVencimento() {
        return this.dataVencimento;
    }
    
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    public Integer getDose() {
        return this.dose;
    }
    
    public void setDose(Integer dose) {
        this.dose = dose;
    }
    public Integer getIdUsuarioAlterou() {
        return this.idUsuarioAlterou;
    }
    
    public void setIdUsuarioAlterou(Integer idUsuarioAlterou) {
        this.idUsuarioAlterou = idUsuarioAlterou;
    }




}


