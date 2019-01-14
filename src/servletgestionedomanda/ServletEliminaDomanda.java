package servletgestionedomanda;

import gestionedomanda.GestioneDomanda;

import gestionedomanda.ImpGestioneDomanda;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * La classe ServletEliminaDomanda è una Servlet.
 * Questa classe permette di eliminare la domanda che corrisponde all'ID.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/ServletEliminaDomanda")
public class ServletEliminaDomanda extends HttpServlet {
  private static final long serialVersionUID = 1L;
  /**
   * Il metodo serve per eliminare una domanda sul DataBase.
   * @param request contiene tutti i parametri passati nella richiesta tramite GET
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    GestioneDomanda d = new ImpGestioneDomanda();
    d.eliminaDomanda(id);
    HttpSession session = request.getSession();
    String email = (String) session.getAttribute("email");
    String pass = (String) session.getAttribute("pass");
    String tipo = (String) session.getAttribute("tipo");
    RequestDispatcher forward = request.getServletContext().getRequestDispatcher("/Login?email="
        + "" + email + "&password=" + pass + "&tipoUtente=" + tipo);
    forward.forward(request, response);
  }
  /**
   * Il metodo richiama doGet.
   * @param request contiene tutti i parametri passati nella richiesta tramite GET
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }
}
