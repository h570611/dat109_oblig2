package no.hvl.dat109.eao;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.entities.Reservasjon;

@Stateless
public class ReservasjonEAO {
	@PersistenceContext(name = "leiePU")
	private EntityManager em;	
	

	public List<Reservasjon> hentAlleReservasjoner(){
		return em.createNamedQuery("Reservasjon.findAll", Reservasjon.class).getResultList();
	}
	
	public List<String> hentAlleReserverteRegnr(){
		List<Reservasjon> reservasjoner = hentAlleReservasjoner();
		List<String> out;
		out = reservasjoner.stream()
				.map(x -> x.getBilBean().getRegnr())
				.collect(Collectors.toList());
		
		return out;
	}
	
	public Reservasjon lagreReservasjon(Reservasjon res) {
		em.persist(res);
		em.flush();
		return res;
	}
	
	public Reservasjon hentReservasjon(int id) {
		return em.find(Reservasjon.class, id);
	}
	
	public void oppdaterKmstand(int kmstand, int id) {
		Reservasjon ReservasjonToUpdate = hentReservasjon(id);
	
		ReservasjonToUpdate.setKmstandut(kmstand);
		lagreReservasjon(ReservasjonToUpdate);
	

	}
	public void oppdaterKmstandInn(int kmstand, int id) {
		Reservasjon ReservasjonToUpdate = hentReservasjon(id);
		
		ReservasjonToUpdate.setKmstandinn(kmstand);
		lagreReservasjon(ReservasjonToUpdate);
		
		
	}

}
