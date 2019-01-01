package servletGestioneInterazioneTutorStudente;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import gestioneInterazioneTutorStudente.GestioneInterazioneTutorStudente;
import gestioneInterazioneTutorStudente.ImpGestioneInterazioneTutorStudente;

/**
 * Servlet implementation class ServletVisualizzaValutazioniTot
 */
@WebServlet("/ServletVisualizzaValutazioniTot")
public class ServletVisualizzaValutazioniTot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletVisualizzaValutazioniTot() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("EmailUtente");
		
		GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente();
		int [] voti = i.valutazioniTot(email);
		
		request.setAttribute("like", voti[0]);
		request.setAttribute("dislike", voti[1]);
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
