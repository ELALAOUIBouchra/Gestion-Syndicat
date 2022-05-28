package com.java.springboot.Pfa.ProjetPfa.model;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "syndic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Syndic.findAll", query = "SELECT s FROM Syndic s"),
    @NamedQuery(name = "Syndic.findByIdSyndic", query = "SELECT s FROM Syndic s WHERE s.idSyndic = :idSyndic")
   })
public class Syndic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idSyndic")
    private Integer idSyndic;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "syndic")
    private SyndicImmeuble syndicimmeuble;
    @JoinColumn(name = "idSyndic", referencedColumnName = "idPersonne", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Personne personne;
  
    public Syndic() {
    }

    public Syndic(Integer idSyndic) {
        this.idSyndic = idSyndic;
    }

    public Integer getIdSyndic() {
        return idSyndic;
    }

    public void setIdSyndic(Integer idSyndic) {
        this.idSyndic = idSyndic;
    }

   

    public SyndicImmeuble getSyndicimmeuble() {
        return syndicimmeuble;
    }

    public void setSyndicimmeuble(SyndicImmeuble syndicimmeuble) {
        this.syndicimmeuble = syndicimmeuble;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSyndic != null ? idSyndic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Syndic)) {
            return false;
        }
        Syndic other = (Syndic) object;
        if ((this.idSyndic == null && other.idSyndic != null) || (this.idSyndic != null && !this.idSyndic.equals(other.idSyndic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.springboot.Pfa.ProjetPfa.model.Syndic[ idSyndic=" + idSyndic + " ]";
    }
    
}

	
	

	