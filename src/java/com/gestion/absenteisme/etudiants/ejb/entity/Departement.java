package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;

@Entity
@Table(name="departements")
public class Departement implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	protected String nom;
	
	@OneToOne(fetch=FetchType.LAZY,optional=true)
	@JoinColumn(name = "id_chef_dept",nullable = true,insertable=true)

	protected Professeur chefDepartement;
	
	

	public Departement() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Professeur getChefDepartement() {
		return chefDepartement;
	}

	public void setChefDepartement(Professeur chefDepartement) {
		this.chefDepartement = chefDepartement;
	}

	@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + ", chefDepartement=" + chefDepartement + "]";
	}

	
	
	
	
}
