package servletGestioneInterazioneTutorStudente;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classiComuni.Domanda;
import classiComuni.Risposta;
import classiComuni.Studente;
import storage.FactoryDAO;
import storage.ObjectDAO;

/**
 * Servlet implementation class ServletVisualizzaValutazioniTot
 */
@WebServlet("/ServletVisualizzaValutazioniTot")
public class ServletVisualizzaValutazioniTot extends HttpServlet {

    public ServletVisualizzaValutazioniTot() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int like = 0;
		int dislike = 0;
		
		HttpSession session = request.getSession();
		String destinatario = (String) session.getAttribute("EmailUtente");
		
		FactoryDAO fd = new FactoryDAO();
		ObjectDAO o = fd.getObject("Risposta");
		List<Object> listR = o.recuperaTutto();
		
		for(int i = 0;i<listR.size();i++) {
		      Risposta r = (Risposta) listR.get(i);
		      if (r.getValutazione().equals("like")) {like++;}
		      else if (r.getValutazione().equals("dislike")) {dislike++;}
		}
		
		request.setAttribute("like", like);
		request.setAttribute("dislike", dislike);
		RequestDispatcher view = request.getRequestDispatcher("Valutazioni.html");
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
