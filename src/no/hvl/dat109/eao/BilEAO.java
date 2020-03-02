package no.hvl.dat109.eao;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import no.hvl.dat109.entities.Bil;

@Stateless
public class BilEAO {
	@PersistenceContext(name = "leiePU")
	private EntityManager em;
	
//	public String hentBeskrivelse(String regnr) {
//		Bil bil = em.find(Bil.class, regnr);
//		return bil.getBiltype().getDescription();
//	}
	
	public List<Bil> hentAlleBiler(){
		return em.createNamedQuery("Bil.findAll", Bil.class).getResultList();
	}
	
	
	public Bil hentBil(String regnr) {
		return em.find(Bil.class, regnr);
	}
	
//	public List<Bil> hentAlleBiler() {
//		return em.createNamedQuery("Bil.findAll", Bil.class).getResultList();
//	
//	}
	
	public Bil lagreBil(Bil bil) {
		em.persist(bil);
		em.flush();
		return bil;
	}
	
	public List<String> hentAlleRegnr(){
		List<Bil> biler = hentAlleBiler();
		List<String> out;
		out = biler.stream()
		.map(x -> x.getRegnr())
		.collect(Collectors.toList());
		
		return out;
	}
	
	

}
