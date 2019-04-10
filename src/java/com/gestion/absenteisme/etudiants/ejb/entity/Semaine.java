package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "semaines")
public class Semaine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	
	@Temporal(TemporalType.DATE)
	Date dateDebut ;
	@Temporal(TemporalType.DATE)
	Date dateFin;
	
	@ManyToOne()
	@JoinColumns({
		@JoinColumn(name="id_plannification_ann" , referencedColumnName="id_annee_universitaire"),
		@JoinColumn(name="id_plannification_semestre",referencedColumnName="id_semestre")
	})
	Plannification plannification;
	
	@OneToMany(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="id_semaine")
	private List<Jour> jours;
	

	public Semaine() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public Plannification getPlannification() {
		return plannification;
	}


	public void setPlannification(Plannification plannification) {
		this.plannification = plannification;
	}


	public List<Jour> getJours() {
		return jours;
	}


	public void setJours(List<Jour> jours) {
		this.jours = jours;
	}

	
	
	
	
}
