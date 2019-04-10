package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "professeurs")
@PrimaryKeyJoinColumn(name = "id")
public class Professeur extends Utilisateur implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private String specialite;
	public Professeur(String specialite) {
		super();
		this.specialite = specialite;
	}

	@Enumerated(EnumType.STRING)
	protected Grade grade;
	
	@OneToMany(mappedBy = "professeur",cascade=CascadeType.PERSIST)
	private List<Intervention> interventions;
	
	public Professeur(){
		super();
	}
	

	public Professeur(Integer id, String cin, String nom, String prenom, Date dateNaissance, String tel, String email,
			String specialite, Grade grade, List<Intervention> interventions) {
		super(id, cin, nom, prenom, dateNaissance, tel, email);
		this.specialite = specialite;
		this.grade = grade;
		this.interventions = interventions;
	}


	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	

	public List<Intervention> getInterventions() {
		return interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}


	@Override
	public String toString() {
		return "Professeur [specialite=" + specialite + ", grade=" + grade + ", interventions=" + interventions + "]";
	}

	

	
	

}
