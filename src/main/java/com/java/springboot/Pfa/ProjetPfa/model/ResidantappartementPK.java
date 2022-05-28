package com.java.springboot.Pfa.ProjetPfa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class ResidantappartementPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idResidant")
    private int idResidant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAppartement")
    private int idAppartement;

    public ResidantappartementPK() {
    }

    public ResidantappartementPK(int idResidant, int idAppartement) {
        this.idResidant = idResidant;
        this.idAppartement = idAppartement;
    }

    public int getIdResidant() {
        return idResidant;
    }

    public void setIdResidant(int idResidant) {
        this.idResidant = idResidant;
    }

    public int getIdAppartement() {
        return idAppartement;
    }

    public void setIdAppartement(int idAppartement) {
        this.idAppartement = idAppartement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idResidant;
        hash += (int) idAppartement;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResidantappartementPK)) {
            return false;
        }
        ResidantappartementPK other = (ResidantappartementPK) object;
        if (this.idResidant != other.idResidant) {
            return false;
        }
        if (this.idAppartement != other.idAppartement) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.springboot.Pfa.ProjetPfa.model.ResidantappartementPK[ idResidant=" + idResidant + ", idAppartement=" + idAppartement + " ]";
    }
    
}

