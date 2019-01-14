package servletgestionedomanda;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletFormRisposta.
 */
@WebServlet("/ServletFormRisposta")
public class ServletFormRisposta extends HttpServlet {
  private static final long serialVersionUID = 1L;
  /**
     * Costruisce il form della risposta.
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String id = (String) request.getParameter("IdDomanda");
    request.setAttribute("id", id);
    RequestDispatcher view = request.getRequestDispatcher("jsp/SezioneRisposta.jsp");
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
