package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="semestres")
public class Semestre  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	protected String intitule;
	protected int volumeHoraire;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="filiere")
	protected Filiere filiere;
	
	@OneToMany(mappedBy = "pk.semestre",fetch=FetchType.LAZY)
	protected List<Plannification> plannification;
	public Semestre() {
		super();
	}
	
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getIntitule() {
		return intitule;
	}



	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}



	public int getVolumeHoraire() {
		return volumeHoraire;
	}



	public void setVolumeHoraire(int volumeHoraire) {
		this.volumeHoraire = volumeHoraire;
	}



	public Filiere getFiliere() {
		return filiere;
	}



	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}



	public List<Plannification> getPlannification() {
		return plannification;
	}



	public void setPlannification(List<Plannification> plannification) {
		this.plannification = plannification;
	}



	
	@Override
	public String toString() {
		return "Semestre [id=" + id + ", intitule=" + intitule + ", volumeHoraire=" + volumeHoraire + ", filiere="
				+ filiere + ", plannification=" + plannification + "]";
	}





	
	
	

}
