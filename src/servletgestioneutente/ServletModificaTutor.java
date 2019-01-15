package servletgestioneutente;

import gestioneinterazionetutorstudente.GestioneInterazioneTutorStudente;
import gestioneinterazionetutorstudente.ImpGestioneInterazioneTutorStudente;
import gestioneutente.GestioneUtente;
import gestioneutente.ImpGestioneUtente;
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



/**
 * La classe ModificaTutor è una Servlet.
 * Questa classe permette di modificare i dati del Tutor tramite DAO su DataBase.
 * @author Antonio Cimino
 * @version 1.0
 */

@WebServlet("/ModificaTutor.html")
public class ServletModificaTutor extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletModificaTutor() {}

  /**
* Il metodo serve per recuperare i dati del Tutor e passarli 
* alla classi DAO per modificarli sul DataBase.
* @param request contiene tutti i parametri passati nella richiesta tramite GET
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    String tipo = (String) session.getAttribute("tipo");
    String nome = request.getParameter("nome");
    String cognome = request.getParameter("cognome");
    String email = (String) session.getAttribute("email");
    String password = request.getParameter("password");
    Part linkImmagine = request.getPart("immagine");
    String numero = request.getParameter("numero");
    String materia = request.getParameter("materia");
    String voto = request.getParameter("voto");
    String titolo = request.getParameter("titolo");
    GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente();
    String url = request.getParameter("url");
    i.upload(url);
    GestioneUtente u = new ImpGestioneUtente();
    System.out.print(numero);
    u.modificaAccount(tipo, nome, cognome, email, password, url, voto, titolo, numero, materia);
    RequestDispatcher fo = request.getServletContext().getRequestDispatcher("/Login?email=" + email 
            + "&password=" + password + "&tipoUtente=" + tipo);
    fo.forward(request, response);
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