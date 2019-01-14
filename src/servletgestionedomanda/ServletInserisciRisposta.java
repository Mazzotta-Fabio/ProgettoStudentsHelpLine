package servletgestionedomanda;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import gestioneinterazionetutorstudente.GestioneInterazioneTutorStudente;
import gestioneinterazionetutorstudente.ImpGestioneInterazioneTutorStudente;

/**
 * Servlet implementation class ServletInserisciRisposta.
 */
@WebServlet("/ServletInserisciRisposta.html")
public class ServletInserisciRisposta extends HttpServlet {
  private static final long serialVersionUID = 1L;     
  /**
   * Inserisce la risposta e ritorna al mioAccount.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente();
    String url = request.getParameter("url");
    i.upload(url);
    int idDomanda = Integer.parseInt(request.getParameter("id"));
    String testo = request.getParameter("testo");
    GestioneInterazioneTutorStudente d = new ImpGestioneInterazioneTutorStudente();
    d.inserisciRisposta(testo, idDomanda, url);
    HttpSession session = request.getSession();
    String email = (String) session.getAttribute("email");
    String pass = (String) session.getAttribute("pass");
    String tipo = (String) session.getAttribute("tipo");
    RequestDispatcher forward = request.getServletContext().getRequestDispatcher("/Login?email="
        + "" + email + "&password=" + pass + "&tipoUtente=" + tipo);
    forward.forward(request, response);
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
