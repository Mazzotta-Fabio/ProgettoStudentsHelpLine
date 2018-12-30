package servletGestioneInterazioneTutorStudente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classiComuni.Domanda;
import classiComuni.Risposta;
import storage.FactoryDAO;
import storage.ObjectDAO;

/**
 * Servlet implementation class ServletValutaRisposta
 */
@WebServlet("/ServletValutaRisposta")
public class ServletValutaRisposta extends HttpServlet {
    public ServletValutaRisposta() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ID = Integer.parseInt(request.getParameter("ID"));
		String valutazione = request.getParameter("valutazione");
		
		Domanda d = new Domanda (ID, null, null, null, null);
		Risposta r = new Risposta(0,null,null, null, d);
		
		FactoryDAO fd = new FactoryDAO();
		ObjectDAO o = fd.getObject("Risposta");
		o.recuperaDati(r);
		o.cancellaDati(r);
		r.setValutazione(valutazione);
		o.inserisciDati(r);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
