package no.hvl.dat109.hjelpeklasser;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import no.hvl.dat109.eao.BilEAO;
import no.hvl.dat109.eao.KundeEAO;
import no.hvl.dat109.entities.Adress;
import no.hvl.dat109.entities.Bil;
import no.hvl.dat109.entities.Utleigekontor;
import no.hvl.dat109.entities.Biltype;
	

public class main {
	@EJB
	private static KundeEAO m;

	public static void main(String[] args) {
//		Adress adress = new Adress(999, "Leirajordet 17", "6013", "AALESUND");
//		Utleigekontor utleigekontor = new Utleigekontor(999, "41549773", adress);
//		Biltype biltype = new Biltype("999", "Toyota Carina");
//		Bil bil = new Bil("ST99627", biltype, utleigekontor);
//		System.out.println(bil.toString());
//		
//		BilEAO bileao = new BilEAO();
//		String test = bileao.hentBeskrivelse("UC31787");
//		System.out.println(test);
//		List<Bil> nyListe = bileao.hentAlleBiler();
//		nyListe.forEach(x -> System.out.println(x));
		
//		KundeEAO kundeeao = new KundeEAO();
//		
//		System.out.println(m.hentKundeNavn("81548300"));

	}

}
