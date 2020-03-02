package no.hvl.dat109.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.IF.PersistenceDatalagring;
import no.hvl.dat109.eao.BilEAO;
import no.hvl.dat109.eao.KundeEAO;
import no.hvl.dat109.eao.ReservasjonEAO;
import no.hvl.dat109.eao.UtleigekontorEAO;
import no.hvl.dat109.entities.Bil;
import no.hvl.dat109.entities.Kunde;
import no.hvl.dat109.entities.Reservasjon;
import no.hvl.dat109.entities.Utleigekontor;
import no.hvl.dat109.hjelpeklasser.Datalagring;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;

/**
 * Servlet implementation class BilValgServlet
 */
@WebServlet("/bilvalg")
public class BilValgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@EJB
	BilEAO b;
	
	@EJB
	KundeEAO k;
	
	@EJB
	PersistenceDatalagring d;
	
	@EJB
	ReservasjonEAO r;
	
	@EJB
	UtleigekontorEAO u;
	
    public BilValgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (InnloggingUtil.isInnlogget(request)) {
			request.getRequestDispatcher("WEB-INF/jsp/bilvalg.jsp").forward(request, response);
			List<Bil> eee = (List<Bil>) request.getSession().getAttribute("alleLedigeBiler");
		}else {
			response.sendRedirect("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String valgtRegnr = request.getParameter("bilValg");
		Bil valgtBil = b.hentBil(valgtRegnr);
		Kunde kunde = k.hentKunde((String) request.getSession().getAttribute("username"));
		Utleigekontor henteKontor = (Utleigekontor) request.getSession().getAttribute("kontorHenting");
		Utleigekontor LevereKontor = (Utleigekontor) request.getSession().getAttribute("kontorLevering");
		Timestamp fraTid = (Timestamp) request.getSession().getAttribute("fraTid");
		System.out.println("Fra tid: " + fraTid.toString());
		Timestamp tilTid = (Timestamp) request.getSession().getAttribute("tilTid");
		System.out.println("Til tid: " + tilTid.toString());
		Reservasjon nyReservasjon = new Reservasjon();
		
		nyReservasjon.setKundeBean(kunde);
		nyReservasjon.setBilBean(valgtBil);
		nyReservasjon.setFradato(fraTid);
		nyReservasjon.setTildato(tilTid);
		nyReservasjon.setUtleigekontor1(henteKontor);
		nyReservasjon.setUtleigekontor2(LevereKontor);
		
		System.out.println(nyReservasjon.toString());
		
		request.getSession().setAttribute("reservasjon", d.lagreReservasjon(nyReservasjon));
		response.sendRedirect("bekreftelseServlet");
		
		
	}

}
