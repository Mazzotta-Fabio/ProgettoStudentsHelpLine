package servletGestioneUtente;

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
import gestioneUtente.GestioneUtente;
import gestioneUtente.ImpGestioneUtente;


/**
 * La classe ModificaStudente è una Servlet.
 * Questa classe permette di modificare i dati dello Studente tramite DAO su DataBase.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/ModificaStudente.html")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50)
public class ServletModificaStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletModificaStudente() {}

   	/**
	 * Il metodo serve per recuperare i dati dello Studente e passarli alla classi DAO per modificarli sul DataBase.
	 * @param request: contiene tutti i parametri passati nella richiesta tramite GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String tipo = (String) session.getAttribute("tipo");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = (String) session.getAttribute("email");
		String password = request.getParameter("password");
		String matricola = request.getParameter("matricola");
		String annoCorso = request.getParameter("annocorso");
		System.out.print(annoCorso);
		
		GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente();
	    String url = request.getParameter("url");
	    i.upload(url);
		
		GestioneUtente u = new ImpGestioneUtente();
		u.modificaAccount(tipo, nome, cognome, email, password, url, matricola, annoCorso,null, null);
		
		RequestDispatcher forward = request.getServletContext().getRequestDispatcher("/Login?email="+email+"&password="+password+"&tipoUtente="+tipo);
		forward.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
