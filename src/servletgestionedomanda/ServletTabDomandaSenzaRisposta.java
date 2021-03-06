package servletgestionedomanda;

import gestionedomanda.GestioneDomanda;
import gestionedomanda.ImpGestioneDomanda;
import gestioneinterazionetutorstudente.GestioneInterazioneTutorStudente;
import gestioneinterazionetutorstudente.ImpGestioneInterazioneTutorStudente;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * La classe ServletTabDomandaSenzaRisposta � una Servlet.
 * Questa classe permette di visualizzare tutte le domande senza risposta in una tabella.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/ServletTabDomandaSenzaRisposta")
public class ServletTabDomandaSenzaRisposta extends HttpServlet {
  private static final long serialVersionUID = 1L;
  /**
   * Il metodo serve per recuperare tutte le domande senza risposta e inserire alcune 
   informazioni in una tabella da cui poterle selezionare.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    String email = (String) session.getAttribute("email");
    String tipo = (String) session.getAttribute("tipo");
    GestioneDomanda d = new ImpGestioneDomanda();
    List<String> listaDomande = d.recuperaDomandeSenzaRisposta(email);
    GestioneInterazioneTutorStudente d1 = new ImpGestioneInterazioneTutorStudente();
    boolean vis = d1.domandeDaVisualizzare(email,tipo);
    if (vis == true) {
      session.setAttribute("vis", "si");
    } else {
      session.setAttribute("vis", "no");
    }
    request.setAttribute("listaDomande", listaDomande);
    RequestDispatcher view = request.getRequestDispatcher("jsp/DomandenonRisposte.jsp");
    view.forward(request, response);
  }
  /**
   * Richiama doGet.
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
