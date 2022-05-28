package com.java.springboot.Pfa.ProjetPfa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "immeuble")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Immeuble.findAll", query = "SELECT i FROM Immeuble i"),
		@NamedQuery(name = "Immeuble.findByIdImmeuble", query = "SELECT i FROM Immeuble i WHERE i.idImmeuble = :idImmeuble"),
		@NamedQuery(name = "Immeuble.findByNom", query = "SELECT i FROM Immeuble i WHERE i.nom = :nom"),
		@NamedQuery(name = "Immeuble.findByAdresse", query = "SELECT i FROM Immeuble i WHERE i.adresse = :adresse"),
		@NamedQuery(name = "Immeuble.findByVille", query = "SELECT i FROM Immeuble i WHERE i.ville = :ville"),
		// WHERE i"),
		@NamedQuery(name = "Immeuble.findByNumero", query = "SELECT i FROM Immeuble i WHERE i.numero = :numero"),
		@NamedQuery(name = "Immeuble.findByNbrEtage", query = "SELECT i FROM Immeuble i WHERE i.nbrEtage = :nbrEtage") })
public class Immeuble implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idImmeuble")
	private Integer idImmeuble;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 60)
	@Column(name = "nom")
	private String nom;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 70)
	@Column(name = "adresse")
	private String adresse;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 60)
	@Column(name = "ville")
	private String ville;
	
	@Basic(optional = false)
	@NotNull
	@Column(name = "numero")
	private int numero;
	@Basic(optional = false)
	@NotNull
	@Column(name = "nbrEtage")
	private int nbrEtage;
	@Basic(optional = false)
	@NotNull
	@Column(name = "nbrAppart")
	private int nbrAppart;

	

	public Immeuble() {
	}

	public Immeuble(Integer idImmeuble) {
		this.idImmeuble = idImmeuble;
	}

	public Immeuble(Integer idImmeuble, String nom, String adresse, String ville, int numero, int nbrEtage,int nbrAppart) {
		this.idImmeuble = idImmeuble;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;

		this.numero = numero;
		this.nbrEtage = nbrEtage;
		this.nbrAppart = nbrAppart;
	}

	public Integer getIdImmeuble() {
		return idImmeuble;
	}

	public void setIdImmeuble(Integer idImmeuble) {
		this.idImmeuble = idImmeuble;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNbrEtage() {
		return nbrEtage;
	}

	public void setNbrEtage(int nbrEtage) {
		this.nbrEtage = nbrEtage;
	}
	
	public int getNbrAppart() {
		return nbrAppart;
	}

	public void setNbrAppart(int nbrAppart) {
		this.nbrAppart = nbrAppart;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idImmeuble != null ? idImmeuble.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Immeuble)) {
			return false;
		}
		Immeuble other = (Immeuble) object;
		if ((this.idImmeuble == null && other.idImmeuble != null)
				|| (this.idImmeuble != null && !this.idImmeuble.equals(other.idImmeuble))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.java.springboot.Pfa.ProjetPfa.model.Immeuble[ idImmeuble=" + idImmeuble + " ]";
	}

	

}
