package servletGestioneDomanda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classiComuni.Domanda;
import classiComuni.Risposta;
import classiComuni.Studente;
import storage.FactoryDAO;
import storage.ObjectDAO;

/**
 * Servlet implementation class ServletTabDomandaRisposte
 */
@WebServlet("/ServletTabDomandaRisposte")
public class ServletTabDomandaRisposte extends HttpServlet {

    public ServletTabDomandaRisposte() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		FactoryDAO fd = new FactoryDAO();
		ObjectDAO o = fd.getObject("Domanda");
		ArrayList<Object> listaD = o.recuperaTutto();
				
		List<String> listaDomande = new ArrayList<String>();
		for(int i = 0;i<listaD.size();i++) {
		      Domanda d = (Domanda) listaD.get(i);
		      o = fd.getObject("Risposta");
		      Risposta r = new Risposta(0, null, null, null, d);
		      o.recuperaDati(r);
		      if (r.getTesto() != null) {
		    	  listaDomande.add(String.valueOf(d.getId()));
		    	  listaDomande.add(d.getOggetto());
		    	  listaDomande.add(d.getTesto());
		    	  o = fd.getObject("Studente");
		    	  Studente s = d.getStudente();
		    	  o.recuperaDati(s);
		    	  listaDomande.add(s.getNome());
		    	  listaDomande.add(s.getCognome());
		      }
		}
		
		request.setAttribute("listaDomande", listaDomande);
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