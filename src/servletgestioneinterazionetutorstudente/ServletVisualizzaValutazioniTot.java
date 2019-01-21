package servletgestioneinterazionetutorstudente;

import gestioneinterazionetutorstudente.GestioneInterazioneTutorStudente;
import gestioneinterazionetutorstudente.ImpGestioneInterazioneTutorStudente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletVisualizzaValutazioniTot.
 */
@WebServlet("/ServletVisualizzaValutazioniTot")
public class ServletVisualizzaValutazioniTot extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletVisualizzaValutazioniTot() {}

  /**
  * il metodo doGet richiama i dati per visualizzare le valutazioni totali.
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    String email = (String) session.getAttribute("email");
    String tipo = (String) session.getAttribute("tipo");
    GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente();
    int [] voti = i.valutazioniTot(email);
    request.setAttribute("like", voti[0]);
    request.setAttribute("dislike", voti[1]);
    GestioneInterazioneTutorStudente d = new ImpGestioneInterazioneTutorStudente();
    boolean vis = d.domandeDaVisualizzare(email,tipo);
    if (vis == true) {
      session.setAttribute("vis", "no");
    }
    else {
      session.setAttribute("vis", "si");
    }
    RequestDispatcher view = request.getRequestDispatcher("jsp/ValutazioniTot.jsp");
    view.forward(request, response);
  }

  /**
 * ilo metodo richiama doGet.
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }
}
