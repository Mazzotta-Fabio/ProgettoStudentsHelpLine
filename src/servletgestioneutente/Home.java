package servletgestioneutente;
//file
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home.
 */

@WebServlet("/Home")
public class Home extends HttpServlet {
  private static final long serialVersionUID = 1L;
  /**
   * recupera le informazioni della home.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    response.sendRedirect("html/HomePage.html");
  }
  
  /**
  *richiama doGet.
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }
}