package servletGestioneDomanda;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import gestioneDomanda.GestioneDomanda;
import gestioneDomanda.ImpGestioneDomanda;

/**
 * La classe ServletScaricaAllegato è una Servlet.
 * Questa classe permette di scaricare un allegato nella cartella dowloads.
 * @author Antonio Cimino
 * @version 1.0
 */
@WebServlet("/ScaricaAllegato")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50) 
public class ServletScaricaAllegato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletScaricaAllegato() {}

    /**
  	 * Il metodo serve per scaricare l'allegato corrispondente all'url.
  	 * @param request: contiene tutti i parametri passati nella richiesta tramite GET
  	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getParameter("url");
		GestioneDomanda g = new ImpGestioneDomanda();
	    g.scaricaAllegato(path);
	    int idD = Integer.parseInt(request.getParameter("idD"));
	    RequestDispatcher forward = request.getServletContext().getRequestDispatcher("/ServletVisualizzaDomanda?id="+idD);
		forward.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
