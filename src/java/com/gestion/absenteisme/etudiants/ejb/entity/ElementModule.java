package com.gestion.absenteisme.etudiants.ejb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="elementsmodule")
public class ElementModule  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String code;
	protected String intitule;
	protected String contenu;
	protected int volumeHoraireCours;
	protected int volumeHoraireTd;
	protected int volumeHoraireTP;
	protected int volumeHoraireAP;
	
	@ManyToOne()
	@JoinColumn(name="module_id")
	protected Module module;
	
	@OneToMany(mappedBy = "elementModule",cascade=CascadeType.PERSIST)
	protected List<Intervention> interventions;

	public ElementModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	



	public ElementModule(Integer id, String code, String intitule, String contenu, int volumeHoraireCours,
			int volumeHoraireTd, int volumeHoraireTP, int volumeHoraireAP, Module module,
			List<Intervention> interventions) {
		super();
		this.id = id;
		this.code = code;
		this.intitule = intitule;
		this.contenu = contenu;
		this.volumeHoraireCours = volumeHoraireCours;
		this.volumeHoraireTd = volumeHoraireTd;
		this.volumeHoraireTP = volumeHoraireTP;
		this.volumeHoraireAP = volumeHoraireAP;
		this.module = module;
		this.interventions = interventions;
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

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

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

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<Intervention> getInterventions() {
		return interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	@Override
	public String toString() {
		return "ElementModule [id=" + id + ", code=" + code + ", intitule=" + intitule + ", contenu=" + contenu
				+ ", volumeHoraireCours=" + volumeHoraireCours + ", volumeHoraireTd=" + volumeHoraireTd
				+ ", volumeHoraireTP=" + volumeHoraireTP + ", volumeHoraireAP=" + volumeHoraireAP + ", module=" + module
				+ ", interventions=" + interventions + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElementModule other = (ElementModule) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	


	

}
