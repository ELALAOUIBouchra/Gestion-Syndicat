package com.java.springboot.Pfa.ProjetPfa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "depense")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Depense.findAll", query = "SELECT d FROM Depense d"),
    @NamedQuery(name = "Depense.findByIdDepense", query = "SELECT d FROM Depense d WHERE d.idDepense = :idDepense"),
    @NamedQuery(name = "Depense.findByDescription", query = "SELECT d FROM Depense d WHERE d.description = :description"),
    @NamedQuery(name = "Depense.findByMontant", query = "SELECT d FROM Depense d WHERE d.montant = :montant"),
    @NamedQuery(name = "Depense.findByDateDepense", query = "SELECT d FROM Depense d WHERE d.dateDepense = :dateDepense")})
public class Depense implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDepense")
    private Integer idDepense;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "montant")
    private int montant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateDepense")
    @Temporal(TemporalType.DATE)
    private Date dateDepense;
    @JoinColumn(name = "idImmeuble", referencedColumnName = "idImmeuble")
    @ManyToOne
    private Immeuble immeuble;
    @JoinColumn(name = "idCategorie", referencedColumnName = "idCategorie")
    @ManyToOne
    private Categorie categorie;

    public Depense() {
    }

    public Depense(Integer idDepense) {
        this.idDepense = idDepense;
    }

    public Depense(Integer idDepense, String description, int montant, Date dateDepense,Immeuble immeuble,Categorie categorie) {
        this.idDepense = idDepense;
        this.description = description;
        this.montant = montant;
        this.dateDepense = dateDepense;
        this.immeuble = immeuble;
        this.categorie = categorie;
    }

    
    
    
    public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	

	public Immeuble getImmeuble() {
		return immeuble;
	}

	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}

	public Integer getIdDepense() {
        return idDepense;
    }

    public void setIdDepense(Integer idDepense) {
        this.idDepense = idDepense;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Date getDateDepense() {
        return dateDepense;
    }

    public void setDateDepense(Date dateDepense) {
        this.dateDepense = dateDepense;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepense != null ? idDepense.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Depense)) {
            return false;
        }
        Depense other = (Depense) object;
        if ((this.idDepense == null && other.idDepense != null) || (this.idDepense != null && !this.idDepense.equals(other.idDepense))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.springboot.Pfa.ProjetPfa.model.Depense[ idDepense=" + idDepense + " ]";
    }
    
}
