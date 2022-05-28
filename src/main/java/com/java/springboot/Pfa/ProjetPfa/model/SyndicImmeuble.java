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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "syndicImmeuble")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SyndicImmeuble.findAll", query = "SELECT s FROM SyndicImmeuble s"),
    @NamedQuery(name = "SyndicImmeuble.findByIdSyndicImmeuble", query = "SELECT s FROM SyndicImmeuble s WHERE s.idSyndicImmeuble = :idSyndicImmeuble"),
    @NamedQuery(name = "SyndicImmeuble.findByDateDebut", query = "SELECT s FROM SyndicImmeuble s WHERE s.dateDebut = :dateDebut"),
    @NamedQuery(name = "SyndicImmeuble.findByDateFin", query = "SELECT s FROM SyndicImmeuble s WHERE s.dateFin = :dateFin")})
public class SyndicImmeuble implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSyndicImmeuble")
    private Integer idSyndicImmeuble;
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
    @JoinColumn(name = "idSyndicImmeuble", referencedColumnName = "idSyndic", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Syndic syndic;

    public SyndicImmeuble() {
    }

    public SyndicImmeuble(Integer idSyndicImmeuble) {
        this.idSyndicImmeuble = idSyndicImmeuble;
    }

    public SyndicImmeuble(Integer idSyndicImmeuble, Date dateDebut, Date dateFin) {
        this.idSyndicImmeuble = idSyndicImmeuble;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Integer getIdSyndicImmeuble() {
        return idSyndicImmeuble;
    }

    public void setIdSyndicImmeuble(Integer idSyndicImmeuble) {
        this.idSyndicImmeuble = idSyndicImmeuble;
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

    public Syndic getSyndic() {
        return syndic;
    }

    public void setSyndic(Syndic syndic) {
        this.syndic = syndic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSyndicImmeuble != null ? idSyndicImmeuble.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SyndicImmeuble)) {
            return false;
        }
        SyndicImmeuble other = (SyndicImmeuble) object;
        if ((this.idSyndicImmeuble == null && other.idSyndicImmeuble != null) || (this.idSyndicImmeuble != null && !this.idSyndicImmeuble.equals(other.idSyndicImmeuble))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.java.springboot.Pfa.ProjetPfa.model.Syndicimmeuble[ idSyndicImmeuble=" + idSyndicImmeuble + " ]";
    }
    
}

