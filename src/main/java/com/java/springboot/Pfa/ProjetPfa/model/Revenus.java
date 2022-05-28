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
@Table(name = "revenus")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revenus.findAll", query = "SELECT r FROM Revenus r"),
    @NamedQuery(name = "Revenus.findByIdRevenu", query = "SELECT r FROM Revenus r WHERE r.idRevenu = :idRevenu"),
    @NamedQuery(name = "Revenus.findBySomme", query = "SELECT r FROM Revenus r WHERE r.somme = :somme"),
    @NamedQuery(name = "Revenus.findByDateRevenu", query = "SELECT r FROM Revenus r WHERE r.dateRevenu = :dateRevenu"),
    @NamedQuery(name = "Revenus.findByCommentaire", query = "SELECT r FROM Revenus r WHERE r.commentaire = :commentaire")})
public class Revenus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRevenu")
    private Integer idRevenu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "somme")
    private int somme;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateRevenu")
    @Temporal(TemporalType.DATE)
    private Date dateRevenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "commentaire")
    private String commentaire;
    @JoinColumn(name = "idResidant", referencedColumnName = "idResidant")
    @ManyToOne
    private Residant residant;
    @JoinColumn(name = "idAppartement", referencedColumnName = "idAppartement")
    @ManyToOne
    private Appartement appartement;
    @JoinColumn(name="idImmeuble",referencedColumnName="idImmeuble" )
    @ManyToOne
	private Immeuble immeuble;

    public Revenus() {
    }

    public Revenus(Integer idRevenu) {
        this.idRevenu = idRevenu;
    }

    public Revenus(Integer idRevenu, int somme, Date dateRevenu, String commentaire,Appartement appartement, Residant residant,Immeuble immeuble) {
        this.idRevenu = idRevenu;
        this.somme = somme;
        this.dateRevenu = dateRevenu;
        this.commentaire = commentaire;
        this.appartement = appartement;
        this.residant= residant;
        this.immeuble=immeuble;
    }

    
    
    
    
    public Immeuble getImmeuble() {
		return immeuble;
	}

	public void setImmeuble(Immeuble immeuble) {
		this.immeuble = immeuble;
	}

	public Integer getIdRevenu() {
        return idRevenu;
    }

    public void setIdRevenu(Integer idRevenu) {
        this.idRevenu = idRevenu;
    }

    public int getSomme() {
        return somme;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }

    public Date getDateRevenu() {
        return dateRevenu;
    }

    public void setDateRevenu(Date dateRevenu) {
        this.dateRevenu = dateRevenu;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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
        hash += (idRevenu != null ? idRevenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revenus)) {
            return false;
        }
        Revenus other = (Revenus) object;
        if ((this.idRevenu == null && other.idRevenu != null) || (this.idRevenu != null && !this.idRevenu.equals(other.idRevenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.springboot.Pfa.ProjetPfa.model.Revenus[ idRevenu=" + idRevenu + " ]";
    }
    
}
