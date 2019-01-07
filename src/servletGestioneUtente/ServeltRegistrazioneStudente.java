package servletGestioneUtente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import gestioneUtente.GestioneUtente;
import gestioneUtente.ImpGestioneUtente;

/**
 * La classe RegistrazioneStudente è una Servlet.
 * Questa classe permette di recuperare i dati dello Studente dalla pagina Registrazione.html e passarli al DAO
 * per farli inserire nel DataBase.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/RegistrazioneStudente.html")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50) 
public class ServeltRegistrazioneStudente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServeltRegistrazioneStudente() {}

   	/**
	 * Il metodo serve per recuperare i dati dello Studente e passarli alla classi DAO per inserirli nel DataBase.
	 * @param request: contiene tutti i parametri passati nella richiesta tramite GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo = request.getParameter("tipo");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Part linkImmagine = request.getPart("immagine");
		String matricola = request.getParameter("matricola");
		String annoCorso = request.getParameter("annoCorso");
		
		GestioneUtente u = new ImpGestioneUtente();
		u.registraAccount(tipo,nome, cognome, email, password, linkImmagine, matricola, annoCorso,null,null);
		
	     
		RequestDispatcher view = request.getRequestDispatcher("html/HomePage.html");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
