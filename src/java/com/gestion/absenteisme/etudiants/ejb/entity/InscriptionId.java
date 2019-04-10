package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class InscriptionId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne()
	@JoinColumn(name="id_annee_universitaire")
	private AnneeUniversitaire annuniv;
	
	@ManyToOne()
	@JoinColumn(name="id_filiere")
	private Filiere filiere;
	
	@ManyToOne()
	@JoinColumn(name="id_etudiant")
	private Etudiant etudiant;
	
	

	public InscriptionId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnneeUniversitaire getAnnuniv() {
		return annuniv;
	}

	public void setAnnuniv(AnneeUniversitaire annuniv) {
		this.annuniv = annuniv;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	
}
