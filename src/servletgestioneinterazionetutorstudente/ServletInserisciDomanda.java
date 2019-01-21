package servletgestioneinterazionetutorstudente;

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
 * Servlet implementation class ServletInserisciDomanda.
 */
@WebServlet("/ServletInserisciDomanda.html")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50) 
public class ServletInserisciDomanda extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ServletInserisciDomanda() {}
  
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
   * il metodo chiama i dati dell'inserimento della domanda.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  
  @Override
  
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    GestioneInterazioneTutorStudente i = new ImpGestioneInterazioneTutorStudente();
    Part part = request.getPart("file");
    String url = extractFileName(part);
    String savePath  = i.upload(url);
	part.write(savePath + File.separator);
    String emailT = request.getParameter("tutor");
    String oggetto = request.getParameter("oggetto");
    String testo = request.getParameter("testo");
    HttpSession session = request.getSession();
    String emailS = (String) session.getAttribute("email");
    String pass = (String) session.getAttribute("pass");
    String tipo = (String) session.getAttribute("tipo");
    i.inserisciDomanda(oggetto,testo,url,emailT,emailS);
    RequestDispatcher forward = request.getServletContext().getRequestDispatcher("/Login?email=" 
        + emailS  + "&password=" + pass + "&tipoUtente=" + tipo);
    forward.forward(request, response);
  }

  /**
* il metodo richiama il metodo doGet.
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
  
  @Override

  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException {
    doGet(request, response);
  }
}
