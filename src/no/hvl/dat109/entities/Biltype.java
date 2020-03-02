package no.hvl.dat109.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the biltype database table.
 * 
 */
@Entity(name="Biltype")
@Table(name="Biltype", schema="jonas")
@NamedQuery(name="Biltype.findAll", query="SELECT b FROM Biltype b")
public class Biltype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String typeid;

	private String description;
	
	
	
	private int pris;

	//bi-directional many-to-one association to Bil
	@OneToMany(mappedBy="biltype")
	private List<Bil> bils = new ArrayList<Bil>();

	public Biltype() {
	}
	
	public Biltype(String typeid, String description, int pris) {
		this.typeid = typeid;
		this.description = description;
		this.pris = pris;
	}

	public String getTypeid() {
		return this.typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	



	public List<Bil> getBils() {
		return this.bils;
	}

	public void setBils(List<Bil> bils) {
		this.bils = bils;
	}

	public Bil addBil(Bil bil) {
		getBils().add(bil);
		bil.setBiltype(this);

		return bil;
	}

	public Bil removeBil(Bil bil) {
		getBils().remove(bil);
		bil.setBiltype(null);

		return bil;
	}

	@Override
	public String toString() {
		return "Biltype [typeid=" + typeid + ", description=" + description + ", bils=" + bils + ", pris=" + pris +"]";
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}
	

}