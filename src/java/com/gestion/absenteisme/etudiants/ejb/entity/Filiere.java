package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "filieres")
public class Filiere implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String intitule;
	@Temporal(TemporalType.DATE)
	protected Date dateAccreditation;

	@ElementCollection()
	@CollectionTable(name = "filieres_options")
	@Column(name = "intitule")
	protected List<String> optionFiliere;

	@ElementCollection
	@CollectionTable(name = "debouches")
	@Column(name = "intitule")
	protected List<String> debouche;

	@ElementCollection
	@CollectionTable(name = "competence_a_acquirir")
	@Column(name = "intitule")
	protected List<String> competenceAAcquirir;

	@ElementCollection
	@CollectionTable(name = "objectifs_formation")
	@Column(name = "intitule")
	protected List<String> objectifFormation;

	@ElementCollection
	@CollectionTable(name = "conditions_Acces")
	@Column(name = "intitule")
	protected List<String> conditionAcces;

	@ElementCollection
	@CollectionTable(name = "partenaires")
	@Column(name = "intitule")
	protected List<String> partenaire;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "coordinateur")
	protected Professeur coordinateur;
	
	@OneToMany(mappedBy = "pk.filiere")
	protected List<Inscription> inscription;

	public Filiere() {
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

	public Date getDateAccreditation() {
		return dateAccreditation;
	}

	public void setDateAccreditation(Date dateAccreditation) {
		this.dateAccreditation = dateAccreditation;
	}

	public List<String> getOptionFiliere() {
		return optionFiliere;
	}

	public void setOptionFiliere(List<String> optionFiliere) {
		this.optionFiliere = optionFiliere;
	}

	public List<String> getDebouche() {
		return debouche;
	}

	public void setDebouche(List<String> debouche) {
		this.debouche = debouche;
	}



	public List<String> getCompetenceAAcquirir() {
		return competenceAAcquirir;
	}

	public void setCompetenceAAcquirir(List<String> competenceAAcquirir) {
		this.competenceAAcquirir = competenceAAcquirir;
	}

	public List<String> getObjectifFormation() {
		return objectifFormation;
	}

	public void setObjectifFormation(List<String> objectifFormation) {
		this.objectifFormation = objectifFormation;
	}

	public List<String> getConditionAcces() {
		return conditionAcces;
	}

	public void setConditionAcces(List<String> conditionAcces) {
		this.conditionAcces = conditionAcces;
	}

	public List<String> getPartenaire() {
		return partenaire;
	}

	public void setPartenaire(List<String> partenaire) {
		this.partenaire = partenaire;
	}

	public Professeur getCoordinateur() {
		return coordinateur;
	}

	public void setCoordinateur(Professeur coordinateur) {
		this.coordinateur = coordinateur;
	}

	public List<Inscription> getInscription() {
		return inscription;
	}

	public void setInscription(List<Inscription> inscription) {
		this.inscription = inscription;
	}

	@Override
	public String toString() {
		return "Filiere [id=" + id + ", intitule=" + intitule + ", dateAccreditation=" + dateAccreditation
				+ ", optionFiliere=" + optionFiliere + ", debouche=" + debouche + ", conditionAAcquirir="
				+ competenceAAcquirir + ", objectifFormation=" + objectifFormation + ", conditionAcces=" + conditionAcces
				+ ", partenaire=" + partenaire + ", coordinateur=" + coordinateur + ", inscription=" + inscription
				+ "]";
	}

	

}
