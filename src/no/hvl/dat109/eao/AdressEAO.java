package no.hvl.dat109.eao;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.entities.Adress;
import no.hvl.dat109.entities.Utleigekontor;

@Stateless
public class AdressEAO {
@PersistenceContext(name="leiePU")
EntityManager em;

	public List<Adress> hentAlleAdress(){
		return em.createNamedQuery("Adress.findAll", Adress.class).getResultList();
	}
	
	public List<Integer> hentAlleAdressId(){
		List<Adress> alle = hentAlleAdress();
		List<Integer> out;
		out = alle.stream()
				.map(x -> x.getId())
				.collect(Collectors.toList());
		
		return out;
	}
	
	public Adress lagreAdress(Adress adress) {
		em.persist(adress);
		em.flush();
		return adress;
	}

	
}
