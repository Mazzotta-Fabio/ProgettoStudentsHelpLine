package servletgestioneutente;

import gestioneutente.GestioneUtente;
import gestioneutente.ImpGestioneUtente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * La classe RecuperaEmail � una Servlet.
 * Questa classe permette di inviare una mail ad un utente 
 * permettendogli di recuperare la propria password.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/RecuperaEmail.html")
public class ServletRecuperaEmail extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletRecuperaEmail() {}

  /**
* Il metodo serve per inviare la mail per recuperare la password.
* @param request contiene tutti i parametri passati nella richiesta tramite GET
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String destinatario = request.getParameter("email");
    String tipo = request.getParameter("tipoUtente");
    GestioneUtente g = new ImpGestioneUtente();
    String e = g.recuperaPassword(tipo, destinatario);
    if (e == null) {
      RequestDispatcher view = request.getRequestDispatcher("jsp/PaginaRecuperaPassword.jsp");
      view.forward(request, response);
    } else {
      response.sendRedirect("html/HomePage.html");
    }
  }

  /**
* richiama DoGet.
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }
}
