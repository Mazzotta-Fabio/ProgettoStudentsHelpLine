package servletGestioneInterazioneTutorStudente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classiComuni.Studente;
import classiComuni.Tutor;
import gestioneInterazioneTutorStudente.GestioneInterazioneTutorStudente;
import gestioneInterazioneTutorStudente.ImpGestioneInterazioneTutorStudente;

/**
 * Servlet implementation class ServletVisualizzaProfilo
 */
@WebServlet("/ServletVisualizzaProfilo")
public class ServletVisualizzaProfilo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletVisualizzaProfilo() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		
		GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente();
		Object o = i.visualizzaAccount(email);
		if (o == null) {request.setAttribute("tipo", "nessuno");}
		else if (o instanceof Studente) {
			Studente s = (Studente) o;
			request.setAttribute("tipo", "studente");
			request.setAttribute("nome", s.getNome());
			request.setAttribute("cognome", s.getCognome());
			request.setAttribute("email", s.getEmail());
			request.setAttribute("immagine", s.getLinkImmagine());
			request.setAttribute("matricola", s.getMatricola());
			request.setAttribute("anno", s.getAnnoCorso());
		} else {
			Tutor t = (Tutor) o;
			request.setAttribute("tipo", "tutor");
			request.setAttribute("nome", t.getNome());
			request.setAttribute("cognome", t.getCognome());
			request.setAttribute("email", t.getEmail());
			request.setAttribute("immagine", t.getLinkImmagine());
			request.setAttribute("materia", t.getMateriaDiCompetenza());
			request.setAttribute("numero", t.getNumeroDiCellulare());
			request.setAttribute("titolo", t.getTitoloDiStudio());
			request.setAttribute("voto", t.getVotoDiLaurea());
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
