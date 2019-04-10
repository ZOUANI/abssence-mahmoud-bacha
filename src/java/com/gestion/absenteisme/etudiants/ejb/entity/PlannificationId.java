package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PlannificationId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne()
	@JoinColumn(name="id_annee_universitaire")
	private AnneeUniversitaire annuniv;
	
	@ManyToOne()
	@JoinColumn(name="id_semestre")
	private Semestre semestre;
	

	public PlannificationId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnneeUniversitaire getAnnuniv() {
		return annuniv;
	}

	public void setAnnuniv(AnneeUniversitaire annuniv) {
		this.annuniv = annuniv;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}


	

	
	

	
}
