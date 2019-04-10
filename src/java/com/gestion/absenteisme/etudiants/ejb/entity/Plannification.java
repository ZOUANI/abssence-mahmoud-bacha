package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plannifications")
public class Plannification implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	PlannificationId pk;

	public PlannificationId getPk() {
		return pk;
	}

	
	public Plannification() {
		super();
		// TODO Auto-generated constructor stub
	}


	public void setPk(PlannificationId pk) {
		this.pk = pk;
	}
	
	
	public AnneeUniversitaire getAnneeUniversitaire(){
		return getPk().getAnnuniv();
	}
	
	public void setAnneeUniversitaire(AnneeUniversitaire annuniv){
		
		getPk().setAnnuniv(annuniv);
	}
	
	public Semestre getSemestre(){
		return getPk().getSemestre();
	}
	
	public void setSemestre(Semestre semestre){
		
		getPk().setSemestre(semestre);
	}


	
	
	

}
