package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="seances")
public class Seance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	protected int heureDebut;
	protected int heureFin;
	protected String type;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_salle")
	protected Salle salle;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_element_module")
	protected ElementModule elementModule;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "seances_groupes", joinColumns = @JoinColumn(name = "seance_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "groupe_id", referencedColumnName = "id"))
	protected List<Groupe> groupes;
	
	
	

	public Seance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(int heureDebut) {
		this.heureDebut = heureDebut;
	}

	public int getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(int heureFin) {
		this.heureFin = heureFin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public ElementModule getElementModule() {
		return elementModule;
	}

	public void setElementModule(ElementModule elementModule) {
		this.elementModule = elementModule;
	}

	
	
}
