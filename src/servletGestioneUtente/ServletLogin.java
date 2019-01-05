package servletGestioneUtente;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import classiComuni.Studente;
import classiComuni.Tutor;
import gestioneDomanda.GestioneDomanda;
import gestioneDomanda.ImpGestioneDomanda;
import gestioneUtente.GestioneUtente;
import gestioneUtente.ImpGestioneUtente;



/**
 * La classe Login è una Servlet.
 * Questa classe permette all'utente di loggare alla propria pagina personale.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLogin() {}
	
	/**
	 * Il metodo serve per permettere all'utente di loggare alla sua pagina principale.
	 * @param request: contiene tutti i parametri passati nella richiesta tramite GET
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GestioneUtente u = new ImpGestioneUtente();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String tipo = request.getParameter("tipoUtente");
		HttpSession sessione = request.getSession();
		sessione.setAttribute("email", email);  
		sessione.setAttribute("tipo", tipo);		

		
		if(tipo.equals("Tutor")) {
				Tutor t = (Tutor) u.loginAccount(email, password, tipo);
				request.setAttribute("Nome",t.getNome());
				request.setAttribute("Cognome",t.getCognome());
				request.setAttribute("Immagine",t.getLinkImmagine());
				request.setAttribute("Materia",t.getMateriaDiCompetenza());
				request.setAttribute("Cellulare",t.getNumeroDiCellulare());
				request.setAttribute("Titolo",t.getTitoloDiStudio());
				request.setAttribute("Voto",t.getVotoDiLaurea());
				if(t.getEmail() != null) {	
					GestioneDomanda d = new ImpGestioneDomanda();
					boolean vis = d.risposteDaVisualizzare(email);
					if (vis == true) {sessione.setAttribute("vis", "si");}
					else {sessione.setAttribute("vis", "no");}
					RequestDispatcher view = request.getRequestDispatcher("jsp/Account.jsp");
					view.forward(request, response);
				}
			} else {
				Studente s = (Studente) u.loginAccount(email, password, tipo);
				request.setAttribute("Nome",s.getNome());
				request.setAttribute("Cognome",s.getCognome());
				request.setAttribute("Immagine",s.getLinkImmagine());
				request.setAttribute("Matricola",s.getMatricola());
				request.setAttribute("Anno",s.getAnnoCorso());
				if(s.getEmail() != null) {	
					GestioneDomanda d = new ImpGestioneDomanda();
					boolean vis = d.domandeDaVisualizzare(email);
					if (vis == true) {sessione.setAttribute("vis", "si");}
					else {sessione.setAttribute("vis", "no");}
					RequestDispatcher view = request.getRequestDispatcher("jsp/Account.jsp");
					view.forward(request, response);
				}
			}
		}			


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
