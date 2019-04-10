package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "inscriptions")
public class Inscription implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	InscriptionId pk;
	@Temporal(TemporalType.DATE)
	Date date;
	@Enumerated(EnumType.STRING)
	Niveau niveau;
	
	
	public Inscription() {
		super();
	}
	public InscriptionId getPk() {
		return pk;
	}
	public void setPk(InscriptionId pk) {
		this.pk = pk;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	
	public AnneeUniversitaire getAnneeUniversitaire(){
		return getPk().getAnnuniv();
	}
	
	public void setAnneeUniversitaire(AnneeUniversitaire annuniv){
		
		getPk().setAnnuniv(annuniv);
	}
	
	public Filiere getFiliere(){
		return getPk().getFiliere();
	}
	
	public void setFiliere(Filiere filiere){
		
		getPk().setFiliere(filiere);
	}
	
	public Etudiant getEtudiant(){
		return getPk().getEtudiant();
	}
	
	public void setEtudiant(Etudiant etudiant){
		
		getPk().setEtudiant(etudiant);
	}
	
	

}
