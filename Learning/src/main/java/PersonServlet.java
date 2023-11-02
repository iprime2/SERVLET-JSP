

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;

/**
 * Servlet implementation class Person
 */
@WebServlet(name = "PersonServlet", urlPatterns="/person")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @param i 
     * @param lastName 
     * @param firstName 
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		
		StringBuilder error = new StringBuilder();
		
		if(firstName == null) {
			error.append("A first Name was not provided");
		}else if(lastName == null) {
			error.append("A last Name was not provided");
		}else if(age == null) {
			error.append("A age was not provided");
		}
		
		if(error.length() > 0) {
			request.setAttribute("error", error.toString());
			request.setAttribute("person", new Person());
			
		}else {
			request.setAttribute("person", new Person(firstName,lastName,Integer.parseInt(age)));
		}
		
		getServletContext().getRequestDispatcher("/name.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
