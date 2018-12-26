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
 * La classe EliminaAccount è una Servlet.
 * Questa classe permette di eliminare il prorpio account, quindi cancellare le informazione registrate sul DataBase00.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/EliminaAccount.html")
public class ServletEliminaAccount extends HttpServlet {

    public ServletEliminaAccount() {}

    /**
	 * Il metodo serve per eliminare le informazioni del proprio account dal database.
	 * @param request: contiene tutti i parametri passati nella richiesta tramite GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String destinatario = (String) session.getAttribute("EmailUtente");
		String tipo = (String) session.getAttribute("TipoUtente");
		
		if(tipo.equals("tutor")) {
			Tutor t = new Tutor(null, null,destinatario, null, null, null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
		    ObjectDAO o = fDAO.getObject("Tutor");
			o.cancellaDati(t);
		} else {
			Studente s = new Studente(null, null,destinatario,null, null, null, null);
			FactoryDAO fDAO = new FactoryDAO();
		    ObjectDAO o = fDAO.getObject("Tutor");
			o.cancellaDati(s);
		}
		
		RequestDispatcher view = request.getRequestDispatcher("Home.html");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
