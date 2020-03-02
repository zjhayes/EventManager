package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;

/**
 * Servlet implementation class EmployeeNavigationServle
 */
@WebServlet("/employeeNavigationServlet")
public class EmployeeNavigationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeNavigationServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String act = request.getParameter("doThis");
		PersonHelper dao = new PersonHelper();
		
		String path = "/viewEmployeesServlet";
		
		try
		{
			if(act.equals("Add"))
			{
				path = "/add-employee.jsp";
			}
			else if(act.equals("Edit"))
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Person toEdit = dao.searchForPersonById(tempId);
				request.setAttribute("toEdit", toEdit);
				path = "/edit-employee.jsp";
			
			}
			else if(act.equals("Delete"))
			{
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Person toDelete = dao.searchForPersonById(tempId);
				dao.deletePerson(toDelete);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
