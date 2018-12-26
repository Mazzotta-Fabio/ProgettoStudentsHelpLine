package servletGestioneDomanda;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import gestioneDomanda.GestioneDomanda;
import gestioneDomanda.ImpGestioneDomanda;

/**
 * Servlet implementation class ScaricaAllegato
 */
@WebServlet("/ScaricaAllegato")
public class ScaricaAllegato extends HttpServlet {

    public ScaricaAllegato() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getParameter("url");
		GestioneDomanda g = new ImpGestioneDomanda();
	    g.scaricaAllegato(path);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
