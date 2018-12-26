package servletGestioneUtente;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classiComuni.Studente;
import storage.FactoryDAO;
import storage.ObjectDAO;

/**
 * La classe RegistrazioneStudente è una Servlet.
 * Questa classe permette di recuperare i dati dello Studente dalla pagina Registrazione.html e passarli al DAO
 * per farli inserire nel DataBase.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/RegistrazioneStudente.html")
public class ServeltRegistrazioneStudente extends HttpServlet {
    
    public ServeltRegistrazioneStudente() {}

   	/**
	 * Il metodo serve per recuperare i dati dello Studente e passarli alla classi DAO per inserirli nel DataBase.
	 * @param request: contiene tutti i parametri passati nella richiesta tramite GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String linkImmagine = request.getParameter("immagine");
		String matricola = request.getParameter("matricola");
		String annoCorso = request.getParameter("annocorso");
		
		Studente s = new Studente(nome,cognome,email,password,linkImmagine,matricola,annoCorso);
		
		FactoryDAO fDAO = new FactoryDAO();
	    ObjectDAO o = fDAO.getObject("Studente");
		o.inserisciDati(s);
		
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
