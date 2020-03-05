package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;
import model.Person;

/**
 * Servlet implementation class editEventServlet
 */
@WebServlet("/editEventServlet")
public class editEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EventHelper eh = new EventHelper();
		PersonHelper ph = new PersonHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Event toUpdate = eh.searchForEventById(tempId);
		
		String eventName = request.getParameter("Ename");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		LocalDate ld;
		try 
		{
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} 
		catch (NumberFormatException ex) 
		{
			ld = LocalDate.now();
		}
		
		Person hostToAdd = null;
		String selectedHost = request.getParameter("hostToAdd");
		
		if(selectedHost != null)
		{
			hostToAdd = ph.searchForPersonById(Integer.parseInt(selectedHost));
		}
		
		toUpdate.setName(eventName);
		toUpdate.setEventDate(ld);
		if(hostToAdd != null)
		{
			toUpdate.setHost(hostToAdd);
		}
		
		eh.updateEvent(toUpdate);
		
		
		getServletContext().getRequestDispatcher("/viewEventServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
