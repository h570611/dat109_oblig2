package no.hvl.dat109.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.entities.Kunde;

@Stateless
public class KundeEAO {
	@PersistenceContext(name = "leiePU")
	EntityManager em;
	
	public Kunde hentKunde(String telefonnummer) {
		
		return (em.find(Kunde.class, telefonnummer));
	}
	
	public Kunde lagreKunde(Kunde kunde) {
		em.persist(kunde);
		em.flush();
		return kunde;
	}
	public void endrekredNr(String telefonnummer,String kredNr) {
		Kunde kundeUnderEndring = hentKunde(telefonnummer);
		kundeUnderEndring.setKredittkort(kredNr);
		lagreKunde(kundeUnderEndring);
	}

}
