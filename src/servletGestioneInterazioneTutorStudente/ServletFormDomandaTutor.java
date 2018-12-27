package servletGestioneInterazioneTutorStudente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classiComuni.Domanda;
import classiComuni.Risposta;
import classiComuni.Studente;
import classiComuni.Tutor;
import storage.FactoryDAO;
import storage.ObjectDAO;

/**
 * Servlet implementation class ServletFormDomandaTutor
 */
@WebServlet("/ServletFormDomandaTutor")
public class ServletFormDomandaTutor extends HttpServlet {

    public ServletFormDomandaTutor() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String materia = request.getParameter("materia");
		
		FactoryDAO fd = new FactoryDAO();
		ObjectDAO o = fd.getObject("Tutor");
		List<Object> listaT = o.recuperaTutto();
		
		List<String> listaTutor = new ArrayList<String>();
		for(int i = 0;i<listaT.size();i++) {
		      Tutor t = (Tutor) listaT.get(i);
		      if (t.getMateriaDiCompetenza() == materia) {
		    	  listaTutor.add(t.getNome());
		    	  listaTutor.add(t.getCognome());
		      }
		}
		
		request.setAttribute("listaDomande", listaTutor);
		RequestDispatcher view = request.getRequestDispatcher("PaginaTutor.html");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
