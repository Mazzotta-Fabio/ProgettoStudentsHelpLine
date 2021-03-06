package servletgestioneinterazionetutorstudente;

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

/**
 * Servlet implementation class ServletFormDomandaTutor.
 */
@WebServlet("/ServletFormDomandaTutor")
public class ServletFormDomandaTutor extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletFormDomandaTutor() {}

  /**
   * il metodo richiama i dati per caricare i dati della lista dei tutor.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    String materia = request.getParameter("materia");
    GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente();
    List<String> listaTutor = i.listaTutor(materia); 
    request.setAttribute("listaTutor", listaTutor);
    RequestDispatcher view = request.getRequestDispatcher("jsp/SezioneSelezionaTutor.jsp");
    view.forward(request, response);
  }
  
  /**
    * il metodo richiama il metodo doGet.
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
    doGet(request, response);
  }
}
