package no.hvl.dat109.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.entities.Bil;
import no.hvl.dat109.entities.Utleigekontor;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;

/**
 * Servlet implementation class LeggTilUtleigekontorBekreftelseServlet
 */
@WebServlet("/leggtilutleigekontorbekreftelse")
public class LeggTilUtleigekontorBekreftelseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeggTilUtleigekontorBekreftelseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(InnloggingUtil.isInnloggetAdmin(request)) {
			Utleigekontor sjekk = (Utleigekontor) request.getSession().getAttribute("nyUtleigekontor");
			request.getRequestDispatcher("WEB-INF/jsp/leggtilutleigekontorbekreftelse.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
