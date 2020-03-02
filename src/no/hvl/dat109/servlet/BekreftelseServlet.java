package no.hvl.dat109.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat109.entities.Reservasjon;
import no.hvl.dat109.hjelpeklasser.InnloggingUtil;

/**
 * Servlet implementation class BekreftelseServlet
 */
@WebServlet("/bekreftelseServlet")
public class BekreftelseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BekreftelseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(InnloggingUtil.isInnlogget(request)) {
			request.getRequestDispatcher("WEB-INF/jsp/reservasjonsbekreftelse.jsp").forward(request, response);
			Reservasjon res = (Reservasjon) request.getSession().getAttribute("bekreftelse");
		}else {
			response.sendRedirect("login");
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
