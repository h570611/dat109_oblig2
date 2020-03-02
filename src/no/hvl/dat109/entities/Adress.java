package no.hvl.dat109.entities;

import java.io.Serializable;
import javax.persistence.*;



import java.util.List;


/**
 * The persistent class for the adress database table.
 * 
 */
@Entity(name = "Adress")
@Table(name = "Adress", schema = "jonas")
@NamedQuery(name="Adress.findAll", query="SELECT a FROM Adress a")
public class Adress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String gateadresse;

	private String postnummer;

	private String poststed;

	//bi-directional many-to-one association to Kunde
	@OneToMany(mappedBy="adress")
	private List<Kunde> kundes;

	//bi-directional many-to-one association to Utleigekontor
	@OneToMany(mappedBy="adress")
	private List<Utleigekontor> utleigekontors;

	public Adress() {
	}
	
	public Adress(Integer id, String gateadresse, String postnummer, String poststed) {
		this.id = id;
		this.gateadresse = gateadresse;
		this.postnummer = postnummer;
		this.poststed = poststed;
		
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGateadresse() {
		return this.gateadresse;
	}

	public void setGateadresse(String gateadresse) {
		this.gateadresse = gateadresse;
	}

	public String getPostnummer() {
		return this.postnummer;
	}

	public void setPostnummer(String postnummer) {
		this.postnummer = postnummer;
	}

	public String getPoststed() {
		return this.poststed;
	}

	public void setPoststed(String poststed) {
		this.poststed = poststed;
	}

	public List<Kunde> getKundes() {
		return this.kundes;
	}

	public void setKundes(List<Kunde> kundes) {
		this.kundes = kundes;
	}

	public Kunde addKunde(Kunde kunde) {
		getKundes().add(kunde);
		kunde.setAdress(this);

		return kunde;
	}

	public Kunde removeKunde(Kunde kunde) {
		getKundes().remove(kunde);
		kunde.setAdress(null);

		return kunde;
	}

	public List<Utleigekontor> getUtleigekontors() {
		return this.utleigekontors;
	}

	public void setUtleigekontors(List<Utleigekontor> utleigekontors) {
		this.utleigekontors = utleigekontors;
	}

	public Utleigekontor addUtleigekontor(Utleigekontor utleigekontor) {
		getUtleigekontors().add(utleigekontor);
		utleigekontor.setAdress(this);

		return utleigekontor;
	}

	public Utleigekontor removeUtleigekontor(Utleigekontor utleigekontor) {
		getUtleigekontors().remove(utleigekontor);
		utleigekontor.setAdress(null);

		return utleigekontor;
	}

	@Override
	public String toString() {
		return "Adress [id=" + id + ", gateadresse=" + gateadresse + ", postnummer=" + postnummer + ", poststed="
				+ poststed + ", kundes=" + kundes + ", utleigekontors=" + utleigekontors + "]";
	}
	

}