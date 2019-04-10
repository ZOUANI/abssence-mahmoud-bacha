package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class InterventionId  implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idElementModule;
	private Integer idProfesseur;
	

	public InterventionId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdElementModule() {
		return idElementModule;
	}

	public void setIdElementModule(Integer idElementModule) {
		this.idElementModule = idElementModule;
	}

	
	public InterventionId(Integer idElementModule, Integer idProfesseur) {
		super();
		this.idElementModule = idElementModule;
		this.idProfesseur = idProfesseur;
	}

	
	public Integer getIdProfesseur() {
		return idProfesseur;
	}

	public void setIdProfesseur(Integer idProfesseur) {
		this.idProfesseur = idProfesseur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idElementModule == null) ? 0 : idElementModule.hashCode());
		result = prime * result + ((idProfesseur == null) ? 0 : idProfesseur.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InterventionId other = (InterventionId) obj;
		if (idElementModule == null) {
			if (other.idElementModule != null)
				return false;
		} else if (!idElementModule.equals(other.idElementModule))
			return false;
		if (idProfesseur == null) {
			if (other.idProfesseur != null)
				return false;
		} else if (!idProfesseur.equals(other.idProfesseur))
			return false;
		return true;
	}

	
	
	

}
