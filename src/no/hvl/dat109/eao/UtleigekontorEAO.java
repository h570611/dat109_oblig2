package no.hvl.dat109.eao;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.entities.Adress;
import no.hvl.dat109.entities.Utleigekontor;

@Stateless
public class UtleigekontorEAO {
	@PersistenceContext(name = "leiePU")
	private EntityManager em;
	
	public List<String> hentAlleUtleiekontorSted(){
		List<Utleigekontor> utl=  em.createNamedQuery("Utleigekontor.findAll", Utleigekontor.class).getResultList();
		List<String> out;
		out = utl.stream()
				.map(x -> x.getAdress().getPoststed())
				.collect(Collectors.toList());
		
		return out;
	}
	
	public Utleigekontor hentUtleigeKontor(int id) {
		return em.find(Utleigekontor.class, id);
	}
	
	public Utleigekontor lagreUtleigekontor(Utleigekontor utl) {
		em.persist(utl);
		em.flush();
		return utl;
	}
	
	public List<Integer> alleUtleigekontorNummer(){
		List<Utleigekontor> alle = em.createNamedQuery("Utleigekontor.findAll", Utleigekontor.class).getResultList();
		List<Integer> out;
		out = alle.stream()
				.map(x -> x.getId())
				.collect(Collectors.toList());
		
		return out;
	}
	
	public List<Adress> alleAdress(){
		List<Utleigekontor> alle = em.createNamedQuery("Utleigekontor.findAll", Utleigekontor.class).getResultList();
		List<Adress> out;
		out = alle.stream()
				.map(x -> x.getAdress())
				.collect(Collectors.toList());
		
		return out;
	}
//	public List<Student> hentKlasselisteFor(String klassekode) {
//	// Her utnytter jeg toveis navigasjon!
//	return em.find(Klasse.class, klassekode).getStudenter();
//}
}
