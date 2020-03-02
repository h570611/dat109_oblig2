package no.hvl.dat109.IF;

import java.sql.Timestamp;
import java.util.List;

import no.hvl.dat109.entities.Adress;
import no.hvl.dat109.entities.Bil;
import no.hvl.dat109.entities.Kunde;
import no.hvl.dat109.entities.Reservasjon;
import no.hvl.dat109.entities.Utleigekontor;

public interface PersistenceDatalagring {
	
//	public static List<Bil> hentLedigeBiler(){
//		return null;};
	
	public List<Integer> hentAlleAdressId();
	
	public List<Integer> hentAlleUtleigekontorId();
	
	public List<String> hentAlleLedigeRegnr();
	
	public List<Bil> hentLedigeBiler(int lokasjon, Timestamp fra, Timestamp til);
	
	public Reservasjon lagreReservasjon(Reservasjon res);
	
	public Bil lagreBil(Bil bil);
	
	public Adress lagreAdress(Adress adress);
	
	public Utleigekontor lagreUtleigekontor(Utleigekontor utleigekontor);
	
	public List<Reservasjon> hentAlleReservasjoner();
	
	public Reservasjon hentReservasjon(int id);
	
	public void oppdaterKmstandinn(int id, int kmstand);
	
	public void oppdaterKmstandut(int id, int kmstand);
	
	public Kunde hentKunde(String nummer);
	
	public void oppdaterKundeKredNr(String nr, String kredNr);

}
