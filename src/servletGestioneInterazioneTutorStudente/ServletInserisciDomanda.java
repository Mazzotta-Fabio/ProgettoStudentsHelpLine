package servletGestioneInterazioneTutorStudente;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import gestioneInterazioneTutorStudente.GestioneInterazioneTutorStudente;
import gestioneInterazioneTutorStudente.ImpGestioneInterazioneTutorStudente;


/**
 * Servlet implementation class ServletInserisciDomanda
 */
@WebServlet("/ServletInserisciDomanda")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50) 
public class ServletInserisciDomanda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletInserisciDomanda() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part part = request.getPart("file");
		
		GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente();
	    String url = i.upload(part);
	    
	    String emailT = request.getParameter("tutor");
	    String oggetto = request.getParameter("oggetto");
	    String testo = request.getParameter("testo");
	    HttpSession session = request.getSession();
		String emailS = (String) session.getAttribute("EmailUtente");
		
		i.inserisciDomanda(oggetto,testo,url,emailT,emailS);
	    
	    RequestDispatcher view = request.getRequestDispatcher("Home.html");
		view.forward(request, response);
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
