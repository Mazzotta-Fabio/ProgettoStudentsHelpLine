package servletgestionedomanda;

import gestioneinterazionetutorstudente.GestioneInterazioneTutorStudente;
import gestioneinterazionetutorstudente.ImpGestioneInterazioneTutorStudente;

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
 * Servlet implementation class ServletInserisciRisposta.
 */
@WebServlet("/ServletInserisciRisposta.html")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50) 
public class ServletInserisciRisposta extends HttpServlet {
  private static final long serialVersionUID = 1L;   
  
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
   * Inserisce la risposta e ritorna al mioAccount.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente();
    Part part = request.getPart("file");
    String url = extractFileName(part);
    String savePath  = i.upload(url);
	  part.write(savePath + File.separator);
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
