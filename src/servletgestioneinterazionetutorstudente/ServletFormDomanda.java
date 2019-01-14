package servletgestioneinterazionetutorstudente;
//file
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servletFormDomanda.
 */
@WebServlet("/ServletFormDomanda")
public class ServletFormDomanda extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletFormDomanda() {}

  /**
   * Richiama i dati del form della domanda.
   * @see HttpServlet#doGet(HttpServletRequest request, 
   HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    request.setAttribute("Tutor", request.getParameter("tutor"));
    RequestDispatcher view = request.getRequestDispatcher("jsp/SezioneCompilaForm.jsp");
    view.forward(request, response);
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
