package no.hvl.dat109.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.IF.PersistenceDatalagring;
import no.hvl.dat109.eao.KundeEAO;
import no.hvl.dat109.eao.UtleigekontorEAO;
import no.hvl.dat109.entities.Adress;
import no.hvl.dat109.entities.Kunde;
import no.hvl.dat109.entities.Utleigekontor;
import no.hvl.dat109.hjelpeklasser.Datalagring;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;

/**
 * Servlet implementation class logginnServlet
 */
@WebServlet({ "/login", "/index.html" })
public class logginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	KundeEAO k;
	
	@EJB
	PersistenceDatalagring d = new Datalagring();
	
	@EJB
	UtleigekontorEAO u;
	
    public logginnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		boolean innlogget = InnloggingUtil.isInnlogget(request);
		System.out.println();
		if (innlogget) {
			request.getRequestDispatcher("WEB-INF/jsp/bilsok.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("WEB-INF/jsp/logginn.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Få tak i brukernavn frå database
		// Få tak i passord frå database
		String mobNr = request.getParameter("mobil");
		String pin = request.getParameter("pin");
		
		String feilmeld = "Ugyldig brukernavn og/eller pin";
		String feilmeld1 = "Du må fylle ut både mobil og pin";
		boolean okPassord = false;
		okPassord = (pin.equals("12345"));
		Kunde kunde = k.hentKunde(mobNr);
//		List<String> utleigekontorNavn = u.hentAlleUtleiekontorSted();
		
		List<Adress>  alleKontor = u.alleAdress();
		
//		alleKontor.forEach(x -> System.out.println(x));
//		//utleigekontor.forEach(x -> System.out.println(x));
//		alleKontor.forEach(x -> System.out.println(x.getPoststed()));
		
//		System.out.println(kunde.getFornavn() + " " + kunde.getEtternavn());
//		System.out.println(pin);
//		List<String> utleigekontorNavn = u.hentAlleKontor().
		if (kunde != null) {
			
			if (mobNr == null || pin == "" || pin == "") {
				request.getSession().setAttribute("feilmeld", feilmeld1);
				response.sendRedirect("login");
			} else if (okPassord) {
				InnloggingUtil.loggInn(request);
				request.getSession().setAttribute("alleReservasjoner", d.hentAlleReservasjoner());
				request.getSession().setAttribute("alleKontor", alleKontor);
				request.getSession().setAttribute("username", mobNr);
				response.sendRedirect("meny");

			} else {
				request.getSession().setAttribute("feilmeld", feilmeld);
				response.sendRedirect("login");
			}

		}else {
			request.getSession().setAttribute("feilmeld", feilmeld + ", " + feilmeld1);
			response.sendRedirect("login");
		}
	}

}
