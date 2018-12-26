package servletGestioneDomanda;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classiComuni.Domanda;
import classiComuni.Risposta;
import classiComuni.Studente;
import classiComuni.Tutor;
import storage.FactoryDAO;
import storage.ObjectDAO;

/**
 * La classe ServletVisualizzaDomanda è una Servlet.
 * Questa classe permette di visualizzare la domanda,e relativa risposta, 
 * in una pagina con tutte le sue relative informazioni.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/ServletVisualizzaDomanda")
public class ServletVisualizzaDomanda extends HttpServlet {

    public ServletVisualizzaDomanda() {}

  	/**
	 * Il metodo serve per recuperare i dati della Domanda e passarli alla pagina VisualizzaDomanda.html.
	 * @param request: contiene tutti i parametri passati nella richiesta tramite GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ID = Integer.parseInt(request.getParameter("id"));
		FactoryDAO fd = new FactoryDAO();
		
		Domanda d = new Domanda (ID, null, null, null, null);	
		ObjectDAO o = fd.getObject("Domanda");
		o.recuperaDati(d);
		request.setAttribute("AllegatoD",d.getAllegato());
		request.setAttribute("OggettoD",d.getOggetto());
		request.setAttribute("TestoD",d.getTesto());
		
		Studente s = d.getStudente(); 
		o = fd.getObject("Studente");
		o.recuperaDati(s);
		request.setAttribute("NomeS",d.getStudente().getNome());
		request.setAttribute("CognomeS",d.getStudente().getCognome());
		request.setAttribute("EmailS",d.getStudente().getEmail());
 
		Risposta r = new Risposta(0, null, null, null, d); 
		o = fd.getObject("Risposta");
		o.recuperaDati(r);
		if(r.getTesto()!=null) {
			
			request.setAttribute("TestoR",r.getTesto());
			request.setAttribute("AllegatoR",r.getAllegato());
			request.setAttribute("ValutazioneR",r.getValutazione());
		
			Tutor t = r.getTutor(); 
			o = fd.getObject("Tutor");
			o.recuperaDati(t);
			request.setAttribute("NomeT",t.getNome());
			request.setAttribute("CognomeT",t.getCognome());
			request.setAttribute("EmailT",t.getEmail());
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
