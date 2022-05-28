package com.java.springboot.Pfa.ProjetPfa.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "residantAppartement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResidantAppartement.findAll", query = "SELECT r FROM ResidantAppartement r"),
    @NamedQuery(name = "ResidantAppartement.findByIdResidant", query = "SELECT r FROM ResidantAppartement r WHERE r.residantappartementPK.idResidant = :idResidant"),
    @NamedQuery(name = "ResidantAppartement.findByIdAppartement", query = "SELECT r FROM ResidantAppartement r WHERE r.residantappartementPK.idAppartement = :idAppartement"),
    @NamedQuery(name = "ResidantAppartement.findByDateDebut", query = "SELECT r FROM ResidantAppartement r WHERE r.dateDebut = :dateDebut"),
    @NamedQuery(name = "ResidantAppartement.findByDateFin", query = "SELECT r FROM ResidantAppartement r WHERE r.dateFin = :dateFin")})
public class ResidantAppartement implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResidantappartementPK residantappartementPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateDebut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @JoinColumn(name = "idResidant", referencedColumnName = "idResidant", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Residant residant;
    @JoinColumn(name = "idAppartement", referencedColumnName = "idAppartement", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Appartement appartement;

    public ResidantAppartement() {
    }

    public ResidantAppartement(ResidantappartementPK residantappartementPK) {
        this.residantappartementPK = residantappartementPK;
    }

    public ResidantAppartement(ResidantappartementPK residantappartementPK, Date dateDebut, Date dateFin) {
        this.residantappartementPK = residantappartementPK;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public ResidantAppartement(int idResidant, int idAppartement) {
        this.residantappartementPK = new ResidantappartementPK(idResidant, idAppartement);
    }

    public ResidantappartementPK getResidantappartementPK() {
        return residantappartementPK;
    }

    public void setResidantappartementPK(ResidantappartementPK residantappartementPK) {
        this.residantappartementPK = residantappartementPK;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Residant getResidant() {
        return residant;
    }

    public void setResidant(Residant residant) {
        this.residant = residant;
    }

    public Appartement getAppartement() {
        return appartement;
    }

    public void setAppartement(Appartement appartement) {
        this.appartement = appartement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (residantappartementPK != null ? residantappartementPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResidantAppartement)) {
            return false;
        }
        ResidantAppartement other = (ResidantAppartement) object;
        if ((this.residantappartementPK == null && other.residantappartementPK != null) || (this.residantappartementPK != null && !this.residantappartementPK.equals(other.residantappartementPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.springboot.Pfa.ProjetPfa.model.Residantappartement[ residantappartementPK=" + residantappartementPK + " ]";
    }
    
}

