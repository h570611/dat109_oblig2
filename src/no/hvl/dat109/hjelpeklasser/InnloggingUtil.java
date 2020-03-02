package no.hvl.dat109.hjelpeklasser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class InnloggingUtil {
	public static boolean isGyldigPassord(String passord, String korrektPassord) {
		return passord != null && passord.equals(korrektPassord);
	}

	public static boolean isInnlogget(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return (session != null) && (session.getAttribute("innlogget") != null);
	}

	public static void loggInn(HttpServletRequest request) {
		loggUt(request);
		HttpSession sesjon = request.getSession(true);
		
		sesjon.setAttribute("innlogget", "JEPP");
	}
	
	public static boolean isInnloggetAdmin(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if((session != null) && (session.getAttribute("innlogget") != null) && session.getAttribute("username").equals("81548300")) {
			return true;
		}else {
			return false;
		}
		
	}

	public static void loggUt(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

}
