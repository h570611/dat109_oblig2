package no.hvl.dat109.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the utleigekontor database table.
 * 
 */
@Entity(name="Utleigekontor")
@Table(name="Utleigekontor", schema="jonas")
@NamedQuery(name="Utleigekontor.findAll", query="SELECT u FROM Utleigekontor u")
public class Utleigekontor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String telefonnr;

	//bi-directional many-to-one association to Bil
	@OneToMany(mappedBy="utleigekontor")
	private List<Bil> bils;

	//bi-directional many-to-one association to Reservasjon
	@OneToMany(mappedBy="utleigekontor1")
	private List<Reservasjon> reservasjons1;

	//bi-directional many-to-one association to Reservasjon
	@OneToMany(mappedBy="utleigekontor2")
	private List<Reservasjon> reservasjons2;

	//bi-directional many-to-one association to Adress
	@ManyToOne
	@JoinColumn(name="adresse")
	private Adress adress;

	public Utleigekontor() {
	}
	
	public Utleigekontor(Integer id, String telefonnr, Adress adress) {
		this.id = id;
		this.telefonnr = telefonnr;
		this.adress = adress;
		
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTelefonnr() {
		return this.telefonnr;
	}

	public void setTelefonnr(String telefonnr) {
		this.telefonnr = telefonnr;
	}

	public List<Bil> getBils() {
		return this.bils;
	}

	public void setBils(List<Bil> bils) {
		this.bils = bils;
	}

	public Bil addBil(Bil bil) {
		getBils().add(bil);
		bil.setUtleigekontor(this);

		return bil;
	}

	public Bil removeBil(Bil bil) {
		getBils().remove(bil);
		bil.setUtleigekontor(null);

		return bil;
	}

	public List<Reservasjon> getReservasjons1() {
		return this.reservasjons1;
	}

	public void setReservasjons1(List<Reservasjon> reservasjons1) {
		this.reservasjons1 = reservasjons1;
	}

	public Reservasjon addReservasjons1(Reservasjon reservasjons1) {
		getReservasjons1().add(reservasjons1);
		reservasjons1.setUtleigekontor1(this);

		return reservasjons1;
	}

	public Reservasjon removeReservasjons1(Reservasjon reservasjons1) {
		getReservasjons1().remove(reservasjons1);
		reservasjons1.setUtleigekontor1(null);

		return reservasjons1;
	}

	public List<Reservasjon> getReservasjons2() {
		return this.reservasjons2;
	}

	public void setReservasjons2(List<Reservasjon> reservasjons2) {
		this.reservasjons2 = reservasjons2;
	}

	public Reservasjon addReservasjons2(Reservasjon reservasjons2) {
		getReservasjons2().add(reservasjons2);
		reservasjons2.setUtleigekontor2(this);

		return reservasjons2;
	}

	public Reservasjon removeReservasjons2(Reservasjon reservasjons2) {
		getReservasjons2().remove(reservasjons2);
		reservasjons2.setUtleigekontor2(null);

		return reservasjons2;
	}

	public Adress getAdress() {
		return this.adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Utleigekontor [id=" + id + ", telefonnr=" + telefonnr + ", bils=" + bils + ", reservasjons1="
				+ reservasjons1 + ", reservasjons2=" + reservasjons2 + ", adress=" + adress + "]";
	}
	

}