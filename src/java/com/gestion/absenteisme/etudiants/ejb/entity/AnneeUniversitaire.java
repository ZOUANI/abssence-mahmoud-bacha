package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "anneeUniversitaire")
public class AnneeUniversitaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	@Column(name="debut_Annee",unique=true)
	protected int debutAnnee;
	@Column(name="fin_Annee",unique=true)
	protected int finAnnee;
	
	@OneToMany(mappedBy = "pk.annuniv",fetch=FetchType.LAZY)
	protected List<Plannification> plannification;
	
	@OneToMany(mappedBy = "pk.annuniv",fetch=FetchType.LAZY)
	protected List<Inscription> inscription;
	
	
	public AnneeUniversitaire() {
		super();
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDebutAnnee() {
		return debutAnnee;
	}
	public void setDebutAnnee(int debutAnnee) {
		this.debutAnnee = debutAnnee;
	}
	public int getFinAnnee() {
		return finAnnee;
	}
	public void setFinAnnee(int finAnnee) {
		this.finAnnee = finAnnee;
	}
	public List<Plannification> getPlannification() {
		return plannification;
	}
	public void setPlannification(List<Plannification> plannification) {
		this.plannification = plannification;
	}
	public List<Inscription> getInscription() {
		return inscription;
	}
	public void setInscription(List<Inscription> inscription) {
		this.inscription = inscription;
	}

	@Override
	public String toString() {
		return "AnneeUniversitaire [id=" + id + ", debutAnnee=" + debutAnnee + ", finAnnee=" + finAnnee
				+ ", plannification=" + plannification + ", inscription=" + inscription + "]";
	}

	
	
	
	
	
}
