package no.hvl.dat109.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.IF.PersistenceDatalagring;
import no.hvl.dat109.entities.Kunde;
import no.hvl.dat109.entities.Reservasjon;
import no.hvl.dat109.hjelpeklasser.Datalagring;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;

/**
 * Servlet implementation class utleigeServlet
 */
@WebServlet("/utleige")
public class utleigeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	PersistenceDatalagring d = new Datalagring();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public utleigeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(InnloggingUtil.isInnloggetAdmin(request)) {
			request.getSession().getAttribute("alleReservasjoner");
			request.getRequestDispatcher("WEB-INF/jsp/utleige.jsp").forward(request, response);
		}else {
			response.sendRedirect("meny");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int valgtReservasjonId = Integer.parseInt(request.getParameter("resValg"));
		Reservasjon valgtReservasjon = d.hentReservasjon(valgtReservasjonId);
		int kmstand = Integer.parseInt(request.getParameter("kmstand"));
//		valgtReservasjon.setKmstandinn(kmstand);
		
		String krednr = request.getParameter("krednr");
		String nummer = (String) request.getSession().getAttribute("username");

//		Kunde aktivKunde = d.hentKunde(nummer);
//		aktivKunde.setKredittkort(krednr);
		d.oppdaterKundeKredNr(nummer, krednr);
		
		d.oppdaterKmstandut(valgtReservasjonId, kmstand);
		request.getSession().setAttribute("resValg", valgtReservasjon);
		request.getSession().setAttribute("kmstand", kmstand);
		response.sendRedirect("utleigebekreftelse");
		
	}

}
