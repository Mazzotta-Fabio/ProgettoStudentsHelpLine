package servletGestioneUtente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import gestioneUtente.GestioneUtente;
import gestioneUtente.ImpGestioneUtente;

/**
 * La classe EliminaAccount è una Servlet.
 * Questa classe permette di eliminare il prorpio account, quindi cancellare le informazione registrate sul DataBase00.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/EliminaAccount")
public class ServletEliminaAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		
		GestioneUtente u = new ImpGestioneUtente();
		u.eliminaAccount(destinatario, tipo);
		
		/*RequestDispatcher view = request.getRequestDispatcher("Home.html");
		view.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
