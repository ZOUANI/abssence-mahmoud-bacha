package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "etudiants")
@PrimaryKeyJoinColumn(name = "id")
public class Etudiant extends Utilisateur implements Serializable{

	private static final long serialVersionUID = 1L;
	private int codeApogee;
	
	@OneToMany(mappedBy = "pk.etudiant",fetch=FetchType.LAZY)
	private List<Inscription> inscription;
	public Etudiant() {
		super();
	}

	public int getCodeApogee() {
		return codeApogee;
	}

	public void setCodeApogee(int codeApogee) {
		this.codeApogee = codeApogee;
	}

	public List<Inscription> getInscription() {
		return inscription;
	}

	public void setInscription(List<Inscription> inscription) {
		this.inscription = inscription;
	}

	@Override
	public String toString() {
		return "Etudiant [codeApogee=" + codeApogee + ", inscription=" + inscription + "]";
	}
	
	

}
