package no.hvl.dat109.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.IF.PersistenceDatalagring;
import no.hvl.dat109.eao.BiltypeEAO;
import no.hvl.dat109.eao.UtleigekontorEAO;
import no.hvl.dat109.entities.Adress;
import no.hvl.dat109.entities.Bil;
import no.hvl.dat109.entities.Biltype;
import no.hvl.dat109.entities.Utleigekontor;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;

/**
 * Servlet implementation class LeggTilBilServlet
 */
@WebServlet("/leggtilbil")
public class LeggTilBilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	PersistenceDatalagring d;
	
	@EJB
	UtleigekontorEAO u;
	
	@EJB
	BiltypeEAO bt;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeggTilBilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(InnloggingUtil.isInnloggetAdmin(request)){
			List<Adress> allekontor = (List<Adress>) request.getSession().getAttribute("alleKontor");
			request.getRequestDispatcher("WEB-INF/jsp/leggTilBil.jsp").forward(request, response);
		}else {

			response.sendRedirect("meny");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int valgtKontorId = Integer.parseInt(request.getParameter("kontorValgForBil"));
		Utleigekontor valgtKontor = u.hentUtleigeKontor(valgtKontorId);
		
		String valgtKategoriId = request.getParameter("kategori");
		Biltype valgtKategori =	bt.hentBiltype(valgtKategoriId);
		
		String merke = request.getParameter("merke");
		String farge = request.getParameter("farge");
		String regnr = request.getParameter("regnr");
		
		Bil nyBil = new Bil(regnr, valgtKategori, valgtKontor, merke, farge);
		
		request.getSession().setAttribute("nyBil", d.lagreBil(nyBil));
		response.sendRedirect("leggtilbilbekreftelse");
		

	}

}
