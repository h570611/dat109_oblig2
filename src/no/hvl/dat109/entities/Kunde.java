package no.hvl.dat109.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the kunde database table.
 * 
 */
//@Entity
//@NamedQuery(name="Kunde.findAll", query="SELECT k FROM Kunde k")
@Entity(name = "Kunde")
@Table(name = "Kunde", schema = "jonas")
public class Kunde implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String telefonnummer;

	private String etternavn;

	private String fornavn;
	
	private String kredittkort;

	//bi-directional many-to-one association to Adress
	@ManyToOne
	@JoinColumn(name="adresse")
	private Adress adress;

	//bi-directional many-to-one association to Reservasjon
	@OneToMany(mappedBy="kundeBean")
	private List<Reservasjon> reservasjons;

	public Kunde() {
	}
	
	public Kunde(String telefonnummer, String etternavn, String fornavn, Adress adress, String kredittkort) {
		this.telefonnummer = telefonnummer;
		this.etternavn = etternavn;
		this.fornavn = fornavn;
		this.adress = adress;
		this.kredittkort = kredittkort;
	}

	public String getTelefonnummer() {
		return this.telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public String getEtternavn() {
		return this.etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getFornavn() {
		return this.fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public Adress getAdress() {
		return this.adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public List<Reservasjon> getReservasjons() {
		return this.reservasjons;
	}

	public void setReservasjons(List<Reservasjon> reservasjons) {
		this.reservasjons = reservasjons;
	}

	public Reservasjon addReservasjon(Reservasjon reservasjon) {
		getReservasjons().add(reservasjon);
		reservasjon.setKundeBean(this);

		return reservasjon;
	}

	public Reservasjon removeReservasjon(Reservasjon reservasjon) {
		getReservasjons().remove(reservasjon);
		reservasjon.setKundeBean(null);

		return reservasjon;
	}

	public String getKredittkort() {
		return kredittkort;
	}

	public void setKredittkort(String kredittkort) {
		this.kredittkort = kredittkort;
	}

}