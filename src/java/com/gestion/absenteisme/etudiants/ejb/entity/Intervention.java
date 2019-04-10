package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "interventions")
@IdClass(InterventionId.class)
public class Intervention implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	private Integer idElementModule;
	@Id 
	private Integer idProfesseur;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="idElementModule",insertable=false,updatable=false)
	private ElementModule elementModule;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="idProfesseur",insertable=false,updatable=false)
	private Professeur professeur;
	
	protected int volumeHoraireCours;
	protected int volumeHoraireTd;
	protected int volumeHoraireTP;
	protected int volumeHoraireAP;
	
	public int getVolumeHoraireCours() {
		return volumeHoraireCours;
	}
	public void setVolumeHoraireCours(int volumeHoraireCours) {
		this.volumeHoraireCours = volumeHoraireCours;
	}
	public int getVolumeHoraireTd() {
		return volumeHoraireTd;
	}
	public void setVolumeHoraireTd(int volumeHoraireTd) {
		this.volumeHoraireTd = volumeHoraireTd;
	}
	public int getVolumeHoraireTP() {
		return volumeHoraireTP;
	}
	public void setVolumeHoraireTP(int volumeHoraireTP) {
		this.volumeHoraireTP = volumeHoraireTP;
	}
	public int getVolumeHoraireAP() {
		return volumeHoraireAP;
	}
	public void setVolumeHoraireAP(int volumeHoraireAP) {
		this.volumeHoraireAP = volumeHoraireAP;
	}
	
	
	public Integer getIdElementModule() {
		return idElementModule;
	}
	public void setIdElementModule(Integer idElementModule) {
		this.idElementModule = idElementModule;
	}
	public Integer getIdProfesseur() {
		return idProfesseur;
	}
	public void setIdProfesseur(Integer idProfesseur) {
		this.idProfesseur = idProfesseur;
	}
	public Intervention() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ElementModule getElementModule() {
		return elementModule;
	}
	public void setElementModule(ElementModule elementModule) {
		this.elementModule = elementModule;
	}
	public Professeur getProfesseur() {
		return professeur;
	}
	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}
	@Override
	public String toString() {
		return "Intervention " + " volumeHoraireCours=" + volumeHoraireCours + ", volumeHoraireTd="
				+ volumeHoraireTd + ", volumeHoraireTP=" + volumeHoraireTP + ", volumeHoraireAP=" + volumeHoraireAP
				+ "]";
	}

}
