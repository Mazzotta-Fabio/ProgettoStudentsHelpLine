package servletgestioneutente;

import gestioneinterazionetutorstudente.GestioneInterazioneTutorStudente;
import gestioneinterazionetutorstudente.ImpGestioneInterazioneTutorStudente;
import gestioneutente.GestioneUtente;
import gestioneutente.ImpGestioneUtente;

import java.io.File;
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
 * La classe ModificaStudente � una Servlet.
 * Questa classe permette di modificare i dati dello Studente tramite DAO su DataBase.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/ModificaStudente.html")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50) 
public class ServletModificaStudente extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletModificaStudente() {}

  
  private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String [] items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				return s.substring(s.lastIndexOf("=")+2,s.length()-1);
			}
		}
    return "";
  }
  /**
* Il metodo serve per recuperare i dati dello Studente e 
* passarli alla classi DAO per modificarli sul DataBase.
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
    GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente();
    GestioneUtente u = new ImpGestioneUtente();
    if (tipo.equals("Studente")) {
      String matricola = request.getParameter("matricola");
      String annoCorso = request.getParameter("annocorso");
      Part part = request.getPart("fileS");
      String url = extractFileName(part);
      String savePath  = i.upload(url);
	  part.write(savePath + File.separator);
      u.modificaAccount(tipo, nome, cognome, email, password, url, matricola,
          annoCorso,null, null);
    } else {
      String numero = request.getParameter("numero");
      String materia = request.getParameter("materia");
      String voto = request.getParameter("voto");
      String titolo = request.getParameter("titolo");
      Part part = request.getPart("fileT");
      String url = extractFileName(part);
      String savePath  = i.upload(url);
	  part.write(savePath + File.separator);
      u.modificaAccount(tipo, nome, cognome, email, password, url, voto, titolo, numero, materia);
    }
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
