package servletGestioneDomanda;

import java.io.IOException;
import java.util.List;
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
 * La classe ServletTabDomandaSenzaRisposta è una Servlet.
 * Questa classe permette di visualizzare tutte le domande senza risposta in una tabella.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/ServletTabDomandaSenzaRisposta")
public class ServletTabDomandaSenzaRisposta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletTabDomandaSenzaRisposta() {}

    /**
	 * Il metodo serve per recuperare tutte le domande senza risposta e inserire alcune informazioni in una tabella 
	 * da cui poterle selezionare.
	 * @param request: contiene tutti i parametri passati nella richiesta tramite GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		GestioneDomanda d = new ImpGestioneDomanda();
		List<String> listaDomande = d.recuperaDomandeSenzaRisposta(email);
		if (session.getAttribute("tipo").equals("Tutor")) {d.settaViste(email, "Tutor");}

		request.setAttribute("listaDomande", listaDomande);
		RequestDispatcher view = request.getRequestDispatcher("../jsp/DomandaRisposte.jsp");
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
