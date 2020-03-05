package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;
import model.Person;

/**
 * Servlet implementation class addEventServlet
 */
@WebServlet("/addEventServlet")
public class addEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PersonHelper ph = new PersonHelper();
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
		
		String[] selectedHost = request.getParameterValues("host");
		Person hostToAdd = null;
		if (selectedHost != null) 
		{ 
			hostToAdd = ph.searchForPersonById(Integer.parseInt(selectedHost[0]));
		}
		
		Event ev = new Event(eventName, ld, hostToAdd);
		EventHelper eh = new EventHelper();
		eh.insertEvent(ev);
		
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
