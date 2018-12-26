package servletGestioneUtente;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import classiComuni.Studente;
import classiComuni.Tutor;
import storage.FactoryDAO;
import storage.ObjectDAO;


/**
 * La classe Login è una Servlet.
 * Questa classe permette all'utente di loggare alla propria pagina personale.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/Login.html")
public class ServletLogin extends HttpServlet {
	     
    public ServletLogin() {}
	
	/**
	 * Il metodo serve per permettere all'utente di loggare alla sua pagina principale.
	 * @param request: contiene tutti i parametri passati nella richiesta tramite GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String tipo = request.getParameter("tipoUtente");
		boolean accesso = false;
		
		if(tipo.equals("tutor")) {
				Tutor t = new Tutor(null, null,email, password, null, null, null, null, null);
				FactoryDAO fDAO = new FactoryDAO();
			    ObjectDAO o = fDAO.getObject("Tutor");
				accesso = o.recuperaDati(t);
			} else {
				Studente s = new Studente(null, null,email,password, null, null, null);
				FactoryDAO fDAO = new FactoryDAO();
			    ObjectDAO o = fDAO.getObject("Studente");
				accesso = o.recuperaDati(s);
		}

		if(accesso == true) {
			HttpSession sessione = request.getSession();
			sessione.setAttribute("email", email);  
			sessione.setAttribute("tipo", tipo);
			RequestDispatcher view = request.getRequestDispatcher("PaginaPrincipale.html");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("Home.html");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
