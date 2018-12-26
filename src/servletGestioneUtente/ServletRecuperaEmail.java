package servletGestioneUtente;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classiComuni.Studente;
import classiComuni.Tutor;
import gestioneUtente.GestioneUtente;
import gestioneUtente.ImpGestioneUtente;
import storage.FactoryDAO;
import storage.ObjectDAO;


/**
 * La classe RecuperaEmail è una Servlet.
 * Questa classe permette di inviare una mail ad un utente permettendogli di recuperare la propria password.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/RecuperaEmail.html")
public class ServletRecuperaEmail extends HttpServlet {
	     
    public ServletRecuperaEmail() {}
	
	/**
	 * Il metodo serve per inviare la mail per recuperare la password.
	 * @param request: contiene tutti i parametri passati nella richiesta tramite GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String destinatario = request.getParameter("email");
		String tipo = request.getParameter("tipoUtente");
		String password = null;
		
		if(tipo.equals("tutor")) {
			Tutor t = new Tutor(null, null,destinatario, null, null, null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
		    ObjectDAO o = fDAO.getObject("Tutor");
			o.recuperaDati(t);
			password = t.getPassword();
		} else {
			Studente s = new Studente(null, null,destinatario,null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
		    ObjectDAO o = fDAO.getObject("Studente");
			o.recuperaDati(s);
			password = s.getPassword();
		}
		
		GestioneUtente g = new ImpGestioneUtente();
		g.recuperaPassword(password, destinatario);
	   
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
