package no.hvl.dat109.hjelpeklasser;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import no.hvl.dat109.IF.PersistenceDatalagring;
import no.hvl.dat109.eao.AdressEAO;
import no.hvl.dat109.eao.BilEAO;
import no.hvl.dat109.eao.KundeEAO;
import no.hvl.dat109.eao.ReservasjonEAO;
import no.hvl.dat109.eao.UtleigekontorEAO;
import no.hvl.dat109.entities.Adress;
import no.hvl.dat109.entities.Bil;
import no.hvl.dat109.entities.Kunde;
import no.hvl.dat109.entities.Reservasjon;
import no.hvl.dat109.entities.Utleigekontor;

@Stateless
public class Datalagring implements PersistenceDatalagring{
	@PersistenceContext(name = "leiePU")
	private EntityManager em;
	
	@EJB
	ReservasjonEAO r;
	
	@EJB 
	BilEAO b;
	
	@EJB
	AdressEAO a;
	
	@EJB
	UtleigekontorEAO u;
	
	@EJB
	KundeEAO k;
	


	
	public List<Bil> hentLedigeBiler(int lokasjon, Timestamp fra, Timestamp til){
		List<Bil> ledige = new ArrayList<>();
		List<String> ledigeRegnr = hentAlleLedigeRegnr();
		List<Bil> alle = b.hentAlleBiler();
		List<Reservasjon> alleRes = r.hentAlleReservasjoner();
		List<String> reserverteBiler = new ArrayList<>();
		
		alleRes.forEach(x -> {
			if ((x.getFradato().before(fra) || x.getFradato().equals(fra) && (x.getTildato().after(til) || x.getTildato().equals(til)))) {
				reserverteBiler.add(x.getBilBean().getRegnr());
			}
		});
		
		ledige = alle.stream()
				.filter(x -> !reserverteBiler.contains(x.getRegnr()))
				.filter(x -> ledigeRegnr.contains(x.getRegnr()))
				.filter(x -> x.getUtleigekontor().getId() == lokasjon)
				.collect(Collectors.toList());
		
		
//		ledige = regnr.forEach(x -> x.);
		
		
		
		return ledige;
	}
	
	public Reservasjon lagreReservasjon(Reservasjon res) {
		r.lagreReservasjon(res);
		return res;
	}
	public Adress lagreAdress(Adress adress) {
		a.lagreAdress(adress);
		return adress;
	}
	public Utleigekontor lagreUtleigekontor(Utleigekontor utleigekontor) {
		u.lagreUtleigekontor(utleigekontor);
		return utleigekontor;
	}
	
	public Bil lagreBil(Bil bil) {
		b.lagreBil(bil);
		return bil;
	}
	
	public List<Integer> hentAlleAdressId(){
		return a.hentAlleAdressId();
	}
	public List<Integer> hentAlleUtleigekontorId(){
		return u.alleUtleigekontorNummer();
	}
	
	public List<Reservasjon> hentAlleReservasjoner(){
		return r.hentAlleReservasjoner();
	}
	
	public Reservasjon hentReservasjon(int id) {
		return r.hentReservasjon(id);
	}
	
	public void oppdaterKmstandut(int id, int kmstand) {
		r.oppdaterKmstand(kmstand, id);
	}
	public void oppdaterKmstandinn(int id, int kmstand) {
		r.oppdaterKmstandInn(kmstand, id);
	}
	
	public Kunde hentKunde(String nummer) {
		return k.hentKunde(nummer);
	}
	
	public void oppdaterKundeKredNr(String nr, String kredNr) {
		k.endrekredNr(nr, kredNr);
	}


	

	
	public List<String> hentAlleLedigeRegnr(){
		List<String> out;
		List<String> res = r.hentAlleReserverteRegnr();
		List<String> alle = b.hentAlleRegnr();
		out = alle.stream()
				.filter(x -> !res.contains(x))
				.collect(Collectors.toList());
		
		return out;
	}
	


}
