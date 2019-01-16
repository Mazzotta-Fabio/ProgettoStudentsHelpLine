package servletgestioneutente;

import classicomuni.Studente;
import classicomuni.Tutor;
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
 * modifica dati account.
 * Servlet implementation class ServletFormModifica
 */
@WebServlet("/ServletFormModifica.html")
public class ServletFormModifica extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  public ServletFormModifica(){
  }

  /**
* richiede i dati.
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    GestioneUtente u = new ImpGestioneUtente();
    HttpSession session = request.getSession();
    String email = (String) session.getAttribute("email");
    String tipo = (String) session.getAttribute("tipo");
    if (tipo.equals("Tutor")) {
      Tutor t = (Tutor) u.infoAccount(email, tipo);
      request.setAttribute("Nome",t.getNome());
      request.setAttribute("Password",t.getPassword());
      request.setAttribute("Cognome",t.getCognome());
      request.setAttribute("Immagine",t.getLinkImmagine());
      request.setAttribute("Materia",t.getMateriaDiCompetenza());
      request.setAttribute("Cellulare",t.getNumeroDiCellulare());
      request.setAttribute("Titolo",t.getTitoloDiStudio());
      request.setAttribute("Voto",t.getVotoDiLaurea());
      RequestDispatcher view = request.getRequestDispatcher("jsp/ModificaAccount.jsp");
      view.forward(request, response);
    } else {
      Studente s = (Studente) u.infoAccount(email,tipo);
      request.setAttribute("Nome",s.getNome());
      request.setAttribute("Password",s.getPassword());
      request.setAttribute("Cognome",s.getCognome());
      request.setAttribute("Immagine",s.getLinkImmagine());
      request.setAttribute("Matricola",s.getMatricola());
      request.setAttribute("Anno",s.getAnnoCorso());
      RequestDispatcher view = request.getRequestDispatcher("jsp/ModificaAccount.jsp");
      view.forward(request, response);
    }
  }

  /**
*richiama doGet.
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }
}
