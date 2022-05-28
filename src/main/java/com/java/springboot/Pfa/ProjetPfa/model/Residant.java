package com.java.springboot.Pfa.ProjetPfa.model;



import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "Residant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Residant.findAll", query = "SELECT r FROM Residant r"),
    @NamedQuery(name = "Residant.findByIdResidant", query = "SELECT r FROM Residant r WHERE r.idResidant = :idResidant"),
    @NamedQuery(name = "Residant.findByNom", query = "SELECT r FROM Residant r WHERE r.nom = :nom"),
    @NamedQuery(name = "Residant.findByPrenom", query = "SELECT r FROM Residant r WHERE r.prenom = :prenom"),
    @NamedQuery(name = "Residant.findByEmail", query = "SELECT r FROM Residant r WHERE r.email = :email"),
    @NamedQuery(name = "Residant.findByPassword", query = "SELECT r FROM Residant r WHERE r.password = :password"),
    @NamedQuery(name = "Residant.findByTel", query = "SELECT r FROM Residant r WHERE r.tel = :tel"),
    @NamedQuery(name = "Residant.findByVille", query = "SELECT r FROM Residant r WHERE r.ville = :ville")})
public class Residant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Integer idResidant;
    @Size(max = 30)
    @Column(length = 30)
    private String nom;
    @Size(max = 30)
    @Column(length = 30)
    private String prenom;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 30)
    @Column(length = 30)
    private String email;
    @Size(max = 30)
    @Column(length = 30)
    private String password;
    @Size(max = 30)
    @Column(length = 30)
    private String tel;
    @Size(max = 30)
    @Column(length = 30)
    private String ville;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "residant")
    private Collection<ResidantAppartement> residantappartementCollection;

    public Residant() {
    }

    public Residant(Integer idResidant) {
        this.idResidant = idResidant;
    }

    
    public Residant(Integer idResidant, String nom, String prenom, String email, String password, String tel, String ville) {
    	this.idResidant = idResidant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.ville = ville;
    }
    public Integer getIdResidant() {
        return idResidant;
    }

    public void setIdResidant(Integer idResidant) {
        this.idResidant = idResidant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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
        hash += (idResidant != null ? idResidant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Residant)) {
            return false;
        }
        Residant other = (Residant) object;
        if ((this.idResidant == null && other.idResidant != null) || (this.idResidant != null && !this.idResidant.equals(other.idResidant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.springboot.Pfa.ProjetPfa.model.Residant[ idResidant=" + idResidant + " ]";
    }
    
}
