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

/**
 * Servlet implementation class ServletValutaRisposta.
 */
@WebServlet("/ServletValutaRisposta")
public class ServletValutaRisposta extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  public ServletValutaRisposta() {}

  /**
   * il metodo doGet richiama i dati per valutare la risposta.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int idD = Integer.parseInt(request.getParameter("idD"));
    int idR = Integer.parseInt(request.getParameter("idR"));
    String valutazione = request.getParameter("valutazione");
    GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente();
    i.valutaRisposta(idR, valutazione);
    RequestDispatcher forward = request.getServletContext().getRequestDispatcher(
        "/ServletVisualizzaDomanda?id=" + idD);
    forward.forward(request, response);
  }

  /**
    * il metodo richiama doGet.
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
  
  @Override
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doGet(request, response);
  }
}
