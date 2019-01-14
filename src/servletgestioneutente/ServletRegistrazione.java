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
import javax.servlet.http.Part;

/**
 * La classe RegistrazioneTutor è una Servlet.
 * Questa classe permette di recuperare i dati del Tutor 
 * dalla pagina Registrazione.html e passarli al DAO
 * per farli inserire nel DataBase.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/Registrazione")
public class ServletRegistrazione extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletRegistrazione() {}

  /**
* Il metodo serve per recuperare i dati del Tutor e 
* passarli alla classi DAO per inserirli nel DataBase.
* @param request contiene tutti i parametri passati nella richiesta tramite GET
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String tipo = request.getParameter("tipo");
    String nome = request.getParameter("nome");
    String cognome = request.getParameter("cognome");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente();
    String url = request.getParameter("url");
    i.upload(url);
    GestioneUtente u = new ImpGestioneUtente();
    if (tipo.equals("Tutor")) {
      String numero = request.getParameter("numero");
      String materia = request.getParameter("materia");
      String voto = request.getParameter("voto");
      String titolo = request.getParameter("titolo");
      u.registraAccount(tipo,nome, cognome, email, password,url, voto, titolo,numero,materia);
    } else {
      String matricola = request.getParameter("matricola");
      String annoCorso = request.getParameter("annoCorso");
      u.registraAccount(tipo,nome, cognome, email, password, url, matricola, annoCorso,null,null);
    }
    RequestDispatcher view = request.getRequestDispatcher("html/HomePage.html");
    view.forward(request, response);
  }
  
  /**
* richiama doGet.
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

}
