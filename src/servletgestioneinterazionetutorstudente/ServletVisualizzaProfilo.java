package servletgestioneinterazionetutorstudente;

import classicomuni.Studente;
import classicomuni.Tutor;
import gestioneinterazionetutorstudente.GestioneInterazioneTutorStudente;
import gestioneinterazionetutorstudente.ImpGestioneInterazioneTutorStudente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletVisualizzaProfilo.
 */
@WebServlet("/ServletVisualizzaProfilo")
public class ServletVisualizzaProfilo extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletVisualizzaProfilo() {}

  /**
   * Richiama i dati per visualizzare il profilo.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String email = request.getParameter("email");
    GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente(); 
    Object o = i.visualizzaAccount(email);
    if (o == null) {
      request.setAttribute("tipo", "nessuno");
    }
    else if (o instanceof Studente) {
      Studente s = (Studente) o;
      request.setAttribute("tipo", "Studente");
      request.setAttribute("Nome", s.getNome());
      request.setAttribute("Cognome", s.getCognome());
      request.setAttribute("email", s.getEmail());
      request.setAttribute("Immagine", s.getLinkImmagine());
      request.setAttribute("Matricola", s.getMatricola());
      request.setAttribute("Anno", s.getAnnoCorso());
      RequestDispatcher view = request.getRequestDispatcher("jsp/VisualizzaAccount.jsp");
      view.forward(request, response);
    }
    else {
      Tutor t = (Tutor) o;
      request.setAttribute("tipo", "Tutor");
      request.setAttribute("Nome", t.getNome());
      request.setAttribute("Cognome", t.getCognome());
      request.setAttribute("email", t.getEmail());
      request.setAttribute("Immagine", t.getLinkImmagine());
      request.setAttribute("Materia", t.getMateriaDiCompetenza());
      request.setAttribute("Cellulare", t.getNumeroDiCellulare());
      request.setAttribute("Titolo", t.getTitoloDiStudio());
      request.setAttribute("Voto", t.getVotoDiLaurea());
      RequestDispatcher view = request.getRequestDispatcher("jsp/VisualizzaAccount.jsp");
      view.forward(request, response);
    }
  }

  /**
     * richiama il metodo do get.
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }
}
