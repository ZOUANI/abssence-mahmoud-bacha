package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="groupes")
public class Groupe implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String intitule;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "groupe_etudiant", joinColumns = @JoinColumn(name = "groupe_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "etudiant_id", referencedColumnName = "id"))
	protected List<Etudiant> etudiants;
	
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
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
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	
	
	
	

}
