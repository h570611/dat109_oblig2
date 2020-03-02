package no.hvl.dat109.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.IF.PersistenceDatalagring;
import no.hvl.dat109.entities.Adress;
import no.hvl.dat109.entities.Utleigekontor;
import no.hvl.dat109.hjelpeklasser.Datalagring;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;

/**
 * Servlet implementation class LeggTilUtleigekontorServlet
 */
@WebServlet("/leggtilutleigekontor")
public class LeggTilUtleigekontorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	PersistenceDatalagring d = new Datalagring();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeggTilUtleigekontorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(InnloggingUtil.isInnloggetAdmin(request)) {
			request.getRequestDispatcher("WEB-INF/jsp/leggTilUtleigekontor.jsp").forward(request, response);
		}else {
			response.sendRedirect("meny");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tlf = request.getParameter("telefonnummer");
		String gateadresse = request.getParameter("gateadresse");
		String poststed = request.getParameter("poststed");
		String postnummer = request.getParameter("postkode");
		
		List<Integer> UtleigeKontorId = d.hentAlleUtleigekontorId();
		Optional<Integer> maks = UtleigeKontorId.stream()
				.max((i,j) -> i.compareTo(j));
		
		int nyKontorId = maks.get() +1 ;
		
		
		List<Integer> AdressId = d.hentAlleAdressId();
		Optional<Integer> maksAdress = AdressId.stream()
				.max((i,j) -> i.compareTo(j));
		
		int nyAdressId = maksAdress.get() + 1;
		
		Adress nyAdress = new Adress(nyAdressId, gateadresse, postnummer, poststed);
		
		Utleigekontor nyUtleigekontor = new Utleigekontor(nyKontorId, tlf, d.lagreAdress(nyAdress));
		
		request.getSession().setAttribute("nyUtleigekontor", d.lagreUtleigekontor(nyUtleigekontor));
		
		response.sendRedirect("leggtilutleigekontorbekreftelse");
		
	}

}
