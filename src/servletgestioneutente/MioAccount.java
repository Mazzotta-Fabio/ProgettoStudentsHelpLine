package servletgestioneutente;

import classicomuni.Studente;
import classicomuni.Tutor;
import gestioneinterazionetutorstudente.GestioneInterazioneTutorStudente;
import gestioneinterazionetutorstudente.ImpGestioneInterazioneTutorStudente;
import gestioneutente.GestioneUtente;
import gestioneutente.ImpGestioneUtente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
  * porta  all'account dell'utente. 
  * Servlet implementation class ServletVisualizzaProfilo
  */

@WebServlet("/MioAccount")
public class MioAccount extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public MioAccount() {}

  /**
  * recupera le informazioni dell'account.
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    GestioneUtente u = new ImpGestioneUtente();
    HttpSession sessione = request.getSession();
    String tipo = (String) sessione.getAttribute("tipo");
    String email = (String) sessione.getAttribute("email");
    String password = (String) sessione.getAttribute("pass");
    if (tipo.equals("Tutor")) {
      Tutor t = (Tutor) u.loginAccount(email, password, tipo);
      request.setAttribute("Nome",t.getNome());
      request.setAttribute("Cognome",t.getCognome());
      request.setAttribute("Immagine",t.getLinkImmagine());
      request.setAttribute("Materia",t.getMateriaDiCompetenza());
      request.setAttribute("Cellulare",t.getNumeroDiCellulare());
      request.setAttribute("Titolo",t.getTitoloDiStudio());
      request.setAttribute("Voto",t.getVotoDiLaurea());
      if (t.getEmail() != null) {
    	  GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente();
    	    boolean vis = i.domandeDaVisualizzare(email,tipo);
    	    if (vis == true) {
    	      sessione.setAttribute("vis", "si");
    	    } else {
    	      sessione.setAttribute("vis", "no");
    	    }
        request.setAttribute("Verifica","no");
        RequestDispatcher view = request.getRequestDispatcher("jsp/Account.jsp");
        view.forward(request, response);
      } else {
        RequestDispatcher view = request.getRequestDispatcher("jsp/PaginaLogin.jsp");
        view.forward(request, response);
      }
    } else {
      Studente s = (Studente) u.loginAccount(email, password, tipo);
      request.setAttribute("Nome",s.getNome());
      request.setAttribute("Cognome",s.getCognome());
      request.setAttribute("Immagine",s.getLinkImmagine());
      request.setAttribute("Matricola",s.getMatricola());
      request.setAttribute("Anno",s.getAnnoCorso());
      if (s.getEmail() != null) {
        GestioneInterazioneTutorStudente d = new ImpGestioneInterazioneTutorStudente();
        boolean vis = d.domandeDaVisualizzare(email,tipo);
        if (vis == true) {
          sessione.setAttribute("vis", "si");
        } else {
          sessione.setAttribute("vis", "no");
        }
        RequestDispatcher view = request.getRequestDispatcher("jsp/Account.jsp");
        view.forward(request, response);
      } else {
        RequestDispatcher view = request.getRequestDispatcher("jsp/PaginaLogin.jsp");
        view.forward(request, response);
      }
    }
  }

  /**
  * richiama il doGet.
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }
}