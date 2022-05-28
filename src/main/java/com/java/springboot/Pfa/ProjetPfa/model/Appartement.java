package com.java.springboot.Pfa.ProjetPfa.model;

import java.io.Serializable;
import java.util.Collection;


import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



/**
 *
 
 */
@Entity
@Table(name = "appartement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appartement.findAll", query = "SELECT a FROM Appartement a"),
    @NamedQuery(name = "Appartement.findByIdAppartement", query = "SELECT a FROM Appartement a WHERE a.idAppartement = :idAppartement"),
    @NamedQuery(name = "Appartement.findByNumero", query = "SELECT a FROM Appartement a WHERE a.numero = :numero"),
    @NamedQuery(name = "Appartement.findByEtage", query = "SELECT a FROM Appartement a WHERE a.etage = :etage"),
    @NamedQuery(name = "Appartement.findBySurface", query = "SELECT a FROM Appartement a WHERE a.surface = :surface")})
public class Appartement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAppartement")
    private Integer idAppartement;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etage")
    private int etage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "surface")
    private int surface;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appartement")
    private Collection<ResidantAppartement> residantappartementCollection;
    
    @JoinColumn(name="idImmeuble",referencedColumnName="idImmeuble" )
    @ManyToOne
	private Immeuble immeuble;
    
    public Appartement() {
    }

    public Appartement(Integer idAppartement) {
        this.idAppartement = idAppartement;
    }

    public Appartement(Integer idAppartement, int numero, int etage, int surface, Immeuble immeuble) {
        this.idAppartement = idAppartement;
        this.numero = numero;
        this.etage = etage;
        this.surface = surface;
        this.immeuble = immeuble;
    }

    public Integer getIdAppartement() {
        return idAppartement;
    }

    public void setIdAppartement(Integer idAppartement) {
        this.idAppartement = idAppartement;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getEtage() {
        return etage;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }
    
    

    public Immeuble getImmeuble() {
		return immeuble;
	}

	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}

	@XmlTransient
    public Collection<ResidantAppartement> getResidantappartementCollection() {
        return residantappartementCollection;
    }

    public void setResidantappartementCollection(Collection<ResidantAppartement> residantappartementCollection) {
        this.residantappartementCollection = residantappartementCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAppartement != null ? idAppartement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appartement)) {
            return false;
        }
        Appartement other = (Appartement) object;
        if ((this.idAppartement == null && other.idAppartement != null) || (this.idAppartement != null && !this.idAppartement.equals(other.idAppartement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.springboot.Pfa.ProjetPfa.model.Appartement[ idAppartement=" + idAppartement + " ]";
    }
    
}


