package servletGestioneUtente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * La classe Logout è una Servlet.
 * Questa classe permette all'utente di effettuare il logout dal sito.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/Logout.html")
public class ServletLogout extends HttpServlet {

    public ServletLogout() {}

    /**
	 * Il metodo serve per permettere all'utente di effettuare il logout dal sito.
	 * @param request: contiene tutti i parametri passati nella richiesta tramite GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getSession().invalidate();
	    response.sendRedirect("Home.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
