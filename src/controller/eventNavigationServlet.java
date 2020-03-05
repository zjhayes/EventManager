package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;
import model.Person;

/**
 * Servlet implementation class eventNavigationServlet
 */
@WebServlet("/eventNavigationServlet")
public class eventNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eventNavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String act = request.getParameter("doThis");
		EventHelper dao = new EventHelper();
		
		String path = "/viewEventServlet";
		
		try
		{
			if(act.equals("add"))
			{
				path = "/NewEventServlet";
			}
			else if(act.equals("edit"))
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Event toEdit = dao.searchForEventById(tempId);
				request.setAttribute("toEdit", toEdit);
				PersonHelper ph = new PersonHelper();
				List<Person>allPeople = ph.showAllPeople();
				request.setAttribute("PeopleToAdd", allPeople);
				path = "/edit-event.jsp";
			
			}
			else if(act.equals("delete"))
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Event toDelete = dao.searchForEventById(tempId);
				dao.deleteEvent(toDelete);
			}
		}
		catch(NumberFormatException ex)
		{
			request.setAttribute("error", ex.getMessage());
			path = "/error.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
