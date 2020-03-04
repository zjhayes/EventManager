package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;

/**
 * Servlet implementation class EditEmployeeServlet
 */
@WebServlet("/editEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEmployeeServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PersonHelper dao = new PersonHelper();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Person toUpdate = dao.searchForPersonById(tempId);
		toUpdate.setFirstName(firstName);
		toUpdate.setLastName(lastName);
		
		dao.updatePerson(toUpdate);
		
		getServletContext().getRequestDispatcher("/viewEmployeesServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
