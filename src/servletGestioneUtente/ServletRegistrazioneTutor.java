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
import storage.FactoryDAO;
import storage.ObjectDAO;

/**
 * La classe RegistrazioneTutor è una Servlet.
 * Questa classe permette di recuperare i dati del Tutor dalla pagina Registrazione.html e passarli al DAO
 * per farli inserire nel DataBase.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/RegistrazioneTutor.html")
public class ServletRegistrazioneTutor extends HttpServlet {
    
    public ServletRegistrazioneTutor() {}

   	/**
	 * Il metodo serve per recuperare i dati del Tutor e passarli alla classi DAO per inserirli nel DataBase.
	 * @param request: contiene tutti i parametri passati nella richiesta tramite GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String linkImmagine = request.getParameter("immagine");
		String numero = request.getParameter("numero");
		String materia = request.getParameter("materia");
		String voto = request.getParameter("voto");
		String titolo = request.getParameter("titolo");
		
		Tutor t = new Tutor(nome,cognome,email,password,linkImmagine,numero,materia,voto,titolo);
		
		FactoryDAO fDAO = new FactoryDAO();
	    ObjectDAO o = fDAO.getObject("Tutor");
		o.inserisciDati(t);
		
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
