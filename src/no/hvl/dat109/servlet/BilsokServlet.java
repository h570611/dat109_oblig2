package no.hvl.dat109.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.IF.PersistenceDatalagring;
import no.hvl.dat109.eao.BilEAO;
import no.hvl.dat109.eao.UtleigekontorEAO;
import no.hvl.dat109.entities.Adress;
import no.hvl.dat109.entities.Bil;
import no.hvl.dat109.hjelpeklasser.Datalagring;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;

/**
 * Servlet implementation class Bilsok
 */
@WebServlet("/bilsok")
public class BilsokServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	@EJB
//	Datalagring d;
	
	@EJB
	PersistenceDatalagring d = new Datalagring();
	
	@EJB
	BilEAO b;
	
	@EJB
	UtleigekontorEAO u;
	
//	Datalagring datalagring;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BilsokServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(InnloggingUtil.isInnlogget(request)) {
			List<Adress> allekontor = (List<Adress>) request.getSession().getAttribute("alleKontor");
//			allekontor.forEach(x -> System.out.println(x));
//			request.setAttribute("alleKontor", allekontor);
			
			request.getRequestDispatcher("WEB-INF/jsp/bilsok.jsp").forward(request, response);
//			System.out.println("Alle regnr: " + d.hentAlleRegnr());
//			System.out.println("Reserverte regnr: " + d.hentAlleReserverteRegnr());
//			System.out.println("Ledige regnr: " + d.hentAlleLedigeRegnr());
			List<String> ledige = d.hentAlleLedigeRegnr();
//			ledige.forEach(x -> System.out.println(x));
//			ledige.forEach(x -> System.out.println(b.hentBil(x)));
			
//			System.out.println(d.hentAlleBiler());
//			System.out.println(d.hentAlleReservasjoner());
		}else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Hent regnr:
		String regnr = request.getParameter("sokregnr");
		
		int valgtKontor = Integer.parseInt(request.getParameter("kontorValg"));
		request.getSession().setAttribute("kontorHenting", u.hentUtleigeKontor(valgtKontor));
		
		int valgtKontorLevering = Integer.parseInt(request.getParameter("kontorValgLevering"));
		request.getSession().setAttribute("kontorLevering", u.hentUtleigeKontor(valgtKontorLevering));
		
		Date fraDate = Date.valueOf(request.getParameter("fraTidspunkt"));
		Date tilDate = Date.valueOf(request.getParameter("tilTidspunkt"));
		
		Timestamp fra = new Timestamp(fraDate.getTime());
		request.getSession().setAttribute("fraTid", fra);
		
		Timestamp til = new Timestamp(tilDate.getTime());
		request.getSession().setAttribute("tilTid", til);
		
		List<Bil> ledige = d.hentLedigeBiler((valgtKontor), fra, til);
		ledige.forEach(x -> System.out.println(x));
		
		System.out.println("Valgt kontor: " + valgtKontor);
//	  	List<Bil> alleLedigeBiler = d.hentLedigeBiler(lokasjon)
		if(valgtKontor != 0) {
			request.getSession().setAttribute("alleLedigeBiler", ledige);
			response.sendRedirect("bilvalg");
		}else {
			request.getSession().setAttribute("feilmelding", "Du må velge eit kontor");
			response.sendRedirect("bilsok");
		}
		
		
	}

}
