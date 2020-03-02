package no.hvl.dat109.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bil database table.
 * 
 */


@Entity(name = "Bil")
@Table(name = "Bil", schema = "jonas")
@NamedQuery(name="Bil.findAll", query="SELECT b FROM Bil b")
public class Bil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String regnr;
	
	private String farge;
	
	private String merke;

	//bi-directional many-to-one association to Biltype
	@ManyToOne
	@JoinColumn(name="typeid")
	private Biltype biltype;

	//bi-directional many-to-one association to Utleigekontor
	@ManyToOne
	@JoinColumn(name="staarved")
	private Utleigekontor utleigekontor;

	//bi-directional many-to-one association to Reservasjon
	@OneToMany(mappedBy="bilBean")
	private List<Reservasjon> reservasjons;

	public Bil() {
	}
	
	public Bil(String regnr, Biltype biltype, Utleigekontor utleigekontor, String merke, String farge) {
		this.regnr = regnr;
		this.biltype = biltype;
		this.utleigekontor = utleigekontor;
		this.merke = merke;
		this.farge = farge;
	}

	public String getRegnr() {
		return this.regnr;
	}

	public void setRegnr(String regnr) {
		this.regnr = regnr;
	}

	public Biltype getBiltype() {
		return this.biltype;
	}

	public void setBiltype(Biltype biltype) {
		this.biltype = biltype;
	}

	public Utleigekontor getUtleigekontor() {
		return this.utleigekontor;
	}

	public void setUtleigekontor(Utleigekontor utleigekontor) {
		this.utleigekontor = utleigekontor;
	}

	public List<Reservasjon> getReservasjons() {
		return this.reservasjons;
	}

	public void setReservasjons(List<Reservasjon> reservasjons) {
		this.reservasjons = reservasjons;
	}

	public Reservasjon addReservasjon(Reservasjon reservasjon) {
		getReservasjons().add(reservasjon);
		reservasjon.setBilBean(this);

		return reservasjon;
	}

	public Reservasjon removeReservasjon(Reservasjon reservasjon) {
		getReservasjons().remove(reservasjon);
		reservasjon.setBilBean(null);

		return reservasjon;
	}

	@Override
	public String toString() {
		return "Bil [regnr=" + regnr + ", biltype=" + biltype + ", utleigekontor=" + utleigekontor + ", reservasjons="
				+ reservasjons + ", merke=" + merke + "]";
	}

	public String getMerke() {
		return merke;
	}

	public void setMerke(String merke) {
		this.merke = merke;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}
	

}