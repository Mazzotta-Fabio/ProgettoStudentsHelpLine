package servletGestioneDomanda;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classiComuni.Domanda;
import storage.FactoryDAO;
import storage.ObjectDAO;

/**
 * Servlet implementation class ServletEliminaDomanda
 */
@WebServlet("/ServletEliminaDomanda")
public class ServletEliminaDomanda extends HttpServlet {
	
    public ServletEliminaDomanda() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ID = Integer.parseInt(request.getParameter("id"));
		Domanda d = new Domanda (ID, null, null, null, null);
		
		FactoryDAO fd = new FactoryDAO();
		ObjectDAO o = fd.getObject("Domanda");
		o.cancellaDati(d);
		
		RequestDispatcher view = request.getRequestDispatcher("PaginaPrincipale.html");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
