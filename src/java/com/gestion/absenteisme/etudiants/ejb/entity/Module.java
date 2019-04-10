package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="modules")
public class Module implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String code;
	protected String intitule;
	protected String nature;
	protected String syllabus;
	protected int volumeHoraire;
	
	@ElementCollection
	@CollectionTable(name = "objectifs_module")
	@Column(name = "contenu")
	protected List<String> objectifModule;
	
	
	@ManyToOne()
	@JoinColumn(name ="id_coordonnateur")
	protected Professeur coordonnateur;
	
//	@ManyToMany()
//	@JoinTable(name = "module_prerequis", joinColumns = @JoinColumn(name = "module_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "presrequis_id", referencedColumnName = "id"))
//
//	protected List<Module> prerequis;
	
	
	@ManyToOne()
	@JoinColumn(name ="semestre")
	protected Semestre semestre;
	
	

	public Module() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public String getNature() {
		return nature;
	}


	public void setNature(String nature) {
		this.nature = nature;
	}


	public String getSyllabus() {
		return syllabus;
	}


	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}


	public int getVolumeHoraire() {
		return volumeHoraire;
	}


	public void setVolumeHoraire(int volumeHoraire) {
		this.volumeHoraire = volumeHoraire;
	}


	


	public List<String> getObjectifModule() {
		return objectifModule;
	}


	public void setObjectifModule(List<String> objectifModule) {
		this.objectifModule = objectifModule;
	}


	public Professeur getCoordonnateur() {
		return coordonnateur;
	}


	public void setCoordonnateur(Professeur coordonnateur) {
		this.coordonnateur = coordonnateur;
	}


//	public List<Module> getPrerequis() {
//		return prerequis;
//	}
//
//
//	public void setPrerequis(List<Module> prerequis) {
//		this.prerequis = prerequis;
//	}


	public Semestre getSemestre() {
		return semestre;
	}


	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}


	@Override
	public String toString() {
		return "Module [id=" + id + ", code=" + code + ", intitule=" + intitule + ", nature=" + nature + ", syllabus="
				+ syllabus + ", volumeHoraire=" + volumeHoraire + ", objectifModule=" + objectifModule
				+ ", coordonnateur=" + coordonnateur + ", semestre=" + semestre + "]";
	}


	
	
	
	
	

}
