package no.hvl.dat109.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.entities.Biltype;

@Stateless
public class BiltypeEAO {
	@PersistenceContext(name="leiePU")
	EntityManager em;
	
	public Biltype hentBiltype(String type) {
		return em.find(Biltype.class, type);
	}

}
