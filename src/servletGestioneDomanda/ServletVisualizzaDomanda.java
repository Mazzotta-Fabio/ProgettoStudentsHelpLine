package servletGestioneDomanda;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gestioneDomanda.GestioneDomanda;
import gestioneDomanda.ImpGestioneDomanda;


/**
 * La classe ServletVisualizzaDomanda è una Servlet.
 * Questa classe permette di visualizzare la domanda,e relativa risposta, 
 * in una pagina con tutte le sue relative informazioni.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/ServletVisualizzaDomanda")
public class ServletVisualizzaDomanda extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletVisualizzaDomanda() {}

  	/**
	 * Il metodo serve per recuperare i dati della Domanda e passarli alla pagina VisualizzaDomanda.html.
	 * @param request: contiene tutti i parametri passati nella richiesta tramite GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessione = request.getSession();
		String tipo = (String) sessione.getAttribute("tipo");
		int ID = Integer.parseInt(request.getParameter("id"));
		GestioneDomanda d = new ImpGestioneDomanda();
		ArrayList<String> listaInfo = d.visualizzaDomanda(ID,tipo);
		request.setAttribute("listaInfo", listaInfo);
		if(listaInfo.get(9).equals("1")) {
			RequestDispatcher view = request.getRequestDispatcher("jsp/VisualizzaDomandaSenzaRisposta.jsp");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("jsp/VisualizzaDomandaConRisposta.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
